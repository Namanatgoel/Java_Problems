package staticExample;

public class static_InnerClasses {
	
	static class Test{
		String name;
		public Test(String name) {
			this.name = name;
		}
	}
	
	static class Test2{
		static String name;
		public Test2(String name) {
			Test2.name = name;
		}
		
		//now here, toString exists which is returning name, which it prints
		public String toString() {
			return name;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a = new Test("Umal");
		Test b = new Test("Ismael");
		
		System.out.println(a.name);
		System.out.println(b.name);
		//System.out.println(Test.name);
		/*
		 * now as inner class is static, so it is not dependent on the objects of the outer class
		 * to use that class, an object of outer class need not be created now
		 * So this is working
		 * as it only depends on the outer class itself now and not on its object or instance creation
		 */
		/*
		 * It prints now
		 * Umal
		 * Ismael
		 * bec static here doesn't mean that objects a and b cannot have their individual
		 * identities, it basically means that they dont depend on the objects of outer class
		 * but internally main and test can depend on each other 
		 */
		
		Test2 aa = new Test2("umal");
		Test2 bb = new Test2("ismael");
		
		System.out.println(aa.name);
		System.out.println(bb.name);
		System.out.println(Test2.name);
	
		System.out.println(a);
		/*
		 * when we try to print any object of the inner class (here Test),
		 * when we call an object, java called valueOf and that calls toString method
		 * Internally it calls a.toString
		 * But a doesn't contain toString, then it checks that if, 
		 * the class which a belongs to (here Test class) doesn't
		 * contain toString, so it use its own toString by default which is
		 * ClassName + @ + hashvalue 
		 */
		
		System.out.println(aa);
		/*
		 * toString is there in this class
		 * so OverRiding
		 */
	}
/*
 * static stuff is resolved during compile time as they have nothing to with objects
 * which are created during runtime
 * they are class level methods
 */
	/*
	 * println is a variable
	 * out is a method
	 * System is a class
	 */
}
