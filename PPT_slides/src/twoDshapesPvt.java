/*Each subclass can have atmost 1 superclass
 * but each superclass can have multiple subclasses
 * MULTIPLE INHERITANCE IS NOT ALLOWED IN JAVA
 * ex-: class C extends A,B{} is not allowed
 */
//a class for 2D objects
/*
 * A subclass cannot access the private members of its superclass.
 * Each class can have at most one superclass, but each superclass can have many subclasses.
 * A subclass constructor can call a superclass constructor by use of super( ), 
 * before doing anything else.
 * If you do not call a superclass constructor, the no-argument constructor is 
 * automatically called.
*/

class TwoDshape {
	private double width;
	private double height;

	double getWidth() {
		return width;
	}

	double getHeight() {
		return height;
	}

	void setWidth(double w) {
		width = w;
	}

	void setHeight(double h) {
		height = h;
	}

	void showDim() {
		System.out.println("Width and height are " + width + " and " + height);
	}
}

//a subclass of TwoDshape for triangles
class riangle extends TwoDshape {
	String style;

	double area() {
		return getWidth() * getHeight() / 2;
	}

	// cant access a private member of a superclass
	// inherting a class doesnt over rules private properties
	void showStyle() {
		System.out.println("Triangle is: " + style);
	}
}

public class twoDshapesPvt {

	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		t1.setWidth(4.0);
		t1.setHeight(4.0);
		t1.style = "filled";
		t2.setWidth(8.0);
		t2.setHeight(12.0);
		t2.style = "outlined";
		System.out.println("Info for t1: ");
		t1.showStyle();
		t1.showDim();
		System.out.println("Area is " + t1.area());
		System.out.println();
		System.out.println("Info for t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("Area is " + t2.area());
	}
}
/*get and set methods can be used in the sub class because else private variables 
 * won't work
 */
