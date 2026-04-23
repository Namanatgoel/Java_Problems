package edu.manipal.mahe.payroll;

import edu.manipal.mahe.employee.Employee;
import edu.manipal.mahe.department.Department;

public class Payroll {
	private Employee emp;
	private Department dept;

	public Payroll(Employee employee, Department department) {
		this.emp = employee;
		this.dept = department;
	}

	private double calculateNetSalary() {
		double da = 0.52 * emp.getBasicSalary();
		double gross = emp.getBasicSalary() + da;
		double it = 0.30 * gross;
		double net_sal = gross - it;
		return net_sal;
	}

	public void generatePaySlip() {
		double netSalary = calculateNetSalary();
		System.out.println("Payslip for January 2025");
		System.out.println("Employee name: " + emp.getName());
		System.out.println("Employee age: " + emp.getAge());
		System.out.println("Employee department name: " + dept.getDepartmentName());
		System.out.println("Employee Net Salary: " + netSalary);
	}
}