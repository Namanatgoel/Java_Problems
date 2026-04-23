import java.util.Arrays;

public class string_immutable {
	public static void main(String[] args) {
		String name = "Kunal Kushwaha";
		System.out.println(name);
		
		String a = "Kunal";
		System.out.println(a);
		a = "Kushwaha"; //we did not change the prev object, but created a new one
		System.out.println(a);
		String b = "kushwaha";
		
		System.out.println(a==b);
		System.out.println(name!=b);
		
		String c = new String("Name");
		String d = new String("Name");
		System.out.println(c==d);
		
		String e = new String("Name");
		String f = "Name";
		System.out.println(e==f);
		String g = f;
		System.out.println(g==f);
		
		// == is a comparator
		// .equals() is a method which checks just the value and returns true / false
		
		System.out.println("This is a method "+d.equals(c));
		System.out.println("This is a method "+e.equals(f));
		
		//equals() ko true karne ke liye, the whole value should be really the same, not 
		//even extra spaces to be there, just like in == case
		
		String h = new String("Name ");
		System.out.println("This is a method "+d.equals(h));
//String is a collection of characters but in java we cannot do this:
		//System.out.println(name[0]);
//we have to use a method charAt(Index)
		System.out.println(name.charAt(0));
		System.out.println(new int[]{2,3,4,5});
		System.out.println(Arrays.toString(new int[]{2,3,4,5}));
		//the above works bec we override the String class ka toString method
		//by using the toString method available in the Arrays class
		//the above is METHOD OVERRIDING
		
		Integer num = new Integer(50);
		System.out.println(num.toString()); 
		//use some wrapper class and adds the two string method on that
		
		//the below line is same as the above num.toString line
		System.out.println(num); 
		
		//by using a wrapper class, we can use soo many methods unlike using 
		//a primitive data type like int
		
	/*	String name1; 
	 * ERROR
	 * The local variable name1 may not have been initialized
	 */
		String name1 = null;
		System.out.println(name1);
	}
}
