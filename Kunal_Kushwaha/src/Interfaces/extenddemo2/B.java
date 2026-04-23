package Interfaces.extenddemo2;

public interface B{
	void greet();
//	void fun();
	/*default void fun() {
		System.out.println("I am in B");
	}*/
	/*
	 * now when we put fun() as default in both interfaces, we get an error
	 */
}
