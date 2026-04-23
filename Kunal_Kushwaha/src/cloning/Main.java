package cloning;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Human kunal = new Human(32, "anamn");
		Human twin = new Human(kunal);
		/*
		 * problem is that it is taking a lot of processing time as we are using
		 * the new keyword
		 * Instead we can use the clone method
		 * Object cloning - means we are creating an exact copy of an object
		 * Clone is a method in Object class that is used to make these copies
		 * 
		 * 
		 * .clone() will actually copy all the values from one object to another object
		 * so need of making another constructor and writing in that format which is
		 * like an overhead with the new keyword
		 * It is easier and a faster way to copy when making clone of big stuff
		 */
		Human thrice = (Human)kunal.clone();
		/*
		 * for using the above statement, we have to mention this:
		 * throws CloneNotSupportedException in the psvm
		 * bec if we are using something inside a method which throws an exception
		 * then we have to mention it in the definition of that function ki something
		 * is there inside this function that throws this exception
		 */
		System.out.println(twin.age+" "+twin.name);
		
		System.out.println(Arrays.toString(twin.arr));
		
		//twin.arr[0] = 100;
		System.out.println(Arrays.toString(kunal.arr));
		
		/*
		 * if we change an element of twin.arr then kunal.arr element also
		 * changes, this is called shallow copy
		 */
	}

}
