import java.util.Arrays;
import java.util.Scanner;
public class array_2D {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[][] arr = new int[3][3];
		System.out.println(arr.length);
		
		for(int row = 0; row < arr.length; row++) {
			//for each col in every row
			for(int col = 0; col < arr[row].length; col++ ) {
				arr[row][col] = in.nextInt();
			}
		}
		
		for(int row = 0; row < arr.length; row++) {
			//for each col in every row
			for(int col = 0; col < arr[row].length; col++ ) {
				System.out.println(arr[row][col]);
				System.out.println("\t");
			}
			System.out.println();
		}
		
		//enhanced for loop
		for(int[] row : arr) {
			for(int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
	}
		
		//another method
		for(int row = 0; row < arr.length; row++) 
		{
			System.out.println(Arrays.toString(arr[row]));
		}
		
		System.out.println();
		for(int[] a: arr) {
			System.out.println(Arrays.toString(a));
		}
		
		String[] strin = new String[4];
		System.out.println(arr[0]);
		
		for(String element : strin) {
			System.out.println(element); 
		}

}}
