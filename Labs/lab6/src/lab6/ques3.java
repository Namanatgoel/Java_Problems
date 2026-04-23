package lab6;

import java.util.*;

class Student {
    private String name;
    private int rollNo;

    
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    
    public String extractInitials() {
        String words[] = name.trim().split("\\s+");
        String initials = "";

        for (String word : words) {
            initials += Character.toUpperCase(word.charAt(0));
        }

        return initials;
    }

    
    public void removeWhitespace() {
        name = name.replaceAll("\\s+", "");
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Initials: " + extractInitials());
        System.out.println();
    }
}

public class ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student students[] = new Student[n];

       
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, roll);
        }

        
        System.out.println("\nStudent Details:");
        for (Student s : students) {
            s.display();
        }

        
        System.out.print("\nEnter substring to search: ");
        String sub = sc.nextLine();

        System.out.println("Students containing \"" + sub + "\":");
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(sub.toLowerCase())) {
                System.out.println(s.getName());
            }
        }

        
        Arrays.sort(students, Comparator.comparing(Student::getName));

        System.out.println("\nStudents Sorted Alphabetically:");
        for (Student s : students) {
            System.out.println(s.getName());
        }

        sc.close();
    }
}
