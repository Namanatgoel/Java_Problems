import java.util.Scanner;
public class question5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find factorial: ");
		int num = sc.nextInt();
		if(num<0) {
			System.out.println("Enter a positive number!");
			return;
		}
		System.out.print("The factorial of this number is: "+fact(num));
	}
	
	public static int fact(int a) {
		if(a==0 || a==1) return 1;
		else {
			return a*fact(a-1);
		}
	}
}
