package hospital.staff;

// ═══════════════════════════════════════════════════════════════════
// CLASS — Doctor  (hospital.staff)
// Extends: HospitalStaff
// ═══════════════════════════════════════════════════════════════════

/**
 * PURPOSE:
 *   Represents a hospital doctor. Extends HospitalStaff to inherit name/staffId
 *   and must override the abstract getRole() method.
 *
 * CONCEPT — calling super() in subclass constructor:
 *   The first line of every subclass constructor MUST call super(...) to initialize
 *   the parent class fields (name, staffId). Forgetting this causes a compile error.
 */
class Doctor extends HospitalStaff {

    private String specialization;   // e.g., "Cardiology", "Neurology"
    private int    yearsOfExperience;

    /**
     * @param name               doctor's full name
     * @param staffId            unique staff ID
     * @param specialization     medical specialization
     * @param yearsOfExperience  years in practice
     */
    public Doctor(String name, String staffId, String specialization, int yearsOfExperience) {
        super(name, staffId); // initialize parent fields
        this.specialization    = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Returns a descriptive role string.
     * CONCEPT — @Override: the compiler verifies this matches the abstract method signature.
     */
    @Override
    public String getRole() {
        return "Doctor – " + specialization + " (" + yearsOfExperience + " yrs exp)";
    }

    public String getSpecialization()   { return specialization; }
    public int    getYearsOfExperience() { return yearsOfExperience; }
}


// ═══════════════════════════════════════════════════════════════════
// CLASS — Nurse  (hospital.staff)
// Extends: HospitalStaff
// ═══════════════════════════════════════════════════════════════════

/**
 * PURPOSE:
 *   Represents a nurse, with shift and ward assignment details.
 *   Like Doctor, inherits from HospitalStaff and overrides getRole().
 *
 * CONCEPT — Two sibling classes from one parent:
 *   Doctor and Nurse both extend HospitalStaff. This means a single
 *   HospitalStaff reference can hold either:
 *       HospitalStaff s = new Nurse(...);
 *       s.getRole(); // calls Nurse's getRole() at runtime — polymorphism!
 */
class Nurse extends HospitalStaff {

    private String shift;        // "Morning", "Evening", or "Night"
    private String assignedWard; // which ward this nurse is assigned to

    /**
     * @param name         nurse's full name
     * @param staffId      unique staff ID
     * @param shift        work shift (Morning / Evening / Night)
     * @param assignedWard name of the ward the nurse serves
     */
    public Nurse(String name, String staffId, String shift, String assignedWard) {
        super(name, staffId); // initialize parent fields
        this.shift        = shift;
        this.assignedWard = assignedWard;
    }

    @Override
    public String getRole() {
        return "Nurse – " + shift + " shift | Ward: " + assignedWard;
    }

    public String getShift()        { return shift; }
    public String getAssignedWard() { return assignedWard; }
}
