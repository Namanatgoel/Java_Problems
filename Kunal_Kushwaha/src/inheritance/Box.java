package inheritance;
/*
 * can put a class as final to prevent it from getting inherited
 * Whenever we declare a class as final, implicitly its all methods are declared final too
 */
public class Box {
	private double l;
	double b;
	double h;

	static void greeting() {
		System.out.println("Hey I am in box class");
	}
	
	Box(){
		this.h = -1;
		this.l = -1;
		this.b = -1;
	}
	
	//cube
	Box(double side){
		
		super(); //to call the object class
		
		this.b = side;
		this.h = side;
		this.l = side;
	}
	
	Box(double l, double b, double h){
		this.b = b;
		this.h = h;
		this.l = l;
	}
	
	//pass a box, as an argument
	Box(Box old){
		this.h = old.h;
		this.l = old.l;
		this.b = old.b;
	}
	
	public void information() {
		System.out.println("Running the box");
		
	}

}
