package Singleton;
/*
 * if we only want to create one object of a class, it is called Singleton class
 * 
 * that means, 
 * we stop people from calling the constructor of this class
 * bec whenever we call constructor, a new object is created and we want to stop that
 * 
 * constructor with a new keyword creates an object
 */
public class singleton {
	/*
	 * private means it can be used in this class only (singleton.java)
	 * not even in the same package
	 */
	private int num = 0;
	private singleton() {
		
	}
	
	
	/*
	 * we only need one instance so
	 * 
	 * this instance is not going to be dependent on an object of this class (named singleton)
	 * we are not going to create an object of this class, as it is not allowed
	 * we only would be returning this object (named instance) that is created internally somewhere
	 * so we put it also as static
	 */
	private static singleton instance;
	
	
	/*
	 * we create a function that will give us an instance
	 * it returns  a singleton type of instance
	 * 
	 * need to make it static as we have to reference it through a static main function
	 * and non static method cannot be referenced from a static method
	 * 
	 * whenever we have to access the such variables and methods by classname
	 * it makes sense to put those as static 
	 */
	public static singleton getInstance() {
		/*
		 * whenever someone calls this getInstance();
		 * first check whether 1 object only is created or not
		 */
		if(instance == null) {
			instance = new singleton();
			/*
			 * constructor can be called here as it private so can be called in the same class
			 */
		}
		
		return instance;
	}
	
	singleton(String name){
		
	}

}
