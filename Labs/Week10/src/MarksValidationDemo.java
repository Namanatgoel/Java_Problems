class stu {
	public void calculateAverage(int totalMarks, int numberOfSubjects) {
		if (numberOfSubjects == 0 || totalMarks == 0) {
			throw new ArithmeticException("Cannot calculate the average because Subjects or Total Marks cannot be zero!");
		}
		double average = (double) totalMarks / numberOfSubjects;
		System.out.println("The average marks are: " + average);
	}
}

public class MarksValidationDemo {
	public static void main(String[] args) {
		stu student = new stu();

		System.out.println("Test 1: Valid Data");
		try {
			student.calculateAverage(400, 6);
		} catch (ArithmeticException e) {
			System.out.println("Error is : " + e.getMessage());
		}

		System.out.println("\n Test 2: Invalid Data (Subjects are 0)");
		try {
			student.calculateAverage(190, 0);
		} catch (ArithmeticException e) {
			System.out.println("Error is : " + e.getMessage());
		}

		System.out.println("\n Test 3: Invalid Data (Marks are 0)");
		try {
			student.calculateAverage(0, 6);
		} catch (ArithmeticException e) {
			System.out.println("Error is : " + e.getMessage());
		}
	}
}
