import java.util.Scanner;

public class isodd_bitwise_operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isOdd(n));
	}
	private static boolean isOdd(int n) {
		return ((n&1)==1);
	}

}
