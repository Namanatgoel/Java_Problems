package cloning;

public class Human implements Cloneable{
	/*
	 * this cloneable interface doesn't have any abstract methods then why are
	 * we implementing this?
	 * Bec it is a way to the JVM, that we have to perform clone on our object
	 * of type Human
	 */
	int age;
	String name;
	int arr[];
	
	public Human(Human other) {
		this.age = other.age;
		this.name = other.name;
	}
	
	public Human(int age, String name) {
		this.age = age;
		this.name = name;
		this.arr = new int[]{3,4,5,6,7,1};
	}
	
	@Override
	/*
	 * this is overriding bec object.clone() is actually inside the object
	 */
	public Object clone() throws CloneNotSupportedException{
	//	return super.clone();
		/*
		 * whatever thing we use, if that is throwing an exception inside some
		 * function, then we have mention it over at the top using throws
		 */
		/*
		 * this .clone() is doing a shallow copy of the object
		 */
		
		Human twin = (Human)super.clone(); //this is actually shallow copy
		
		//make a deep copy now
		twin.arr = new int[twin.arr.length]; //this is creating a new array now
		for(int i = 0; i<twin.arr.length; i++) {
			twin.arr[i] = this.arr[i];
		}
		
		return twin;
	}
}
