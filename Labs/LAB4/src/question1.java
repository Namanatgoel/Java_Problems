import java.util.Scanner;
class STUDENT{
	String sname;
	int marks_array[] = new int[5];
	int total;
	double avg;
	
	STUDENT() {
		sname = "N//A";
		for(int i = 0; i< 5; i++) {
			marks_array[i] = -1;
		}
	}
	
	STUDENT(String name, int marks[]){
		sname = name;
		marks_array = marks;
	}
	
	void assign(String name, int a[]) {
		sname = name;
		marks_array = a;
	}
	
	void compute() {
		total = 0;
		for(int i = 0; i < 5; i ++) {
			total += marks_array[i];
		}
		avg = (double) total/5;
	}
	
	void display() {
		System.out.println("The name of student is " + sname);
		System.out.println("The marks of student are");
		for(int i = 0; i < 5; i++) {
			System.out.print(marks_array[i] + " ");
		}
		System.out.println();
		System.out.println("The total is: " + total);
		System.out.println("The average is: " + avg);
	}
	
}

public class question1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter name for first student: ");
		String name = in.nextLine();
		
		System.out.println("Enter mark in 5 subjects: ");
		int arr[] = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = in.nextInt();
		}
		
		STUDENT student_1 = new STUDENT();
		
		student_1.assign(name, arr);
		student_1.compute();
		student_1.display();
		
		System.out.println();
		System.out.println("Enter name for second student: ");
		name = in.nextLine();
		name = in.nextLine();
		
		System.out.println("Enter mark in 5 subjects: ");
		for (int i = 0; i < 5; i++) {
			arr[i] = in.nextInt();
		}
		
		STUDENT student_2 = new STUDENT(name, arr);
		student_2.compute();
		student_2.display();

	}

}

	