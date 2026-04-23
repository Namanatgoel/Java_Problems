package edu.manipal.mit.main;

import java.util.Scanner;
import edu.manipal.mit.student.Student; 
import edu.manipal.mit.course.Course; 
import edu.manipal.mit.registration.Registration; 
 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the student name:"); 
        String name = sc.nextLine(); 
        System.out.println("Enter the roll number:"); 
        int roll = sc.nextInt(); 
        sc.nextLine(); 
        System.out.println("Enter the department:"); 
        String dept = sc.nextLine(); 
        System.out.println("Enter the GPA:"); 
        double gpa = sc.nextDouble(); 
        sc.nextLine(); 
        
        Student stu = new Student(name, roll, dept, gpa); 
 
        System.out.println("Enter the course name:"); 
        String courseName = sc.nextLine(); 
        System.out.println("Enter the instructor name:"); 
        String instructor = sc.nextLine(); 
        System.out.println("Enter the credits:"); 
        int credits = sc.nextInt(); 
 
        Course c = new Course(courseName, instructor, credits); 
 
        Registration reg = new Registration(stu, c); 
        reg.registerStudent(); 
        sc.close();
    } 
}
