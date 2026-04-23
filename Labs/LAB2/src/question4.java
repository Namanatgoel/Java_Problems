/*Write a Java program to display non diagonal elements and find their sum. 
[Hint: Non Principal diagonal: The diagonal of a diagonal matrix from the top 
right to the bottom left corner is called non principal diagonal.] */
import java.util.Scanner;
public class question4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter matrix dimension: ");
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		System.out.print("Enter the matrix elements: ");
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.print("The matrix elements are: \n");
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		int sum = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i==j || (i+j==n-1))
					sum+=0;
				else 
				{
					System.out.println(arr[i][j]);
					sum+=arr[i][j];
				}
			}
		}
		System.out.print("The sum is: "+sum);
		sc.close();
	}

}
