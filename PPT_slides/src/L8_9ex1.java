import java.util.Scanner;
public class L8_9ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Create a class Student with data members: regNum, name, 
		 * subjectWiseMarks, totalMarks, Grade. Include the following 
		 * constructors: a) A default constructor to initialize the data 
		 * members with default values. b) A parameterized constructor 
		 * to initialize the regNum, name, and subjectWiseMarks*/
		Student();		
	}

}

class Student{
	Scanner sc = new Scanner(System.in);
	int regNum;
	String name;
	int n;
	System.out.println("Enter the number of subjects: ");
	n = sc.nextInt();
	int[] subjectWiseMarks = new int[];
	for(int i = 0; i<n; i++) {
		subjectWiseMarks[i] = sc.nextInt();
	}
	
}