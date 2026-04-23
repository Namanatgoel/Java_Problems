import java.util.*;
public class max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 32, 43, 90};
		System.out.println(max(arr, 1, 3));
	}
	
	static int max(int[] arr, int start, int end) {
		int max = Integer.MIN_VALUE;
		//int max = arr[0];
	/*	for(int ele : arr) {
			if (ele>max) {
				max = ele;
			}
		} */
		for(int i = start; i<end; i++) {
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}


}
