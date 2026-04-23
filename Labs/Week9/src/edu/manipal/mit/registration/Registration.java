package edu.manipal.mit.registration;

import edu.manipal.mit.student.Student; 
import edu.manipal.mit.course.Course; 
 
public class Registration { 
    private Student std; 
    private Course co; 
 
    public Registration(Student student, Course course) { 
        this.std = student; 
        this.co = course; 
    } 
 
    public void registerStudent() { 
        System.out.println("Student Details below:"); 
        System.out.println("Name- " + std.getName()); 
        System.out.println("Roll Number- " + std.getRollNumber()); 
        System.out.println("Department- " + std.getDepartment()); 
        System.out.println("GPA- " + std.getGpa()); 
        System.out.println("\n\n Course Details below:"); 
        System.out.println("Course Name- " + co.getCourseName()); 
        System.out.println("Instructor- " + co.getInstructor()); 
        System.out.println("Credits- " + co.getCredits()); 
        System.out.println("\n\n Registration done !"); 
    } 
} 
