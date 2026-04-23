import java.util.Scanner;

class Student_2 {
	int rollNo;
	String name;
	int marks;

	void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Roll No: ");
		rollNo = sc.nextInt();
		sc.nextLine(); // consume newline
		System.out.print("Enter Name: ");
		name = sc.nextLine();
		System.out.print("Enter Marks: ");
		marks = sc.nextInt();
	}

	void display() {
		System.out.println(rollNo + "\t" + name + "\t" + marks);
	}
}

public class Array_of_obj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int n = sc.nextInt();
// Declaring array of objects
		Student_2[] students = new Student_2[n];
// Creating objects
		for (int i = 0; i < n; i++) {
			students[i] = new Student_2();
			System.out.println("\nEnter details of student " + (i + 1));
			students[i].accept();
		}
// Displaying records
		System.out.println("\nRoll No\tName\tMarks");
		for (int i = 0; i < n; i++) {
			students[i].display();
		}
		sc.close();
	}
}