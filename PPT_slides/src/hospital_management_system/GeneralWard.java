package hospital.core;

import java.util.ArrayList;

/**
 * CLASS — GeneralWard  (package: hospital.core)
 * Extends: MedicalUnit
 * Implements: HospitalOperations
 *
 * PURPOSE:
 *   A standard hospital ward. Patients pay a flat billAmount.
 *   Billing is a straight sum — no multipliers.
 *
 * CONCEPT — extends + implements together:
 *   Java allows one class to extend ONE parent AND implement MULTIPLE interfaces.
 *   GeneralWard gets all MedicalUnit's fields/methods AND must fulfill the
 *   HospitalOperations contract.
 *
 * CONCEPT — ArrayList vs Array:
 *   We use ArrayList<Patient> because the number of admitted patients changes
 *   dynamically (admits and discharges). A fixed array would waste space or
 *   require resizing manually.
 */
public class GeneralWard extends MedicalUnit implements HospitalOperations {

    // ─── GeneralWard-specific attribute ──────────────────────────────────────
    private double ratePerDay;   // base charge rate (informational, shown in display)

    // Dynamic list of currently admitted patients
    private ArrayList<Patient> patients;

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * @param unitId     unique ward identifier (e.g., "GW01")
     * @param unitName   display name (e.g., "Ground Floor General Ward")
     * @param capacity   maximum number of patients
     * @param ratePerDay base daily rate for this ward (informational)
     */
    public GeneralWard(String unitId, String unitName, int capacity, double ratePerDay) {
        // super() MUST be the first statement — initializes MedicalUnit fields
        // and increments the static unitCount
        super(unitId, unitName, capacity);
        this.ratePerDay = ratePerDay;
        this.patients   = new ArrayList<>();
        turnOn(); // general wards are open immediately upon creation
    }

    // ─── HospitalOperations Implementation ───────────────────────────────────

    /**
     * Admits a patient if the ward has available capacity.
     *
     * CONCEPT — implementing an interface method:
     *   @Override ensures the compiler verifies this method matches the
     *   interface signature exactly. If the signature doesn't match, compile error.
     */
    @Override
    public void admitPatient(Patient p) {
        if (patients.size() >= capacity) {
            System.out.println("  Ward [" + getUnitName() + "] is at full capacity! Cannot admit " + p.getName());
            return;
        }
        patients.add(p);
        System.out.println("  Patient " + p.getName() + " admitted to [" + getUnitName() + "].");
    }

    /**
     * Discharges a patient by their numeric ID.
     *
     * CONCEPT — where and when to throw:
     *   We loop through the entire list first.
     *   If found → remove and return immediately (no need to reach the throw).
     *   If the loop completes without finding → throw the exception.
     *   The throw MUST be AFTER the loop — a common mistake is putting it in an else
     *   inside the loop, which would throw after just the first non-match.
     *
     * @throws InvalidPatientException if patientId not found in this ward
     */
    @Override
    public void dischargePatient(int patientId) throws InvalidPatientException {
        for (Patient p : patients) {
            if (p.getNumericId() == patientId) {
                patients.remove(p);
                System.out.println("  Patient [PAT" + String.format("%03d", patientId)
                        + "] successfully discharged from [" + getUnitName() + "].");
                return; // found and removed — exit the method normally
            }
        }
        // Only reached if no patient matched
        throw new InvalidPatientException(
            "No patient with ID PAT" + String.format("%03d", patientId)
            + " found in ward [" + getUnitName() + "]."
        );
    }

    /**
     * Prints ward header info and all admitted patients.
     */
    @Override
    public void displayWardDetails() {
        System.out.println("\n  ┌─── General Ward: " + getUnitName() + " ───");
        System.out.println("  │ ID: " + getUnitId() + " | Capacity: " + capacity
                + " | Rate/Day: Rs." + ratePerDay
                + " | Status: " + (getStatus() ? "OPEN" : "CLOSED"));
        System.out.println("  │ Patients (" + patients.size() + "):");
        if (patients.isEmpty()) {
            System.out.println("  │   (No patients admitted)");
        } else {
            patients.forEach(p -> { System.out.print("  │ "); p.display(); });
        }
        System.out.println("  └─ Total Bill: Rs." + String.format("%.2f", calculateTotalBill()));
    }

    // ─── MedicalUnit Abstract Method Implementation ───────────────────────────

    /**
     * Simple sum of all patient bill amounts — no multipliers for general ward.
     */
    @Override
    public double calculateTotalBill() {
        double total = 0;
        for (Patient p : patients) total += p.getBillAmount();
        return total;
    }
}
