import java.util.Scanner;

class STUDENT{
		String sname;
		int[] marks_array;
		int total;
		float avg;
		int n;
		
		void assign() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the details - ");
			System.out.print("Name: ");
			sname = sc.nextLine();
			System.out.println("Enter the number of subjects: ");
			n = sc.nextInt();
			marks_array = new int[n];
			System.out.println("Enter the marks for each subject: ");
			for(int i = 0; i<n; i++) {
				marks_array[i] = sc.nextInt();
			}

		}
		
		void compute() {
		System.out.println("Computing..");
		for(int i = 0; i<n; i++) 
		{
			total += marks_array[i];
		}
		avg = (float)total/n;
		}
		
		void display() {
			System.out.println("The student details are: ");
			System.out.println(sname);
			for(int i = 0; i<n; i++) 
			{
				System.out.println(marks_array[i]);
			}
			System.out.println(total);
			System.out.println(avg);
		}
}

class ScienceStudent extends STUDENT{
	
}
public class ques1 {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		STUDENT s = new STUDENT();
		s.assign();
		s.compute();
		s.display();
		
		STUDENT s1 = new STUDENT();
		s1.assign();
		s1.compute();
		s1.display();
	}

}
