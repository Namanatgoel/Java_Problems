import java.util.Scanner;
public class armstrong_numbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print all the 3 digit armstrong numbers
		Scanner in = new Scanner(System.in);
		for(int i = 100; i<1000; i++) {
			if(Armstrong(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	static boolean Armstrong(int m) {
		int sum = 0;
		int n = m;
		int rem=0;
		while (n>0) {
			rem = n%10;
			sum += Math.pow(rem, 3);
			n /= 10;			
		}
		if (sum == m) {
			return true;
		}
		return false;
	//	else System.out.println("you duffer");
	}

}
