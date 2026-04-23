package hospital.staff;

/**
 * CLASS — Department  (package: hospital.staff)
 *
 * PURPOSE:
 *   Groups doctors and nurses under a named hospital department.
 *   Uses fixed-size arrays (size decided at construction) for each staff type.
 *
 * CONCEPT — Composition (has-a) vs Inheritance (is-a):
 *   Department does NOT extend HospitalStaff — a department is NOT a type of staff.
 *   Instead, Department CONTAINS staff arrays. This is "composition":
 *       Department "has" Doctors and Nurses.
 *   Always ask: "Is a Department a HospitalStaff?" → No → use composition, not inheritance.
 *
 * CONCEPT — Polymorphism with HospitalStaff array:
 *   The displayAll() method iterates HospitalStaff[] arrays and calls display()
 *   on each element. At runtime, Java calls the correct subclass's display(),
 *   which calls getRole() — which returns Doctor-specific or Nurse-specific text.
 *   This is dynamic dispatch / runtime polymorphism in action.
 */
public class Department {

    private String departmentName;

    // Fixed-size arrays — size is set at Department creation
    private Doctor[] doctors;
    private Nurse[]  nurses;

    // Tracks how many have been added so far (to avoid null entries)
    private int doctorCount = 0;
    private int nurseCount  = 0;

    /**
     * @param departmentName  name of the department (e.g., "Cardiology Dept")
     * @param maxDoctors      max doctors this department can hold
     * @param maxNurses       max nurses this department can hold
     */
    public Department(String departmentName, int maxDoctors, int maxNurses) {
        this.departmentName = departmentName;
        this.doctors        = new Doctor[maxDoctors];
        this.nurses         = new Nurse[maxNurses];
    }

    /**
     * Adds a Doctor to the department if capacity allows.
     * @param d the Doctor to add
     */
    public void addDoctor(Doctor d) {
        if (doctorCount < doctors.length) {
            doctors[doctorCount++] = d;
            System.out.println("  Dr. " + d.getName() + " added to " + departmentName + ".");
        } else {
            System.out.println("  Doctor capacity full for " + departmentName + "!");
        }
    }

    /**
     * Adds a Nurse to the department if capacity allows.
     * @param n the Nurse to add
     */
    public void addNurse(Nurse n) {
        if (nurseCount < nurses.length) {
            nurses[nurseCount++] = n;
            System.out.println("  Nurse " + n.getName() + " added to " + departmentName + ".");
        } else {
            System.out.println("  Nurse capacity full for " + departmentName + "!");
        }
    }

    /**
     * Displays all staff under this department.
     *
     * CONCEPT — Polymorphic display:
     *   doctors[i].display() calls HospitalStaff.display(), which internally
     *   calls getRole() — which is overridden differently in Doctor vs Nurse.
     *   This is runtime polymorphism: the correct version is chosen at execution.
     */
    public void displayAll() {
        System.out.println("\n  ┌═══ Department: " + departmentName + " ═══");
        System.out.println("  ├── Doctors (" + doctorCount + "):");
        if (doctorCount == 0) {
            System.out.println("  │    (none)");
        } else {
            for (int i = 0; i < doctorCount; i++) doctors[i].display();
        }
        System.out.println("  ├── Nurses (" + nurseCount + "):");
        if (nurseCount == 0) {
            System.out.println("  │    (none)");
        } else {
            for (int i = 0; i < nurseCount; i++) nurses[i].display();
        }
        System.out.println("  └─────────────────────────────────");
    }

    // Expose constructors to Main.java for input handling
    /** Factory: creates a Doctor object — called from Main to avoid package issues. */
    public static Doctor createDoctor(String name, String id, String spec, int exp) {
        return new Doctor(name, id, spec, exp);
    }

    /** Factory: creates a Nurse object — called from Main to avoid package issues. */
    public static Nurse createNurse(String name, String id, String shift, String ward) {
        return new Nurse(name, id, shift, ward);
    }
}
