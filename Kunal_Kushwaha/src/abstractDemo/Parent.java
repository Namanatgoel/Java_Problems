package abstractDemo;

public abstract class Parent {
	
	static int age;
	
	/*
	 * We can create constructor of a abstract class
	 */
	public Parent(int age) {
		this.VALUE = 4530;
		this.age = age;
	}

	final int VALUE; //have to initialize through constructor
	
	/*
	 * Cannot create abstract constructors
	 */
//	abstract Parent();
	
	/*
	 * Cannot create objects of abstract classes
	 */
	
	/*
	 * static methods cannot be overridden 
	 * abstract methods need to be overridden
	 * 
	 * so abstract static methods cannot be created 
	 * 
	 * but we can create static methods in abstract classes
	 */
	
	static void hello() {
		System.out.println("hey");
	}
	
	void normal() {
		System.out.println("this is a totally normal method");
	}
	
	abstract void career();
	abstract void partner();
	/*
	 * can't have a final abstract class bec both of them have opposite functions
	 */
	
}
