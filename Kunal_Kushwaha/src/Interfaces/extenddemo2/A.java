package Interfaces.extenddemo2;

public interface A {
	/*
	 * static methods never get inherited
	 * so if we have static methods, means they cannot be overridden means
	 * they should have a body over here bec they will be used from interface only
	 * so static interface methods WILL ALWAYS HAVE A BODY
	 */
	
	static void greeting() {
		System.out.println("Hey I am a static method");
	}
	
	default void fun() {
		System.out.println("I am in A");
	}
}
