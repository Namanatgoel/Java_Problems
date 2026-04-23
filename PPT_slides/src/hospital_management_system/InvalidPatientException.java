package hospital.core;

/**
 * CUSTOM EXCEPTION — InvalidPatientException
 *
 * PURPOSE:
 *   Thrown inside dischargePatient() when the given patientId does not match
 *   any patient currently admitted in the ward.
 *
 * IMPORTANT DESIGN NOTE:
 *   Notice that the HospitalOperations interface declares:
 *       void dischargePatient(int patientId) throws InvalidPatientException;
 *
 *   This means the interface itself *contracts* that all implementing classes
 *   MUST propagate this exception. The caller (Main.java) is then forced by
 *   the compiler to wrap the call in a try-catch block.
 */
public class InvalidPatientException extends Exception {

    public InvalidPatientException(String message) {
        super(message);
    }
}
