import java.util.Arrays;
public class pass_by {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,4,5,90};
		change(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void change(int[] nums) {
		nums[0] = 90;
	}

}
