package polymorphism;

public class Main {
	public static void main(String[] args) {
		Shapes shape = new Shapes();
		Shapes circle = new Circle();
		/*
		 * what variable is able to access depends on left hand side
		 * here it is Shapes but type of method in overriding that is called depends
		 * on what the type of object is
		 * 
		 * that doesn't mean that reference type (here Shapes) shoudln't have the area()[ONLY FOR OVERRIDDING CONDITION STATED IN THE NEXT BLOCK COMMENT]
		 * 
		 * but it calls the object base class
		 * as the base class one is over
		 * 
		 * what it is able to access is defined by the type of the reference,
		 * which one it is able to access is defined by the type of the object
		 */
		
		/*
		 * Overriding basically means if the type of the reference variable is the 
		 * parent class, but the object is of the type sub-class.
		 * So super-class type reference variable is referring to a sub-class type object
		 * 
		 * How overriding works?
		 * Parent obj = new Child();
		 * Here, which method will be called depends on the type of CHILD
		 * This is known as UPCASTING 
		 */
		
		/*
		 * How does Java knows which particular function to run out the child and parent class?
		 * Parent tells that you can access area method, but which particular
		 * version of area to call depends on the object
		 * 
		 * SO THAT IS WHY EVEN THOUGH WE ARE USING CIRCLE sub-class ka method area
		 * we STILL NEED TO HAVE area METHOD IN THE SHAPES super-class as well
		 * 
		 * Java determines this with DYNAMIC METHOD DISPATCH.
		 * It is just a mechanism by which a call to an overridden method is resolved
		 * at runtime, rather than at compile time
		 */
		Square square = new Square();
		
		/* Shapes square2 = new Square();
		 * 
		 * square2.area();
		 * 
		 * has access to this : Area is side * side
		 * as Square is the object
		 */
		
		shape.area(); //area exists in shape
		circle.area(); //area exists in circle so need not check its super class Shapes
		square.area();
	}
}
