package staticExample;

public class Human {

	int age;
	int salary;
	boolean married;
	String name;
	static long population;
	/*
	 * if only long population; use
	 * it is treated as an instance variable, which is diff for each object
	 */
	/*
	 * When a member is declared static, it can be accessed before any of the object of the class
	 * is being created and without referencing to that object.
	 * We can access static variable even without creating an object
	 */
	/*
	 * Main is static because we can use the main method without creating an object of that class
	 * and Main is run first in java program
	 * if we dont put static then to run any method inside a class, we need to create an object
	 * of that class, but how can we run the program to create an object if Main runs first
	 * so we should be able to run Main without creating any object of the class in which Main is there
	 * Static variables and methods actually belong to the class,
	 * not to the objects 
	 */
	
	static void message() {
		System.out.println("Hello wOrLd");
		/*
		 * since message() method is not dependent on the objects of Human class, we cannot do:
		 * System.out.println(this.age);
		 * bec this keyword is dependent on an object while static isnt, static is a part of the
		 * class, so cannot use anything which is specifically pointing to an object
		 */
	}
	
	public Human
		(
			int age,
			int salary,
			boolean married,
			String name
		) 
	{
		this.age = age;
		this.salary = salary;
		this.married = married;
		this.name = name;
		/*WE don't use this to access the static variables, we just use the class name
		 * this.population += 1;
		 * though the above statement also works
		 * when naman.population, it checks that does the object naman has a variable population?
		 * but here it doesn't so then it checks that
		 * the main Human class has variable known as population?
		 * It does have it here
		 * static variable means it is common to all
		 * CONVENTION: don't access or modify the static variable via the reference variable, ie,
		 * the object name, it will work though
		 */
		Human.population += 1;
		//can like this.message();
		Human.message();
	}
//property of population in human class is object independent, so those properties are
	//static variables or methods
}
