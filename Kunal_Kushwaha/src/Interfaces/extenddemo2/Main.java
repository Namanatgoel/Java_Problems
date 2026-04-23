package Interfaces.extenddemo2;

public class Main implements A, B{
/*
 * as B extends A, so while implementing B, will have to implement both the methods of
 * interfaces A and B
 */
/*	@Override
	public void fun() {
		// TODO Auto-generated method stub
		
	}
*/
	/*
	 * even though there is a method in the interface which isn't overridden by us,
	 * still we are not getting an error bec there is a default being used
	 */
	@Override
	public void greet() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Main main = new Main();
		A.greeting(); //static method called via the interface name
	}
	
	/*
	 * THE access modifier for the OVERRRIDDEN methods should be same or better
	 * ex-: if in parent class, the method was protected then in the overridden method,
	 * it should be protected or something better ie something lesser restrictive than
	 * the access method in parent class
	 * better --> public > protected > no modifier(default) > private
	 */
}
