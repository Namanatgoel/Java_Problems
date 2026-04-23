import java.util.Scanner;
public class question3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the date of birth (DD): ");
		int date = sc.nextInt();
		System.out.print("Enter the month of birth (MM): ");
		int month = sc.nextInt();
		System.out.print("Enter the year of birth (YY): ");
		int year = sc.nextInt();
		int retire_age = year + 60;
		System.out.println("The retirement age is: "+date+ "-" +month+ "-" +retire_age);
	}
}
