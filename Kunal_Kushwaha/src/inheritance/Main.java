package inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box();
		Box box2 = new Box(box);
		System.out.println(" " + box.b + " " + box.h);
		
		BoxWeight box3 = new BoxWeight();
		System.out.println(
				//box3.l + 
				" " + box3.b + " " + box3.h+ " " + box3.weight);
		
		Box box5 = new BoxWeight(3,4,5,7);
		System.out.println(box5.h);
		/*
		 * It is the type of the reference variable and not the type of the object, that 
		 * determines what members can be accessed.
		 * BELOW
		 * It is a reference type of Box which is referencing to an object of type BoxWeight
		 * A reference to a subclass object is assigned to a super class reference variable like
		 * in the example below, then we have access to only those parts of the objects, that
		 * are defined in the super class  
		 */
	//	System.out.println(box5.weight);
		
		/*
		 * there are many variables in both child and parent classes
		 * we are given access to variables that are in the ref type i.e. BoxWeight
		 * Hence, we should have access to weight variable
		 * this also means the ones we are trying to access should be initialized
		 * But here when the object itself is of type parent class, how will we call the constructor
		 * of child class
		 * 
		 * not able to initialize weight here as the constructor called is of parent class,
		 * which doesn't know abt weight, so the object is of type Box so can't initialize weight
		 * 
		 * So, child ref variable and a parent object is not allowed
		 */
//		BoxWeight box6 = new Box(4,6,7);
//		System.out.println(box6);
		
		box.greeting();
		Box.greeting();
		/*
		 * since greeting() is a static method, it is convention to reference it via
		 * the class name and not through object
		 */
		
		Box box4 = new BoxWeight();
		box4.greeting();
		/*
		 * DIDN'T GOT OVERRIDDEN
		 * but it should be that Box waala should tell what to access
		 * and child class BoxWeight should tell which one to actually access
		 * But the base class one is not getting called
		 * 
		 * If static methods were being inherited, there is no point in overriding them
		 * with a child class bec the method in the parent class with always run, no
		 * matter from which object you call it, bec it is not dependent on object
		 * It is static.
		 * This is the reason, static methods arn't inherited.
		 * So cannot override the static methods, even though it is inherited, and
		 * we can use it via the BoxWeight object, we can use it like below
		 * BUT THEY CANNOT BE OVERRIDDEN
		 * 
		 * OVERRIDING DEPENDS ON OBJECTS, BUT STATIC DOESN'T DEPEND ON OBJECTS, HENCE
		 * STATIC METHODS CANNOT BE OVERRIDEN.
		 * 
		 */
		BoxWeight.greeting();
		
		BoxWeight box6 = new BoxWeight();
		box6.greeting();
	}

}
