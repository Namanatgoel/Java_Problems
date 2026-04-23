package lab6;

import java.util.*;

class Employee {
    private String name;
    private int id;

    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    
    public void formatEmployeeName() {
        String words[] = name.toLowerCase().split(" ");
        String formatted = "";

        for (String word : words) {
            formatted += Character.toUpperCase(word.charAt(0)) 
                         + word.substring(1) + " ";
        }

        name = formatted.trim();
    }

    
    public String generateEmail() {
        String words[] = name.toLowerCase().split(" ");
        String email = words[0].charAt(0) 
                       + words[words.length - 1] 
                       + "@gmail.com";
        return email;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + generateEmail());
        System.out.println();
    }
}

public class ques2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee emp[] = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of Employee " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            emp[i] = new Employee(name, id);
            emp[i].formatEmployeeName();   
        }

        System.out.println("Employee Details:");
        for (Employee e : emp) {
            e.display();
        }

        sc.close();
    }
}