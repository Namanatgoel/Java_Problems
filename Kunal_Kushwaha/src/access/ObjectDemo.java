package access;

public class ObjectDemo {
	/*
	 * All the methods available for us to Override the Object Class
	 */
	int num;
	float gpa;
	
	public ObjectDemo(int num, float gpa) {
		this.num = num;
		this.gpa = gpa;
	}
	
	
	@Override
	/*
	 * it gives a number representation of an object
	 */
	public int hashCode() {
		return super.hashCode();
		// return num; 
		// it returns the literal parameter passed number value
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.num == ((ObjectDemo)obj).num;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}	
	
	public static void main(String[] args) {
		ObjectDemo obj1 = new ObjectDemo(43, 56.8f);
		System.out.println(obj1.hashCode());
		
		ObjectDemo obj2 = new ObjectDemo(12, 78.9f);
		System.out.println(obj2.hashCode());
		/*
		 * they will be two different numbers as it not based on the number 43 here
		 * but on the object as a whole, so it is same for an object, but diff for other objects
		 * 
		 * ObjectDemo obj = new ObjectDemo(43);
		 * ObjectDemo obj2 = new ObjectDemo(12);
		 * System.out.println(obj.hashCode());
		 * System.out.println(obj2.hashCode());
		 * 
		 * 724542711
		 * 498931366
		 * 
		 * they are not addresses as in C, we cannot get addresses in java,
		 * they are some random integer value formed via using some algorithm
		 * 
		 * but we can override it by modifying the hashCode method
		 */
		ObjectDemo obj3 = obj2;
		System.out.println(obj3.hashCode());
		
		/*
		 * if(obj1 < obj2) {
		 * System.out.println("obj1 is less than obj2"); }
		 * 
		 * java is confused by the if statement above, that whether to compare the
		 * num variables of every object or the gpa variable of every object
		 */
		
		ObjectDemo obj4 = new ObjectDemo(12, 78.9f);
		System.out.println(obj4.hashCode());
		
		if(obj2 == obj4) {
			System.out.println("obj1 is equal to obj2");
		}
		
		if(obj2.equals(obj4)) {
			System.out.println("obj1 is equal to obj2 in .equals");
		}
		/*
		 * == is like a comparator but .equals() is like a method
		 * == checks if the two variables points to the same object or not
		 * while .equals checks the content of it
		 */
		
		System.out.println(obj1.getClass());
		/*
		 * output: class access.ObjectDemo
		 */
		
		System.out.println(obj1.getClass().getName());
		/*
		 * output: access.ObjectDemo
		 */
		
		/*
		 * can't override getClass() as it is Final
		 * 
		 * the obj1.getClass() information will actually be stored in a heap
		 */
	}
}
