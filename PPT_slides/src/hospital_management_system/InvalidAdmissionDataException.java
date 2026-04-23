package hospital.core;

/**
 * CUSTOM EXCEPTION — InvalidAdmissionDataException
 *
 * PURPOSE:
 *   Thrown when a Patient object is created with invalid field data.
 *   This is a "checked exception" (extends Exception, not RuntimeException),
 *   which means the compiler forces the caller to handle it with try-catch.
 *
 * CONCEPT: Custom exceptions give meaningful, readable error names instead
 *   of using generic exceptions like IllegalArgumentException.
 *   All you need to do is extend Exception and pass the message to super().
 */
public class InvalidAdmissionDataException extends Exception {

    // Constructor simply passes the error message up to the parent Exception class.
    // The message is what gets printed when you call e.getMessage().
    public InvalidAdmissionDataException(String message) {
        super(message);
    }
}
