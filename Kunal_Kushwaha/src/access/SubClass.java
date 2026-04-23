package access;

public class SubClass extends A {
	
	public SubClass(int num, String name) {
		super(num, name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass obj = new SubClass(45, "Kaala h tu");
		int n = obj.num;
		
		System.out.println(obj instanceof A);
		/*
		 * True
		 * means it is an instance of A, a subclass of A
		 * the obj is an object of SubClass which is of type A
		 * so indirectly it belongs to type A as well
		 */
		System.out.println(obj instanceof SubClass);
		
		System.out.println(obj instanceof Object);
		/*
		 * every object is an instance of Object Class because every class is extends 
		 * Object superclass 
		 */

	}

}
