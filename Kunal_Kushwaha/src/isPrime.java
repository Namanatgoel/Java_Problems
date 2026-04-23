import java.util.Scanner;
public class isPrime {

	static boolean isPrime(int n) {
		if(n<=1) return false;
		int c = 2;
		while (c*c <= n) {
			if(n%c == 0) return false; 
			c++;
		}
		
		return c*c>n;
		/* LOGIC BEHIND THE if condition
		if (c*c > n) {
			return true;
		}
		return false;*/		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean ans = isPrime(n);
		System.out.println(ans);
	}

}
