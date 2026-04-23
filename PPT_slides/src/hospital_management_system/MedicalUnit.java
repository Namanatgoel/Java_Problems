package hospital.core;

/**
 * ABSTRACT CLASS — MedicalUnit  (package: hospital.core)
 *
 * PURPOSE:
 *   Represents the common blueprint for any type of hospital ward.
 *   It is abstract because you should never create a generic "MedicalUnit"
 *   — you always create a specific GeneralWard or ICU.
 *
 * CONCEPT — Why abstract?
 *   Abstract classes force subclasses to provide implementations for methods
 *   that are inherently unit-specific (like calculateTotalBill).
 *   They also let us share common code (turnOn, turnOff, getters) across all wards.
 *
 * CONCEPT — Private setters + Public getters (Encapsulation):
 *   unitId and unitName are set ONCE at construction and should never be changed.
 *   Making their setters private prevents any code (even subclasses) from
 *   accidentally altering these identity fields.
 *
 * CONCEPT — Static variable + method:
 *   unitCount belongs to the CLASS, not any single object.
 *   Every time any MedicalUnit subclass object is constructed, super() runs
 *   and increments unitCount. So unitCount always reflects the total wards created.
 */
public abstract class MedicalUnit {

    // ─── Instance Fields ──────────────────────────────────────────────────────

    private String  unitId;      // e.g., "W001" — identity field, set once
    private String  unitName;    // e.g., "Ground Floor General Ward"
    protected int   capacity;    // max patients allowed (protected = subclass accessible)
    protected boolean status;    // true = operational, false = closed

    // ─── Static Field ─────────────────────────────────────────────────────────

    // Shared across ALL MedicalUnit objects — tracks total wards ever created
    private static int unitCount = 0;

    // ─── Constructor ──────────────────────────────────────────────────────────

    /**
     * Initializes all base ward attributes and increments the global unit counter.
     *
     * CONCEPT — super() in subclasses:
     *   When GeneralWard calls super(unitId, unitName, capacity), this constructor
     *   runs first. The unitCount++ here fires once per ward created, regardless
     *   of which subclass is being instantiated.
     */
    public MedicalUnit(String unitId, String unitName, int capacity) {
        // Use private setters internally (only way to set these from inside the class)
        setUnitId(unitId);
        setUnitName(unitName);
        this.capacity = capacity;
        this.status   = false;   // wards start in OFF/closed state by default
        unitCount++;             // increment class-level counter
    }

    // ─── Private Setters (encapsulation — identity fields cannot be changed externally) ──

    private void setUnitId(String unitId)     { this.unitId   = unitId;   }
    private void setUnitName(String unitName) { this.unitName = unitName; }

    // ─── Public Getters ───────────────────────────────────────────────────────

    public String  getUnitId()   { return unitId;   }
    public String  getUnitName() { return unitName; }
    public int     getCapacity() { return capacity; }
    public boolean getStatus()   { return status;   }

    // ─── Static Method ────────────────────────────────────────────────────────

    /**
     * Returns the total number of MedicalUnit objects created so far.
     * Called on the class itself: MedicalUnit.getUnitCount()
     */
    public static int getUnitCount() { return unitCount; }

    // ─── Concrete Methods (shared by all subclasses) ──────────────────────────

    /** Marks the ward as active/operational. */
    public void turnOn() {
        status = true;
        System.out.println("[" + unitName + "] Ward is now OPEN and operational.");
    }

    /** Marks the ward as inactive/closed. */
    public void turnOff() {
        status = false;
        System.out.println("[" + unitName + "] Ward has been CLOSED.");
    }

    // ─── Abstract Method ─────────────────────────────────────────────────────

    /**
     * Calculates the total bill for all currently admitted patients.
     *
     * CONCEPT — abstract method:
     *   Each subclass has its OWN billing logic:
     *     - GeneralWard: simple sum of patient bills
     *     - ICU:         applies a charge multiplier per patient
     *   So this can't be implemented here — it MUST be overridden.
     *
     * @return total bill amount in rupees
     */
    public abstract double calculateTotalBill();
}
