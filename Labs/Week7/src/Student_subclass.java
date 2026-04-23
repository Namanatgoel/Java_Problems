import java.util.Scanner;


class Student {

    String name;
    int mark1, mark2;
    int total;
    double average;


    Student(String name, int mark1, int mark2) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    void compute() {
        total = mark1 + mark2;
        average = total / 2.0;
    }

 
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
    }
}


class ScienceStudent extends Student {

    int practicalMarks;

    ScienceStudent(String name, int mark1, int mark2, int practicalMarks) {
        super(name, mark1, mark2);  
        this.practicalMarks = practicalMarks;
    }

    void compute() {
        total = mark1 + mark2 + practicalMarks;
        average = total / 3.0;
    }


    void displayPracticalMarks() {
        System.out.println("Practical Marks: " + practicalMarks);
    }


    void display() {
        super.display();
        displayPracticalMarks();
    }
}

class ArtsStudent extends Student {

    String electiveSubject;
  ArtsStudent(String name, int mark1, int mark2, String electiveSubject) {
        super(name, mark1, mark2);
        this.electiveSubject = electiveSubject;
    }
  void display() {
        super.display();
        System.out.println("Elective Subject: " + electiveSubject);
    }
}

public class Student_subclass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student("John", 80, 70);
        Student s2 = new ScienceStudent("Alice", 85, 75, 90);
        Student s3 = new ArtsStudent("Bob", 78, 88, "History");     
        s1.compute();
        s2.compute();
        s3.compute();     
        s1.display();
        s2.display();
        s3.display();
        sc.close();
    }
}