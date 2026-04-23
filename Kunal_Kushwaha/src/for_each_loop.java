import java.util.Arrays;
import java.util.*;
public class for_each_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
		//enhanced for loop for directly  getting the item
		int[] arr = {23,32,90,98,67};
		for(int num: arr) {
			System.out.println(num + " "); //here num represent element of the array
		}
		//when dont know the datatype, use var
		for(var num: arr) {
			System.out.println(num + " "); //here num represent element of the array
		}
		
		System.out.println(Arrays.toString(arr));
		//toString method converts array to string and prints the string
	
	//array of objects
	String[] str = new String[4];
	for(int i = 0; i< str.length; i++) {
		str[i] = in.next(); //can input a string or character
	}
	
	System.out.println(Arrays.toString(str));

}
}
