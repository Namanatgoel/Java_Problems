import java.util.Arrays;
import java.util.Scanner;
public class varargs {
//when we create a method, which takes variable number of arguments is known as variable arguments
//we dont know how many inputs we are giving
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun(3,4,65,87,8776867,87,212); //can give 0 or more than zero arguments
		fun();
		multiple(23,43,"hi",/*'hi' not allowed as not string*/"hello","rewr");
	}
	
	static void fun(int ...f) //it takes it internally as an array of integers,
	//can make array of Strings, char etc the same way
	{
		System.out.println(Arrays.toString(f));
		//f is implicitly declared as an array of int
	}
	
	static void multiple(int a, int b, String ...f) {
		System.out.println();
		System.out.println(a);
		System.out.println(b);
		System.out.println(Arrays.toString(f));
	}

}
