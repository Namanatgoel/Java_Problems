package polymorphism;

public class Circle extends Shapes{
	
	//this will run	when obj of Circle is created
	//hence it is OVERRIDING the parent method
	
	@Override //this is called annotation
	//to check if a method is overridden or not, write @Override over it
	void area() {
		System.out.println("Area is pie*r*r");
	}
	
	//example below method is not being overridden so can't write @Override over it
	/*@Override
	void area2() {
		
	}*/
}
