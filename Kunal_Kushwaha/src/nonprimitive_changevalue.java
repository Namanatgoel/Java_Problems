import java.util.Arrays;

public class nonprimitive_changevalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//for a non-primitive data type, the change through one variable changes the original value	
	int[] arr = {1,2,3,45,6};
	change(arr);
	System.out.println(Arrays.toString(arr));
	}
//if make a change to the object via this ref variable, then same object will be changed
//unlike for a primitive data type
	static void change(int[] nums) {
		nums[0] = 99;
	}
}
