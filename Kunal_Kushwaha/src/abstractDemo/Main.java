package abstractDemo;

public class Main {
	public static void main(String[] args) {
		Son son = new Son(32);
		son.career();
		
		Daughter daughter = new Daughter(23);
		daughter.career();
		
//		Parent mom = new Parent(32);
		/*
		 * Cannot create direct objects of an abstract class
		 * 
		 * it can be created but only with Overriding
		 */
		Parent mom = new Parent(43) {
			@Override
			void career() {
				
			}
			
			@Override
			void partner() {
				
			}
		};
		
		Parent.hello();
		
		/*
		 * Even though we cannot create object of an abstract parent class, we can still
		 * use it as a reference variable like below
		 */
		Parent daughter2 = new Daughter(29);
		daughter2.career();
	}
}
