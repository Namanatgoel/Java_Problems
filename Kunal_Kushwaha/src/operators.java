import java.util.ArrayList;

public class operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('a'+'b');
		System.out.println("a"+'b'); //string + char -> string
		System.out.println("a"+"b");
		/*On string objects, the + operator is being overloaded
		 * bec + operator is being given more functionality
		 */
		
		//in C++, python operator overloading is supported, unlike in java
		//only string operator overloading in possible in java, to support string concatenation
		
		System.out.println('a'+3);
		System.out.println((char)('a'+3));
		/*when doing addition with characters, it converts them to their ASCII value
		 * numbers, then it uses them to operate on them
		 * While with strings, it takes the string values 
		 */
		System.out.println("a"+3); 
		/* integer will be converted to the wrapper class Integer that will call toString()
		 * So this is same as after a few steps: "a"+"1"
		 */
		System.out.println("Kunal"+ new ArrayList<>());
		System.out.println("Kunal"+ new Integer(56));
		
		/*If the addition to the string is an object then toString() will be called on this
		 * It will get the string value added to the string
		 */
		
		/* ERROR:
		 * System.out.println(new Integer(56) + new ArrayList<>());
		 * The operator + in java is only defined for primitives or when any one of 
		 * the values is a string
		 */
		System.out.println(new Integer(56) + "" +new ArrayList<>());
		/*Any number of complex objects can be there, but atleast 1 string should be there
		 * bec the entire result will be string type 
		 */
	}

}
