package staticExample;

public class StaticBlock {
	static int a =4;
	static int b;
	//we know they are not dependent on objects
	//we need to some work to initialize them
	//can do this via a static block which gets executed exactly once when the class is first loaded
	
   /* when class got first loaded, the static variables ran, then static block
	* when another object2 got created, then too nothing of static ran as only run once, when the
	* first object is created, ie, when the class is loaded for the first time , that is why
	* I am static block is only printed once */
	static {
		System.out.println("I am in static block");
		b = a*5;
	}
	public static void main(String[] args) {
		StaticBlock obj = new StaticBlock();
		System.out.println(StaticBlock.a + " and "+ StaticBlock.b);
		System.out.println(a + " and "+ b);
		
		StaticBlock.b += 3;
		
		StaticBlock obj2 = new StaticBlock();
		System.out.println(StaticBlock.a + " and "+ StaticBlock.b);
		System.out.println(a + " and "+ b);
		
		b += 4;
		System.out.println(StaticBlock.a + " and "+ StaticBlock.b);
		System.out.println(a + " and "+ b);
		
		StaticBlock obj3 = new StaticBlock();
		System.out.println(StaticBlock.a + " and "+ StaticBlock.b);
		System.out.println(a + " and "+ b);
		
	}
}
