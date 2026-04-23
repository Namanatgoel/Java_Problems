import java.util.Scanner;
public class question2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int a = sc.nextInt();
		System.out.print("Enter second number: ");
		int b = sc.nextInt();
		int sum;
		while(b!=0) {
			int carry = a & b;
			a = a^b;
			b = carry << 1;
		}
		sum = a;
		System.out.println("Sum is: "+sum);
		if((sum & 1)==0)
			System.out.println("The result is EVEN");
		else 
			System.out.println("The result is ODD");
		sc.close();
	}

}
