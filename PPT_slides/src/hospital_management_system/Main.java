import hospital.core.*;
import hospital.admin.RemoteMonitoring;
import hospital.staff.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * MAIN CLASS — Entry point for the Smart Hospital Management System
 *
 * CONCEPTS DEMONSTRATED HERE:
 *   1. Menu-driven program using do-while + switch
 *   2. Dynamic polymorphism via MedicalUnit[] reference array
 *   3. Cross-package usage (hospital.core, hospital.admin, hospital.staff)
 *   4. try-catch for custom checked exceptions
 *   5. Inner class instantiation (ICU.VentilatorStatus)
 *   6. Interface reference (RemoteMonitoring) for polymorphism
 *   7. Static method call (MedicalUnit.getUnitCount())
 *
 * STRUCTURE:
 *   main() → do-while loop → switch → one helper method per case
 *   Each helper method handles its own Scanner input and try-catch.
 *   This keeps main() clean and readable.
 */
public class Main {

    // ─── Shared state ─────────────────────────────────────────────────────────

    // We store wards as MedicalUnit references — this enables polymorphism.
    // The actual objects are GeneralWard or ICU, but the reference type is MedicalUnit.
    private static ArrayList<MedicalUnit> wards      = new ArrayList<>();
    private static ArrayList<Department>  departments = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // ─── Entry Point ──────────────────────────────────────────────────────────

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   SMART HOSPITAL MANAGEMENT SYSTEM           ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        int choice;
        do {
            printMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            // switch expression (Java 14+) — cleaner than switch-case-break
            switch (choice) {
                case 1 -> addWard();
                case 2 -> admitPatient();
                case 3 -> dischargePatient();
                case 4 -> displayWardDetails();
                case 5 -> showTotalBill();
                case 6 -> addStaffToDepartment();
                case 7 -> displayDepartment();
                case 8 -> icuRemoteDemo();
                case 9 -> polymorphismDemo();
                case 0 -> System.out.println("\nGoodbye! Total wards created: "
                                + MedicalUnit.getUnitCount()); // static method call
                default -> System.out.println("  Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    // ─── Menu Printer ─────────────────────────────────────────────────────────

    private static void printMenu() {
        System.out.println("\n┌────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                │");
        System.out.println("├────────────────────────────────────┤");
        System.out.println("│ 1. Add Ward (General / ICU)        │");
        System.out.println("│ 2. Admit Patient to Ward           │");
        System.out.println("│ 3. Discharge Patient from Ward     │");
        System.out.println("│ 4. Display Ward Details            │");
        System.out.println("│ 5. Show Total Bill of a Ward       │");
        System.out.println("│ 6. Add Staff to Department         │");
        System.out.println("│ 7. Display Department Details      │");
        System.out.println("│ 8. ICU Remote Monitor Demo         │");
        System.out.println("│ 9. Polymorphism Demo               │");
        System.out.println("│ 0. Exit                            │");
        System.out.println("└────────────────────────────────────┘");
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 1 — Add Ward
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Creates a GeneralWard or ICU and adds it to the wards list.
     *
     * CONCEPT: The ward is stored as a MedicalUnit reference — the actual object
     *          is GeneralWard or ICU. This is the foundation of polymorphism.
     */
    private static void addWard() {
        System.out.println("\n  Ward Type: 1 = General Ward, 2 = ICU");
        System.out.print("  Choice: ");
        int type = sc.nextInt(); sc.nextLine();

        System.out.print("  Unit ID (e.g., GW01): ");
        String uid = sc.nextLine();
        System.out.print("  Unit Name: ");
        String uname = sc.nextLine();
        System.out.print("  Capacity: ");
        int cap = sc.nextInt(); sc.nextLine();

        if (type == 1) {
            System.out.print("  Rate per Day (Rs.): ");
            double rate = sc.nextDouble(); sc.nextLine();

            // Stored as MedicalUnit reference — polymorphism!
            GeneralWard gw = new GeneralWard(uid, uname, cap, rate);
            wards.add(gw);

        } else if (type == 2) {
            System.out.print("  Charge Multiplier (e.g., 2.0): ");
            double mult = sc.nextDouble(); sc.nextLine();

            ICU icu = new ICU(uid, uname, cap, mult);
            wards.add(icu);

        } else {
            System.out.println("  Invalid ward type.");
        }

        System.out.println("  Total wards created so far: " + MedicalUnit.getUnitCount());
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 2 — Admit Patient
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Takes patient details from user, creates a Patient object (with validation),
     * then admits to the selected ward.
     *
     * CONCEPT — try-catch for constructor exception:
     *   Patient constructor throws InvalidAdmissionDataException if data is bad.
     *   We catch it here and print the error — the patient object is never created.
     */
    private static void admitPatient() {
        MedicalUnit ward = selectWard();
        if (ward == null) return;

        System.out.print("  Patient ID (e.g., PAT001): ");
        String pid = sc.nextLine();
        System.out.print("  Name: ");
        String name = sc.nextLine();
        System.out.print("  Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("  Diagnosis: ");
        String diag = sc.nextLine();
        System.out.print("  Bill Amount (Rs.): ");
        double bill = sc.nextDouble(); sc.nextLine();

        try {
            // Constructor validates all fields and throws if anything is wrong
            Patient p = new Patient(pid, name, age, diag, bill);

            // Call via HospitalOperations interface — both wards implement it
            // The cast is safe because all wards in our list implement HospitalOperations
            ((HospitalOperations) ward).admitPatient(p);

        } catch (InvalidAdmissionDataException e) {
            System.out.println("  ❌ Admission failed: " + e.getMessage());
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 3 — Discharge Patient
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Discharges a patient by their numeric ID from a selected ward.
     *
     * CONCEPT — catching a custom exception:
     *   dischargePatient() throws InvalidPatientException when the ID doesn't match.
     *   We MUST catch it here (it's a checked exception declared in the interface).
     */
    private static void dischargePatient() {
        MedicalUnit ward = selectWard();
        if (ward == null) return;

        System.out.print("  Enter Patient numeric ID to discharge (e.g., 1 for PAT001): ");
        int pid = sc.nextInt(); sc.nextLine();

        try {
            ((HospitalOperations) ward).dischargePatient(pid);
        } catch (InvalidPatientException e) {
            // Exception thrown — patient not found
            System.out.println("  ❌ Discharge failed: " + e.getMessage());
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 4 — Display Ward Details
    // ═══════════════════════════════════════════════════════════════════════════

    private static void displayWardDetails() {
        if (wards.isEmpty()) { System.out.println("  No wards added yet."); return; }
        MedicalUnit ward = selectWard();
        if (ward != null) ((HospitalOperations) ward).displayWardDetails();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 5 — Show Total Bill
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates calling the abstract method calculateTotalBill() through
     * a MedicalUnit reference — runtime polymorphism determines which version runs.
     */
    private static void showTotalBill() {
        MedicalUnit ward = selectWard();
        if (ward == null) return;

        // calculateTotalBill() is abstract in MedicalUnit.
        // The JVM decides at RUNTIME whether to call GeneralWard's or ICU's version.
        // This is DYNAMIC DISPATCH — the core of runtime polymorphism.
        double total = ward.calculateTotalBill();
        System.out.printf("  Total Bill for [%s]: Rs.%.2f%n", ward.getUnitName(), total);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 6 — Add Staff to Department
    // ═══════════════════════════════════════════════════════════════════════════

    private static void addStaffToDepartment() {
        // Create or select department
        Department dept = selectOrCreateDepartment();
        if (dept == null) return;

        System.out.println("  Add: 1 = Doctor, 2 = Nurse");
        System.out.print("  Choice: ");
        int choice = sc.nextInt(); sc.nextLine();

        if (choice == 1) {
            System.out.print("  Doctor Name: ");    String name = sc.nextLine();
            System.out.print("  Staff ID: ");       String sid  = sc.nextLine();
            System.out.print("  Specialization: "); String spec = sc.nextLine();
            System.out.print("  Years of Exp: ");   int exp = sc.nextInt(); sc.nextLine();

            // Using factory method to avoid package-private constructor issues
            dept.addDoctor(Department.createDoctor(name, sid, spec, exp));

        } else if (choice == 2) {
            System.out.print("  Nurse Name: ");     String name  = sc.nextLine();
            System.out.print("  Staff ID: ");       String sid   = sc.nextLine();
            System.out.print("  Shift (Morning/Evening/Night): "); String shift = sc.nextLine();
            System.out.print("  Assigned Ward: ");  String ward  = sc.nextLine();

            dept.addNurse(Department.createNurse(name, sid, shift, ward));
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 7 — Display Department
    // ═══════════════════════════════════════════════════════════════════════════

    private static void displayDepartment() {
        if (departments.isEmpty()) { System.out.println("  No departments created."); return; }
        System.out.println("  Select department:");
        for (int i = 0; i < departments.size(); i++)
            System.out.println("  " + i + ". " + departments.get(i).getClass().getName());
        // Using displayAll which internally calls polymorphic getRole()
        departments.forEach(Department::displayAll);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 8 — ICU Remote Monitor Demo
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates:
     *   1. RemoteMonitoring interface usage via ICU
     *   2. Inner class VentilatorStatus instantiation
     *
     * CONCEPT — Interface reference:
     *   We cast the ward to RemoteMonitoring and call its methods.
     *   This is polymorphism via interface — the caller only sees the interface,
     *   not the ICU implementation details.
     */
    private static void icuRemoteDemo() {
        // Find the first ICU in the wards list
        ICU icu = null;
        for (MedicalUnit w : wards) {
            if (w instanceof ICU) { icu = (ICU) w; break; }
        }

        if (icu == null) {
            System.out.println("  No ICU ward found. Please add an ICU first (Option 1).");
            return;
        }

        System.out.println("\n  --- Remote Monitoring Demo ---");

        // Use RemoteMonitoring interface reference — demonstrates interface polymorphism
        RemoteMonitoring rm = icu; // ICU IS-A RemoteMonitoring
        rm.remoteCheck();
        rm.sendAlert("Elevated heart rate detected in ICU. Nurse to attend immediately.");

        // Inner class demo
        System.out.println("\n  --- Ventilator Status Inner Class Demo ---");
        System.out.print("  Enter patient breathing rate (breaths/min): ");
        int rate = sc.nextInt(); sc.nextLine();

        // INNER CLASS INSTANTIATION: requires an instance of the outer class (icu)
        // Syntax: outerObject.new InnerClass(args)
        ICU.VentilatorStatus vs = icu.new VentilatorStatus(rate);
        vs.getStatus();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CASE 9 — Polymorphism Demo
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * CONCEPT — Dynamic Polymorphism:
     *   All wards are stored in a MedicalUnit[] (parent type).
     *   When we call ward.calculateTotalBill() or ward.displayWardDetails(),
     *   Java uses the actual object type (GeneralWard or ICU) to decide which
     *   method implementation to run — at RUNTIME, not compile time.
     *   This is the essence of polymorphism.
     */
    private static void polymorphismDemo() {
        if (wards.isEmpty()) {
            System.out.println("  Add at least one ward first to see polymorphism demo.");
            return;
        }

        System.out.println("\n  === Dynamic Polymorphism Demo ===");
        System.out.println("  Iterating all wards using MedicalUnit parent reference:");

        // All wards iterated as MedicalUnit — actual method called depends on runtime type
        for (MedicalUnit ward : wards) {
            System.out.println("\n  Ward type at runtime: " + ward.getClass().getSimpleName());
            System.out.printf("  calculateTotalBill() result: Rs.%.2f%n", ward.calculateTotalBill());

            // instanceof check before casting — safe downcast
            if (ward instanceof ICU icuWard) {
                System.out.println("  (This is an ICU — also has RemoteMonitoring capabilities)");
                icuWard.remoteCheck();
            }
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // HELPER METHODS
    // ═══════════════════════════════════════════════════════════════════════════

    /** Lists all wards and returns the one the user picks. */
    private static MedicalUnit selectWard() {
        if (wards.isEmpty()) {
            System.out.println("  No wards available. Add a ward first (Option 1).");
            return null;
        }
        System.out.println("  Select ward:");
        for (int i = 0; i < wards.size(); i++) {
            System.out.println("  " + i + ". [" + wards.get(i).getUnitId() + "] "
                    + wards.get(i).getUnitName()
                    + " (" + wards.get(i).getClass().getSimpleName() + ")");
        }
        System.out.print("  Ward index: ");
        int idx = sc.nextInt(); sc.nextLine();
        if (idx < 0 || idx >= wards.size()) {
            System.out.println("  Invalid index."); return null;
        }
        return wards.get(idx);
    }

    /** Returns an existing or newly created Department. */
    private static Department selectOrCreateDepartment() {
        if (!departments.isEmpty()) {
            System.out.println("  0. Create new department");
            for (int i = 0; i < departments.size(); i++)
                System.out.println("  " + (i + 1) + ". Select existing dept " + (i + 1));
            System.out.print("  Choice: ");
            int c = sc.nextInt(); sc.nextLine();
            if (c != 0 && c <= departments.size()) return departments.get(c - 1);
        }
        // Create new department
        System.out.print("  Department Name: ");
        String dname = sc.nextLine();
        System.out.print("  Max Doctors: ");    int md = sc.nextInt(); sc.nextLine();
        System.out.print("  Max Nurses: ");     int mn = sc.nextInt(); sc.nextLine();
        Department dept = new Department(dname, md, mn);
        departments.add(dept);
        return dept;
    }
}
