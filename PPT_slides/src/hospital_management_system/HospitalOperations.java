package hospital_management_system;

/**
 * INTERFACE — HospitalOperations  (package: hospital.core)
 *
 * PURPOSE:
 *   Defines the standard operations any ward type must support.
 *   Both GeneralWard and ICU implement this interface, ensuring they
 *   provide their own version of each method.
 *
 * KEY CONCEPT — throws in an interface method:
 *   When an interface method declares "throws SomeException", it creates a contract:
 *   every implementing class MUST either handle or re-declare the same exception.
 *   This forces safe, predictable error handling across all ward types.
 *
 * KEY CONCEPT — Why an interface instead of just abstract methods in MedicalUnit?
 *   Interfaces allow unrelated classes to share a common contract without
 *   forcing them into the same class hierarchy. If later we add a "MobileClinic"
 *   class that doesn't extend MedicalUnit, it can still implement HospitalOperations.
 */
public interface HospitalOperations {

    /**
     * Admits a patient into this ward.
     * @param p the Patient to admit
     */
    void admitPatient(Patient p);

    /**
     * Discharges a patient by their numeric ID portion.
     * @param patientId the patient's numeric ID to remove
     * @throws InvalidPatientException if no patient with that ID exists in this ward
     */
    void dischargePatient(int patientId) throws InvalidPatientException;

    /**
     * Displays all current patient details and ward information.
     */
    void displayWardDetails();
}
