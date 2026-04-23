package staticExample;

public class Main {

	public static void main(String[] args) {
		//can use human class without importing as in the same package folder
		Human chaman = new Human(3, 100, true, "chaman");
		// TODO Auto-generated method stub
		Human naman = new Human(32, 10000, false, "naman");
		
		System.out.println(naman.name);
		System.out.println(naman.population);
		System.out.println(chaman.population);
		/*
		 *  * CONVENTION: don't access or modify the static variable via the reference variable, ie,
		 * the object name, it will work though
		 */
		
		System.out.println(Human.population);
		
		//both prints 1, which is false, we want the population to inc on every human object
		//and it is independent of them, ie, same for all

		/*
		 * Java does not allow method definitions inside another method.
		 * SO, can't write the below method here:
		 * void greeting() 
		 * {System.out.println("This is hello world");}
		 * You can define methods:
		 * Inside a class
		 * But NOT inside another method (like main)
		 */
		
		greeting();
		/*
		 * Cannot make a static reference to the non-static method greeting() from a static object
		 * MEANS, inside a static method, we cannot use anything that is non-static.
		 * A static method can only access static data, bec
		 * something which is not static belongs to an object 
		 * hence, without somehow resolving that which instance of a class we are talking about
		 * for ex, in static we dont hv an instance bec the non static is going to have an instance
		 * but the static won't be having one
		 */
		
		Main funn = new Main();
		funn.fun2(); 
		/*
		 * created an object for funn
		 * so the fun() is also now a part of fun2
		 */
	}
	
	void fun2() {
		fun();
		/*
		 * fun() uses fun2() object to run as both are non static and fun2() object will be created
		 * so no need of separate object creation in fun2() method for fun(), though it is non static
		 * bec already fun2() obj is created in Main method which is called first so
		 * fun() being inside it is already handled automatically
		 */
	}
	
	void fun() {
		greeting();
		/* can call static in non-static
		 * but not vice-versa bec non static is dependent on obj while static isnt
		 * the non-static belongs to an instance, while the static don't belong to an instance
		 * so without specifying which instance the non static belongs to, we cannot use it in static
		 */
	}
	
	static void greeting() {
		System.out.println("This is hello world");
		/*
		 * fun();
		 * OR
		 * Main.fun();
		 * Cannot make a static reference to the non-static method fun() from the type Main
		 * 
		 * without specifying which instance the non static belongs to, we cannot use it in static
		 * 
		 * the function we are using this fun() in does not depend on instances
		 * 
		 * something which DOES NOT depend on instances cannot have inside it something which
		 * depends on instances while VICE-VERSA is possible bec
		 * 
		 * We need to mention the object reference to it, if we want to access a non static inside static
		 * 
		 * something which is belonging to an object can have inside it another thing which
		 * doesnt belong to any object
		 * 
		 */
		
		//now we referenced the instance of non static stuff here in a static context
		//hence, here we are referencing it
		
		/*
		 * Everything will be called in the end by a static main method
		 */
		
		/*
		 * greeting method here is static so need no object to run, so can't make an object for 
		 * fun() to be handled automatically, so fun() has to create an object for itself like below
		 */
		
		Main obj = new Main();
		obj.fun();
	}

}
