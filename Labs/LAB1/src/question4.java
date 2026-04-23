import java.util.Scanner;
public class question4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of elements in the array: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements: ");
		for(int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
			}
		
		System.out.print("Entered array: ");
		for(int i =0; i<n; i++) {
			System.out.print(a[i]+ " ");
		}
	
		System.out.println("number of shifting steps: ");
		int k = sc.nextInt();
		System.out.println("Left Shift(0) or Right Shift(1)? ");
		int dir = sc.nextInt();
		
		if(n==0) return;
		k = k%n;
		int[] temp = new int[k];
		if(dir==0) {
			for(int i = 0; i<k; i++) {
				temp[i] = a[i];
			}
			for(int i = k; i<n; i++) {
				a[i-k]=a[i];
			}
			for(int i = 0; i<k; i++) {
				a[n-k+i] = temp[i];
			}
		}
		else if(dir==1) {
			for(int i = 0; i<k; i++) {
				temp[i] = a[n-k+i];
			}
			for(int i = n-k-1; i>=0; i--) {
				a[i+k]=a[i];
			}
			for(int i = 0; i<k; i++) {
				a[i] = temp[i];
			}
		}
		System.out.print("Rotated array: ");
		for(int i =0; i<n; i++) {
			System.out.print(a[i]+ " ");
		}
		sc.close();
		}
	}
