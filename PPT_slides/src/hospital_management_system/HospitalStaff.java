package hospital_management_system;

/**
 * ABSTRACT CLASS — HospitalStaff  (package: hospital.staff)
 *
 * PURPOSE:
 *   Common blueprint for all hospital personnel. Every staff member has a name
 *   and staffId. The getRole() method is abstract because each type of staff
 *   returns a different role string.
 *
 * CONCEPT — Separate package for staff:
 *   Organizing staff classes into hospital.staff keeps concerns separated.
 *   Core ward logic (hospital.core) and admin tools (hospital.admin) don't need
 *   to know the internals of staff management.
 *
 * CONCEPT — Abstract class vs Interface for staff:
 *   We use an abstract class (not interface) here because staff members SHARE
 *   real data (name, staffId) and real behavior. Interfaces can't hold state.
 *   Abstract classes are the right tool when you have shared state + one or more
 *   methods that vary by subtype.
 */
public abstract class HospitalStaff {

    protected String name;    // e.g., "Dr. Anita Rao"
    protected String staffId; // e.g., "S001"

    /**
     * @param name    full name of the staff member
     * @param staffId unique staff identifier
     */
    public HospitalStaff(String name, String staffId) {
        this.name    = name;
        this.staffId = staffId;
    }

    // Getters
    public String getName()    { return name; }
    public String getStaffId() { return staffId; }

    /**
     * Abstract method — each subclass (Doctor, Nurse) returns its own role label.
     * This enables polymorphism: HospitalStaff s = new Doctor(...)
     *                            s.getRole() → "Doctor – Cardiology"
     *
     * @return a descriptive role string for display
     */
    public abstract String getRole();

    /** Prints a formatted summary line for this staff member. */
    public void display() {
        System.out.printf("  [%s] %-25s | Role: %s%n", staffId, name, getRole());
    }
}
