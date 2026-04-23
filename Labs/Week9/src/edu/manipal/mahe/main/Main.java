package edu.manipal.mahe.main;

import java.util.Scanner;
import edu.manipal.mahe.employee.Employee;
import edu.manipal.mahe.department.Department;
import edu.manipal.mahe.payroll.Payroll;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee ID:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the employee name:");
		String name = sc.nextLine();
		System.out.println("Enter the employee age:");
		int age = sc.nextInt();
		System.out.println("Enter the basic salary:");
		double salary = sc.nextDouble();
		sc.nextLine();

		Employee emp = new Employee(id, name, age, salary);

		System.out.println("Enter the department name:");
		String deptName = sc.nextLine();
		System.out.println("Enter the manager name:");
		String manager = sc.nextLine();
		System.out.println("Enter the location:");
		String location = sc.nextLine();

		Department dept = new Department(deptName, manager, location);

		Payroll payroll = new Payroll(emp, dept);
		payroll.generatePaySlip();
		sc.close();
	}
}