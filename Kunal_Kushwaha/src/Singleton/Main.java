package Singleton;

import access.A;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singleton obj = new singleton("Kaman");
		/* private so cannot access
		 * obj.num;
		 * similarly a private constructor can also be not called
		 * singleton obj = new singleton();
		 */
		
		singleton obj1 = singleton.getInstance();
		
		singleton obj2 = singleton.getInstance();
		
		singleton obj3 = singleton.getInstance();
/*
 * now whenever we asked for an instance, we give it the same instance
 * even though it creates so many reference variables
 * 
 * only 1 object is created in the memory
 * and we give them the reference variable to that object only (which is named instance here)
 */
	/*
	 * all three reference variables obj1, obj2, obj3 are pointing to just one object
	 */
		
		//below code is connected to access package 
		A a = new A(10, "Kaala");
		a.getNum();
		int n = a.num;	
	}

}
