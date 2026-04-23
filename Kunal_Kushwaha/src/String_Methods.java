import java.util.Arrays;

public class String_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "KUNAL Kushwaha hlo world";
		System.out.println(name.toCharArray()); 
		System.out.println(Arrays.toString(name.toCharArray())); 
		System.out.println(name.toLowerCase());
		/*Doesn't convert the original object to lower case as string is immutable
		 * PROOF is that the original object is still the same
		 */
		System.out.println(name); 
		System.out.println(name.indexOf('a'));
		/*The above statement prints the index of the first occurrence of 'a' not 'A' */
		System.out.println("   KuNAl  ".strip());
		System.out.println(name.split(" "));
		//the above is returning a string array
		//so we have to call toString() method of Arrays
		System.out.println(Arrays.toString(name.split(" ")));
	}

}
