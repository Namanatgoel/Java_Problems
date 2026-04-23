package staticExample;
/*
 * In nested classes, the outside classes cannot be static, only inner classes can be static
 */

/*
 * But inner classes can be static as they are dependent on outside class
 */
public class InnerClasses {
	class Test{
		String name;
		
		public Test(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Test a = new Test("Aavi"); 
		/* error bec now the class Test itself is dependent on the outer class, it dont really
		 * have any object
		 * It works if Test class is outside, when it is not dependent on any other class
		 * but if make Test class as static, it works
		 */
		/*
		 * Test() inner class needs an instance of the outer class (InnerClasses) to be run
		 * but main don't have it so error
		 */
		Test b = new Test("Aavi");
	}
}

/*
 * Illegal modifier for the class abc; only public, abstract & final are permitted
 * Even without nested classes too, the outside classes cannot be static bec it is not itself 
 * dependent on any other class
 * 
 * static class abc
 * {
 * 	
 * }
 */