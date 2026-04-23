package staticExample;

class Test{
	static String name;
	public Test(String name) {
		Test.name = name;
	}
}

public class working_InnerClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a = new Test("Umal");
		Test b = new Test("Ismael");
		
		System.out.println(a.name);
		System.out.println(b.name);
		System.out.println(Test.name);
		/*
		 * first a.name changes the static String name to Umal
		 * then b.name changes it to Ismael
		 * and since it is static, object independent so its value is same for all the objects of
		 * the class so prints the same name latest modified
		 */
	}

}
