import java.util.Scanner;
public class question2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your registeration number: ");
		int reg = sc.nextInt();
		int n = reg;
		int count = 0;
		while(n!=0) {
			n/=10;
			count++;
		}
		if(count!=9) 
		{
			System.out.print("enter valid registeration number! ");
			return;
		}
		//now extracting the first 2 numbers of the registration number
		n = reg;
		while(count!=2) {
			n/=10;
			count--;
		}
		if(n>26) {
			System.out.println("The year of joining is 19"+n);
		}
		else
			System.out.println("The year of joining is 20"+n);
		sc.close();
	}
}
