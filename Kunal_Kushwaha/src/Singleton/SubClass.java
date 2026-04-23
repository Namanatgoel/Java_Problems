package Singleton;

import access.A;

public class SubClass extends A {
	
	public SubClass(int num, String name) {
		super(num, name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass obj = new SubClass(45, "Kaala h tu");
		int n = obj.num;
	}

}


class SubSubclass extends SubClass{
	
	public SubSubclass(int num, String name) {
		super(num, name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSubclass obj = new SubSubclass(45, "Kaala h tu");
		int n = obj.num;
		/*
		 * so can access protected num, only either if it is direct SubClass of A
		 * or
		 * sub class of its sub class
		 */
	}
}
/*
 * SubClass2 and SubClass have no idea about each other
 * For SubClass2 might not even have been written by the time we were using the SubClass
 * 
 * So, for the SubClass to manipulate the SubClass2's protected members would be 
 * very dangerous, SubClass2 won't know who tampered with it
 */
class SubClass2 extends A {
	
	public SubClass2(int num, String name) {
		super(num, name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A(45, "Kaala h tu");
//		int n = obj.num;
	}

}