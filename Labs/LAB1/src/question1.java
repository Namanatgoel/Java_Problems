import java.util.Scanner;
public class question1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter hours worked: ");
		double hours = sc.nextDouble();
		System.out.print("Hourly Rate: ");
		double rate = sc.nextDouble();
		double salary;
		if(hours>40)
			salary = (40*rate)+(hours-40)*rate*1.5;
		else
			salary = hours*rate;
		System.out.println("Salary is: "+salary);
		sc.close();		
	}

}
