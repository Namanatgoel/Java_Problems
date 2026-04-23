package inheritance;

public class BoxWeight extends Box{
	double weight;
	
//	@Override
	/*
	 * Cannot override a static method
	 */
	static void greeting() {
		System.out.println("Hey I am in box weight class");
	}
	
	public BoxWeight() {
		this.weight = -1;
	}
	
	/*
	 * the other we are passing in super is a BoxWeight type but there in the parent class constructor,
	 * it actually takes it as Box type.
	 * It is the same thing as : Box box5 = new BoxWeight(3,4,5,7);
	 * Again what is accessed is based on the type of reference variable, not on the type of the object
	 */
	BoxWeight(BoxWeight other){
		super(other);
		weight = other.weight;
	}
	
	public BoxWeight(double l, double h, double b, double weight) {
		
		/*
		 * if super isn't used in a sub class constructor then the default one is called from the
		 * parent class
		 */
		
		super(l, h, b); 
		//call the parent class constructor
		//the one with 3 parameters is initialized
		//used to initialize the values present in parent class
		
		/*
		 * also, can use the super keyword as the 'this' keyword, the only difference is
		 * that it will be used to access the super class keywords
		 */
		
		System.out.println(this.h);
		/*
		 * this keyword checks if BoxWeight have h, here it doesn't so
		 * it moves to the parent Box class
		 * we can instead use super keyword directly
		 * 
		 * but the variables which are in child class, cannot be accessed by the super keyword
		 * unlike this keyword, which can access both types of variables
		 * 
		 * super keyword is used if superclass have a same name variable and we want to access it
		 * in that case this returns the child class variable 
		 */
		System.out.println(super.h);
		System.out.println(this.weight);
	//	System.out.println(super.weight);
		
		this.weight = weight;
	}
	/*
	 * sub class, cannot access private members of the superclass
	 * though the initialization of such members can still be done just like here
	 * bec Box constructor is initializing it here, not us
	 * but accessing like this will give an error -> box2.l;
	 */
}	
