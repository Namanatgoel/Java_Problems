package hospital.core;

/**
 * CLASS — Patient  (package: hospital.core)
 *
 * PURPOSE:
 *   Represents a hospital patient with validated attributes.
 *   All validation happens inside the constructor — if any field is invalid,
 *   an exception is thrown and the object is NEVER created.
 *   This is called "fail-fast" design: bad data never enters the system.
 *
 * VALIDATION RULES:
 *   1. patientId  → must match regex "PAT\d{3}"  (PAT + exactly 3 digits)
 *   2. name       → only letters, exactly one space between words
 *   3. age        → must be > 0
 *   4. billAmount → must be >= 0 (a bill of 0 is valid, negative is not)
 *
 * CONCEPT — Regex used here:
 *   "PAT\\d{3}"               matches PAT followed by exactly 3 digit characters
 *   "[A-Za-z]+(\\s[A-Za-z]+)*" matches one word, then zero or more (space + word) pairs
 *                              This ensures no double spaces and no leading/trailing spaces
 */
public class Patient {

    // All fields are private — only accessible via getters (encapsulation)
    private String patientId;   // e.g., "PAT001"
    private String name;        // e.g., "Ramesh Kumar"
    private int    age;         // must be > 0
    private String diagnosis;   // e.g., "Cardiac Arrest"
    private double billAmount;  // base bill in rupees, must be >= 0

    /**
     * Parameterized constructor with full field validation.
     *
     * CONCEPT — Constructor throws (doesn't catch):
     *   This constructor declares "throws InvalidAdmissionDataException".
     *   It does NOT catch the exception itself — it propagates it to the caller.
     *   The caller (Main.java) is responsible for wrapping this in try-catch.
     *
     * @throws InvalidAdmissionDataException if any field fails validation
     */
    public Patient(String patientId, String name, int age,
                   String diagnosis, double billAmount)
            throws InvalidAdmissionDataException {

        // --- Validate patientId ---
        // matches() checks the ENTIRE string against the regex pattern
        // "PAT\\d{3}" = literal "PAT" followed by exactly 3 digits (0-9)
        if (!patientId.matches("PAT\\d{3}")) {
            throw new InvalidAdmissionDataException(
                "Invalid patient ID '" + patientId + "'. Must be 'PAT' followed by 3 digits (e.g., PAT001)."
            );
        }

        // --- Validate name ---
        // "[A-Za-z]+(\\s[A-Za-z]+)*" means:
        //   [A-Za-z]+       → one or more letters (first word)
        //   (\\s[A-Za-z]+)* → zero or more groups of: exactly one space + more letters
        // This rejects: "Ram  Kumar" (double space), "Ram123" (digit), " Ram" (leading space)
        if (!name.matches("[A-Za-z]+(\\s[A-Za-z]+)*")) {
            throw new InvalidAdmissionDataException(
                "Invalid name '" + name + "'. Must contain only letters with single spaces between words."
            );
        }

        // --- Validate age ---
        if (age <= 0) {
            throw new InvalidAdmissionDataException(
                "Invalid age " + age + ". Age must be a positive number."
            );
        }

        // --- Validate billAmount ---
        if (billAmount < 0) {
            throw new InvalidAdmissionDataException(
                "Invalid bill amount " + billAmount + ". Bill cannot be negative."
            );
        }

        // All validations passed — safe to assign
        this.patientId  = patientId;
        this.name       = name;
        this.age        = age;
        this.diagnosis  = diagnosis;
        this.billAmount = billAmount;
    }

    // ─── Public Getters ───────────────────────────────────────────────────────
    // No setters provided — Patient data is immutable after creation

    public String getPatientId()  { return patientId; }
    public String getName()       { return name; }
    public int    getAge()        { return age; }
    public String getDiagnosis()  { return diagnosis; }
    public double getBillAmount() { return billAmount; }

    /**
     * Extracts the numeric portion of the patientId for easy integer comparisons.
     * E.g., "PAT042" → 42
     * Used in dischargePatient() to match by integer ID.
     */
    public int getNumericId() {
        return Integer.parseInt(patientId.substring(3)); // skip "PAT", parse digits
    }

    /** Neatly prints all patient details. */
    public void display() {
        System.out.printf("  [%s] %-20s | Age: %3d | Diagnosis: %-20s | Bill: Rs.%.2f%n",
                patientId, name, age, diagnosis, billAmount);
    }
}
