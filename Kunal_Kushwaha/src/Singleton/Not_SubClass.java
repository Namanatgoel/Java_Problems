package Singleton;

import access.A;

public class Not_SubClass extends A {
	
	public Not_SubClass(int num, String name) {
		super(num, name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Not_SubClass obj = new Not_SubClass(45, "Kaala h tu");
		int n = obj.num;
		
		/*
		 * for protected, outside the package, only the subclass can access the protected
		 * members in the base class
		 * 
		 * example: 	
		 * A obj = new Not_SubClass(45, "Kaala h tu");
		 * int n = obj.num;
		 * 
		 * here, A is trying to access the reference variable which is not allowed
		 * 
		 * Even, this below code also doesn't work:
		 * A obj = new A(45, "Kaala h tu");
		 * int n = obj.num;
		 * 
		 * for protected, in a diff package, not even the class itself can access it,
		 * only and only the subclass can access it
		 * bec A is at top, it doesn't know what is extending it, A don't know what all
		 * below things are using it
		 * but below things knows that which thing they are using from above classes
		 * 
		 * Base knows what parent is BUT parent don't know what base's are
		 * 
		 * If the below code holds true, then there is no difference between public
		 * and protected:
		 * A obj = new A(45, "Kaala h tu");
		 * int n = obj.num;
		 *  
		 */
	}

}
