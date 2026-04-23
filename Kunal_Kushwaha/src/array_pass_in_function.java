import java.util.Arrays;
public class array_pass_in_function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 4, 5, 12};
		System.out.println(Arrays.toString(nums));
		change(nums);
		System.out.println(Arrays.toString(nums));
		//this is mutable behaviour
		//nums and arr are pointing to the same object
		//arrays are mutable in java unlike strings
	}
	
	static void change(int[] arr) {
		arr[0] = 99;
	}

}
