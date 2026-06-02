package hospital_management_system;

import hospital.admin.RemoteMonitoring; // importing interface from a DIFFERENT package
import java.util.ArrayList;

/**
 * CLASS — ICU  (package: hospital.core)
 * Extends: MedicalUnit
 * Implements: HospitalOperations, RemoteMonitoring
 *
 * PURPOSE:
 *   Intensive Care Unit — a specialized ward with a charge multiplier.
 *   Patients over 60 incur an additional 25% surcharge (multiplier bumped up).
 *
 * CONCEPT — Implementing multiple interfaces:
 *   A class can implement any number of interfaces by listing them comma-separated.
 *   ICU must provide implementations for ALL methods from BOTH interfaces:
 *     - admitPatient, dischargePatient, displayWardDetails (HospitalOperations)
 *     - remoteCheck, sendAlert (RemoteMonitoring)
 *
 * CONCEPT — Inner class (VentilatorStatus):
 *   An inner class is defined inside the outer class body.
 *   It has direct access to the outer class's instance members (like getUnitName()).
 *   It is instantiated from OUTSIDE using: icuRef.new VentilatorStatus(rate)
 *   It models something that BELONGS to the outer class and has no meaning standalone.
 */
public class ICU extends MedicalUnit implements HospitalOperations, RemoteMonitoring {

    // ─── ICU-specific attributes ──────────────────────────────────────────────

    private double            chargeMultiplier; // base = 2.0 (ICU costs 2x by default)
    private ArrayList<Patient> patients;

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * @param unitId           unique ward identifier (e.g., "ICU01")
     * @param unitName         display name
     * @param capacity         max patients
     * @param chargeMultiplier starting multiplier (typically 2.0 for ICU)
     */
    public ICU(String unitId, String unitName, int capacity, double chargeMultiplier) {
        super(unitId, unitName, capacity); // initialize MedicalUnit fields + unitCount++
        this.chargeMultiplier = chargeMultiplier;
        this.patients         = new ArrayList<>();
        turnOn(); // ICU is always operational
    }

    // ─── HospitalOperations Implementation ───────────────────────────────────

    /**
     * Admits a patient. If age > 60, increases chargeMultiplier by 25% for this ICU.
     *
     * CONCEPT — Conditional attribute modification at admission:
     *   The multiplier increase reflects a real-world policy: elderly patients in ICU
     *   require more resources. We modify the instance-level multiplier here.
     *   (In a more complex system, you might store per-patient multipliers.)
     */
    @Override
    public void admitPatient(Patient p) {
        if (patients.size() >= capacity) {
            System.out.println("  ICU [" + getUnitName() + "] is FULL! Cannot admit " + p.getName());
            return;
        }
        patients.add(p);
        System.out.println("  Patient " + p.getName() + " admitted to ICU [" + getUnitName() + "].");

        // Age-based multiplier adjustment
        if (p.getAge() > 60) {
            chargeMultiplier *= 1.25; // increase by 25%
            System.out.printf("  [Policy] Patient age > 60: ICU charge multiplier increased to %.2f%n",
                    chargeMultiplier);
        }
    }

    /**
     * Discharges patient by numeric ID. Throws InvalidPatientException if not found.
     * Same pattern as GeneralWard — loop, find, return; or throw after loop.
     */
    @Override
    public void dischargePatient(int patientId) throws InvalidPatientException {
        for (Patient p : patients) {
            if (p.getNumericId() == patientId) {
                patients.remove(p);
                System.out.println("  Patient [PAT" + String.format("%03d", patientId)
                        + "] discharged from ICU [" + getUnitName() + "].");
                return;
            }
        }
        // Loop ended without a match — patient not found
        throw new InvalidPatientException(
            "No patient with ID PAT" + String.format("%03d", patientId)
            + " found in ICU [" + getUnitName() + "]."
        );
    }

    /**
     * Displays ICU header and all patient details with multiplied bill amounts.
     */
    @Override
    public void displayWardDetails() {
        System.out.println("\n  ╔═══ ICU: " + getUnitName() + " ═══");
        System.out.println("  ║ ID: " + getUnitId() + " | Capacity: " + capacity
                + " | Multiplier: " + chargeMultiplier
                + "x | Status: " + (getStatus() ? "OPEN" : "CLOSED"));
        System.out.println("  ║ Patients (" + patients.size() + "):");
        if (patients.isEmpty()) {
            System.out.println("  ║   (No patients admitted)");
        } else {
            for (Patient p : patients) {
                System.out.printf("  ║  [%s] %-20s | Age: %3d | Base Bill: Rs.%.2f | ICU Bill: Rs.%.2f%n",
                        p.getPatientId(), p.getName(), p.getAge(),
                        p.getBillAmount(), p.getBillAmount() * chargeMultiplier);
            }
        }
        System.out.printf("  ╚═ Total ICU Bill: Rs.%.2f%n", calculateTotalBill());
    }

    // ─── MedicalUnit Abstract Method Implementation ───────────────────────────

    /**
     * Returns the total ICU bill = sum of (each patient's bill × chargeMultiplier).
     */
    @Override
    public double calculateTotalBill() {
        double total = 0;
        for (Patient p : patients) total += p.getBillAmount() * chargeMultiplier;
        return total;
    }

    // ─── RemoteMonitoring Implementation ─────────────────────────────────────

    /**
     * Performs a remote status check — prints current ICU occupancy and state.
     *
     * CONCEPT — Implementing from a cross-package interface:
     *   This method satisfies the RemoteMonitoring contract imported from hospital.admin.
     *   The caller can use it via a RemoteMonitoring reference for polymorphism.
     */
    @Override
    public void remoteCheck() {
        System.out.println("  [REMOTE CHECK] ICU '" + getUnitName() + "'"
                + " | Occupied: " + patients.size() + "/" + capacity
                + " | Status: " + (getStatus() ? "OPERATIONAL" : "CLOSED")
                + " | Multiplier: " + chargeMultiplier + "x");
    }

    /**
     * Broadcasts an alert message from this ICU.
     * @param message the alert content
     */
    @Override
    public void sendAlert(String message) {
        System.out.println("  [ALERT from " + getUnitName() + "]: " + message);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // INNER CLASS — VentilatorStatus
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * INNER CLASS — VentilatorStatus
     *
     * PURPOSE:
     *   Tracks the breathing rate of a patient on a ventilator in this ICU.
     *   Defined as an inner class because VentilatorStatus is meaningless outside
     *   of an ICU context — it intimately belongs to the ICU.
     *
     * CONCEPT — Inner class access:
     *   - Inner class can access outer class instance members directly (getUnitName())
     *   - Instantiated from outside using: icuObject.new VentilatorStatus(rate)
     *   - Inner class instance always holds an implicit reference to its outer instance
     *
     * Normal adult breathing rate: 12 to 20 breaths per minute.
     */
    public class VentilatorStatus {

        private int breathingRate; // breaths per minute

        /**
         * @param breathingRate current breathing rate in breaths/min
         */
        public VentilatorStatus(int breathingRate) {
            this.breathingRate = breathingRate;
        }

        /**
         * Evaluates and prints the ventilator status.
         * Accesses outer class method (getUnitName()) directly — no qualifier needed.
         */
        public void getStatus() {
            System.out.println("  [Ventilator | ICU: " + getUnitName() + "] Breathing Rate: "
                    + breathingRate + " breaths/min");
            if (breathingRate < 12) {
                System.out.println("  ⚠ WARNING: Breathing rate is BELOW normal range (<12). Immediate attention required!");
            } else if (breathingRate > 20) {
                System.out.println("  ⚠ WARNING: Breathing rate is ABOVE normal range (>20). Monitor closely!");
            } else {
                System.out.println("  ✓ Breathing rate is within normal range (12–20).");
            }
        }

        public int getBreathingRate() { return breathingRate; }
    }
    // ─── End of inner class ───────────────────────────────────────────────────
}
