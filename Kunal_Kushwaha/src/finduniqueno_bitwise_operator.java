import java.util.Scanner;
public class finduniqueno_bitwise_operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		for(int i = 0; i<5; i++) {
			arr[i] = sc.nextInt();
		}
		//find the only number appearing once, rest all appear twice
		//do XOR of the whole array and we get the number
		xor_array(arr);
		sc.close();
	}
	
	private static void xor_array(int a[]) {
		int xor = 0;
		for(int n : a) {
			xor ^= n;
		}
		System.out.print(xor);
	}

}
