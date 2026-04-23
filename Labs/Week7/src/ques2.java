class Employee {

    String name;
    int empId;
    double salary;

    Employee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }


    void calculateSalary() {
        salary = 0;
    }

    void displayEmployeeDetails() {
    	System.out.println();
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

class PartTimeEmp extends Employee {

    int hoursWorked;
    static final double hourlyRate = 500;  

    PartTimeEmp(String name, int empId, int hoursWorked) {
        super(name, empId); 
        this.hoursWorked = hoursWorked;
    }
    void calculateSalary() {
        salary = hoursWorked * hourlyRate;
    }

    void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
    }
}

class FullTimeEmp extends Employee {

    double bonus;
    double deductions;

    FullTimeEmp(String name, int empId, double bonus, double deductions) {
        super(name, empId);
        this.bonus = bonus;
        this.deductions = deductions;
    }

    void calculateSalary() {
        double baseSalary = 50000;  
        salary = baseSalary + bonus - deductions;
    }

    void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Bonus: " + bonus);
        System.out.println("Deductions: " + deductions);
    }
}
public class ques2 {

    public static void main(String[] args) {

        Employee e1 = new PartTimeEmp("Manujith", 101, 20);
        Employee e2 = new FullTimeEmp("Anushka", 102, 5000, 2000);

        e1.calculateSalary();
        e2.calculateSalary();
        e1.displayEmployeeDetails();
        e2.displayEmployeeDetails();
    }
}
