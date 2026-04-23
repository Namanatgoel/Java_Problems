import java.util.*;
public class method_overloading {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	fun(43);
	fun(232,"naman");
	fun("aman");
	System.out.println(sum(43,44));
	System.out.println(sum(43,44,45));
	demo(43,4,54,7,76,7);
	demo("54","hello","check","this out");
//	demo(); //error, this is ambiguity, as not able to decide which method to load
	}
	//HOW PROGRAM FIND WHICH fun() to run
	//this happens when the program gets compiled at the compile time method overloading 
	//decides which function to run
	//method overriding happens at run time
	static void fun(int a) {
		System.out.println(a);
	}
	
	/* NOT POSSIBLE, variable name changed but parameter type is same
	 * static void fun(int b) { }
	 */
		
	static void fun(String a) {
		System.out.println(a);
	}
	static void fun(int b, String name) {
		System.out.println(b);
		System.out.println(name);
	}
	
	static int sum(int a, int b) {
		return a+b;
	}
	
	static int sum(int a, int b, int c) {
		return a+b+c;
	}
	
	static void demo(int ...s) {
		System.out.println(Arrays.toString(s));
	}
	
	static void demo(String ...s) {
		System.out.println(Arrays.toString(s));
	}
//two or more functions of the same name can exists if the number of arguments are different
//or the type of arguments should be different

}
