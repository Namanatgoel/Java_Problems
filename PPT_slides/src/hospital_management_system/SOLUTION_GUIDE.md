# Smart Hospital Management System
## Problem Statement + Complete Solution Guide

---

## 📋 The Question

Design a **Smart Hospital Management System** in Java using two packages:
`hospital.core` and `hospital.admin`.

---

### Part (a) — Interface `HospitalOperations` *(hospital.core)*
Create an interface with methods:
- `void admitPatient(Patient p)`
- `void dischargePatient(int patientId) throws InvalidPatientException`
- `void displayWardDetails()`

---

### Part (b) — Class `Patient` *(hospital.core)*
Attributes: `patientId` (String), `name` (String), `age` (int), `diagnosis` (String), `billAmount` (double)

Validate all fields in the constructor and throw `InvalidAdmissionDataException` if:
- `patientId` does not match the pattern `PAT` followed by exactly 3 digits (e.g., `PAT001`)
- `name` contains anything other than alphabets with exactly **one space** between words
- `age` is zero or negative
- `billAmount` is negative

---

### Part (c) — Abstract Class `MedicalUnit` *(hospital.core)*
Attributes: `unitId` (String), `unitName` (String), `capacity` (int), `status` (boolean)

Rules:
- Setters for `unitId` and `unitName` must be **private** (encapsulation)
- All fields must have **public getter** methods
- A **static variable** `unitCount` tracks total units created; expose via `static getUnitCount()`
- Concrete methods: `turnOn()`, `turnOff()`
- Abstract method: `double calculateTotalBill()`

---

### Part (d) — Subclasses of `MedicalUnit` implementing `HospitalOperations`

**`GeneralWard`:**
- Additional attribute: `ratePerDay` (double)
- `calculateTotalBill()` returns sum of all patients' `billAmount`
- `admitPatient()` adds patient to internal list
- `dischargePatient()` removes by `patientId`; throws `InvalidPatientException` if not found

**`ICU`:**
- Additional attribute: `chargeMultiplier` (double, default 2.0)
- If admitted patient's age > 60, `chargeMultiplier` increases by **25%** for that patient's bill
- `calculateTotalBill()` applies multiplier to each patient's `billAmount`
- Contains an **inner class** `VentilatorStatus` with:
  - attribute `breathingRate` (int)
  - method `getStatus()` — prints a warning if breathingRate < 12 or > 20

---

### Part (e) — Interface `RemoteMonitoring` *(hospital.admin)*
Methods:
- `void remoteCheck()`
- `void sendAlert(String message)`

`ICU` must implement `RemoteMonitoring`.

---

### Part (f) — Abstract Class `HospitalStaff` *(hospital.staff)*
Attributes: `name` (String), `staffId` (String)
Abstract method: `String getRole()`

---

### Part (g) — Classes `Doctor` and `Nurse` extending `HospitalStaff`

**`Doctor`:** additional attributes `specialization` (String), `yearsOfExperience` (int)

**`Nurse`:** additional attributes `shift` (String: Morning/Evening/Night), `assignedWard` (String)

Both must override `getRole()`.

---

### Part (h) — Class `Department` *(hospital.staff)*
Attributes:
- `departmentName` (String)
- Fixed-size arrays: `Doctor[]`, `Nurse[]`

Methods to add and display all staff.

---

### Part (i) — Custom Exceptions *(hospital.core)*
- `InvalidPatientException` — thrown by `dischargePatient()` when no patient with that ID exists
- `InvalidAdmissionDataException` — thrown by `Patient` constructor for bad input data

---

### Part (j) — `Main.java` — Menu-Driven Program
```
1. Add Ward (General / ICU)
2. Admit Patient to Ward
3. Discharge Patient from Ward
4. Display Ward Details
5. Show Total Bill of a Ward
6. Add Staff to Department
7. Display Department Details
8. ICU Remote Monitor Demo
0. Exit
```

At least one object of each subclass must be created.
Demonstrate **dynamic polymorphism** using a `MedicalUnit` reference array.

---
---

## 🧠 Solution Intuition — Concept-by-Concept

Before writing a single line of code, read this section completely. It tells you *why* each piece
is structured the way it is.

---

### Step 1 — Identify the Hierarchy (Draw it first, code it second)

```
        <<interface>>              <<interface>>
      HospitalOperations         RemoteMonitoring
        (hospital.core)           (hospital.admin)
              |                         |
              |           ┌─────────────┘
              ▼           ▼
        [abstract] MedicalUnit          [abstract] HospitalStaff
              |                               |
      ┌───────┴────────┐              ┌───────┴───────┐
      ▼                ▼              ▼               ▼
  GeneralWard        ICU           Doctor           Nurse
                (+ inner class
               VentilatorStatus)
```

**Intuition:** Always draw this tree before coding. Every arrow tells you what keyword to write:
- Dashed arrow (`<<implements>>`) → `implements` keyword
- Solid arrow (`extends`) → `extends` keyword
- A class can only `extend` ONE class, but can `implement` MANY interfaces

---

### Step 2 — Design the Exceptions First

**Rule:** Define your exceptions *before* the classes that throw them, because those classes
depend on them.

```
InvalidAdmissionDataException  →  used in Patient constructor
InvalidPatientException        →  used in dischargePatient()
```

Both simply extend `Exception` and call `super(message)`. That's all. Custom exceptions
exist purely to give *meaningful names* to error conditions.

**Why checked exceptions (not RuntimeException)?**
Because the caller (Main.java) *must* handle them with try-catch. The compiler enforces it.
This is exactly what `throws` in the interface method signature does — it contracts that
any class implementing this interface MUST propagate this exception.

---

### Step 3 — Design the `Patient` class (Validation Logic)

**Intuition for regex validation:**

| Field | Pattern | Regex |
|-------|---------|-------|
| patientId | PAT + exactly 3 digits | `"PAT\\d{3}"` |
| name | Only letters, single spaces between words | `"[A-Za-z]+(\\s[A-Za-z]+)*"` |
| age | Must be > 0 | Simple `if` check |
| billAmount | Must be >= 0 | Simple `if` check |

The constructor throws `InvalidAdmissionDataException` — it does NOT catch it.
This is called **propagating** the exception. The caller (Main.java) is responsible for handling it.

---

### Step 4 — Design the Abstract Class `MedicalUnit`

**Why abstract?** Because a "MedicalUnit" by itself is too generic — you never create a
raw `MedicalUnit` object. You always create either a `GeneralWard` or `ICU`. Abstract forces
subclasses to define `calculateTotalBill()` their own way.

**Why private setters for unitId and unitName?**
These fields are set once in the constructor and should never change externally. Making setters
private enforces this — even subclasses cannot call them. This is **encapsulation**.

**Why static unitCount?**
Static variables belong to the *class*, not any one object. Every time a `new MedicalUnit(...)` 
constructor runs (via `super()`), `unitCount++` runs once. This gives a global count across
all ward objects.

```java
// In constructor:
MedicalUnit(...) {
    unitCount++;   // fires for EVERY subclass object created, because they all call super()
}
```

---

### Step 5 — Design `GeneralWard` and `ICU`

**Both classes follow the same pattern:**
1. Call `super(...)` to initialize parent attributes
2. Store their own extra attributes
3. Implement all interface methods

**The `dischargePatient` method is where the exception is thrown:**
```
Loop through patient list
  → If found: remove and return
  → If loop ends without finding: throw InvalidPatientException
```

The `throw` must come AFTER the loop ends, not inside an `else`. This is a common mistake.

**ICU's age-based multiplier:**
The multiplier is applied *at bill calculation time*, not at admission time. This is cleaner
because the multiplier might change (policy update). Store the multiplier per-patient using
a parallel list, or apply it dynamically in `calculateTotalBill()` by checking age.

**ICU's inner class `VentilatorStatus`:**
An inner class is defined *inside* the outer class body. It can access the outer class's
instance variables directly. It's instantiated using `icuObject.new VentilatorStatus(rate)`.

```java
// Usage in Main:
ICU.VentilatorStatus vs = myICU.new VentilatorStatus(15);
vs.getStatus();
```

---

### Step 6 — Interface in a Different Package

`RemoteMonitoring` lives in `hospital.admin` but `ICU` lives in `hospital.core`.
To use it, `ICU.java` must import it:

```java
import hospital.admin.RemoteMonitoring;
```

`ICU` then declares: `class ICU extends MedicalUnit implements HospitalOperations, RemoteMonitoring`

This demonstrates that a class can implement interfaces from *different packages* simultaneously.

---

### Step 7 — The Staff Hierarchy (Separate Package: hospital.staff)

This is a self-contained hierarchy. The abstract class `HospitalStaff` exists so you can
write polymorphic code like:

```java
HospitalStaff s = new Doctor(...);
System.out.println(s.getRole()); // prints "Doctor"
```

Without the abstract class, you couldn't hold a `Doctor` and `Nurse` in the same array.
With it: `HospitalStaff[] staff = { new Doctor(...), new Nurse(...) };`

---

### Step 8 — `Department` class

This is the "container" class. It holds arrays of `Doctor[]` and `Nurse[]`. The size is
fixed at construction time. Think of it as the ward's staff roster.

Key insight: Department does NOT extend anything. It just uses composition (has-a relationship)
rather than inheritance (is-a relationship). This is the right design — a Department
*has* doctors, it is not *a type of* doctor.

---

### Step 9 — Dynamic Polymorphism in Main

This is the most important concept to demonstrate:

```java
MedicalUnit[] wards = { new GeneralWard(...), new ICU(...) };
for (MedicalUnit w : wards) {
    w.calculateTotalBill();    // calls GeneralWard's version for index 0
                               // calls ICU's version for index 1
}
```

The *reference type* is `MedicalUnit` (parent), but the *object type* is the subclass.
Java decides at **runtime** which `calculateTotalBill()` to call — this is polymorphism.

---

### Step 10 — Menu-Driven Main Structure

The menu is a `do-while` loop with a `switch` statement. Each case calls a helper method
to keep `main()` clean. All try-catch blocks live in those helper methods.

**General structure:**
```
do {
    print menu
    read choice
    switch(choice) {
        case 1 -> addWard()
        case 2 -> admitPatient()
        ...
    }
} while (choice != 0)
```

---

## 📁 File Structure

```
HospitalSystem/
│
├── SOLUTION_GUIDE.md              ← This file
│
├── hospital/
│   ├── core/
│   │   ├── HospitalOperations.java     (interface)
│   │   ├── InvalidPatientException.java
│   │   ├── InvalidAdmissionDataException.java
│   │   ├── Patient.java
│   │   ├── MedicalUnit.java            (abstract class)
│   │   ├── GeneralWard.java
│   │   └── ICU.java                   (+ inner class VentilatorStatus)
│   │
│   ├── admin/
│   │   └── RemoteMonitoring.java       (interface)
│   │
│   └── staff/
│       ├── HospitalStaff.java          (abstract class)
│       ├── Doctor.java
│       ├── Nurse.java
│       └── Department.java
│
└── Main.java
```

---

## 🔑 Key Java Concepts Used — Quick Reference

| Concept | Where Used |
|---------|------------|
| Interface | `HospitalOperations`, `RemoteMonitoring` |
| Abstract class | `MedicalUnit`, `HospitalStaff` |
| Inheritance (`extends`) | `GeneralWard`, `ICU`, `Doctor`, `Nurse` |
| Multiple interface impl | `ICU implements HospitalOperations, RemoteMonitoring` |
| Custom exceptions | `InvalidPatientException`, `InvalidAdmissionDataException` |
| throws in interface | `dischargePatient()` in `HospitalOperations` |
| Constructor validation | `Patient` constructor |
| Regex validation | `patientId` and `name` in `Patient` |
| Private setters | `unitId`, `unitName` in `MedicalUnit` |
| Static variable + method | `unitCount`, `getUnitCount()` in `MedicalUnit` |
| Inner class | `VentilatorStatus` inside `ICU` |
| Packages | `hospital.core`, `hospital.admin`, `hospital.staff` |
| Dynamic polymorphism | `MedicalUnit[]` array in `Main` |
| ArrayList | Patient lists in wards |
| Menu-driven program | `Main.java` |
| Composition (has-a) | `Department` has `Doctor[]` and `Nurse[]` |

---

## ✅ Step-by-Step Coding Order

Follow this exact order to avoid "class not found" compile errors:

```
1.  InvalidAdmissionDataException.java    (no dependencies)
2.  InvalidPatientException.java          (no dependencies)
3.  RemoteMonitoring.java                 (no dependencies, different package)
4.  HospitalOperations.java               (depends on InvalidPatientException)
5.  Patient.java                          (depends on InvalidAdmissionDataException)
6.  MedicalUnit.java                      (depends on Patient, HospitalOperations)
7.  GeneralWard.java                      (depends on MedicalUnit, HospitalOperations, exceptions)
8.  ICU.java                              (depends on MedicalUnit, both interfaces, exceptions)
9.  HospitalStaff.java                    (no dependencies)
10. Doctor.java                           (depends on HospitalStaff)
11. Nurse.java                            (depends on HospitalStaff)
12. Department.java                       (depends on Doctor, Nurse)
13. Main.java                             (depends on everything)
```

---

## 🧪 Sample Run Walkthrough

```
Add Ward: General Ward, capacity 10, rate ₹500/day
Add Ward: ICU, capacity 5, multiplier 2.0

Admit to General Ward: PAT001, Ramesh Kumar, age 45, Fever, bill ₹1500
Admit to ICU:          PAT002, Leela Menon, age 65, Cardiac, bill ₹5000
  → Age > 60: ICU multiplier increases by 25% → becomes 2.5

Display ICU Total Bill → 5000 * 2.5 = ₹12,500

Discharge PAT001 from General Ward → success
Discharge PAT099 from General Ward → throws InvalidPatientException → "Patient not found"

ICU Remote Monitor → calls remoteCheck() and sendAlert("ICU Alert: Check vitals")

VentilatorStatus vs = icu.new VentilatorStatus(8)
vs.getStatus() → "WARNING: Abnormal breathing rate: 8"

Dynamic polymorphism:
  MedicalUnit[] wards = { generalWard, icu }
  for each ward → ward.calculateTotalBill() → calls respective subclass method
```
