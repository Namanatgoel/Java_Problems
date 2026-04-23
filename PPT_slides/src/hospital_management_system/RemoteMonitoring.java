package hospital.admin;

/**
 * INTERFACE — RemoteMonitoring  (package: hospital.admin)
 *
 * PURPOSE:
 *   Represents remote-access capability for a medical unit.
 *   Lives in a DIFFERENT package (hospital.admin) from the classes
 *   that implement it (hospital.core).
 *
 * KEY CONCEPT — Interfaces across packages:
 *   A class in hospital.core can implement this interface by importing it:
 *       import hospital.admin.RemoteMonitoring;
 *   This shows that interfaces decouple behaviour from location in the codebase.
 *
 * CONCEPT — Why a second interface?
 *   Not every ward needs remote monitoring — only ICU does.
 *   Putting this in a separate interface (vs. adding methods to HospitalOperations)
 *   follows the Interface Segregation Principle: don't force a class to implement
 *   methods it doesn't need.
 */
public interface RemoteMonitoring {

    /**
     * Performs a remote status check on the unit.
     * ICU will implement this to print current patient counts, status, etc.
     */
    void remoteCheck();

    /**
     * Sends an alert message from the unit (e.g., to a nurse station).
     * @param message the alert text to broadcast
     */
    void sendAlert(String message);
}
