class A{
	final int num = 10;
	String name;
	
	A(String name){
		this.name = name;
	}

}
public class WrapperExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		
		//now created like an object unlike a
		//Integer wrapper class
		Integer num = new Integer(43);
		//Or equivalent to the above 
		Integer n = 83;
		
		Integer b = 10;
		Integer c = 20;
		swap(b,c);
		System.out.println(b + " " + c);
		
		final int bonus = 2;
		//can't do ==> bonus = 34;
	
		final A kunal = new A("Shaan Goel");
		kunal.name= "Other name"; //this is possible
		//but the below thing is not possible
		//when a non primitive is final, you cannot reassign it, you can change the
		//values though
		//kunal = new A("new object");
	
		A obj = new A("Rajvanshi");
		System.out.println(obj); //shows random hash value
		/*we want whenever we print an obj of type A
		 * It should print out name and num (as in class A)
		 * For that we use something called @Override
		 */
	}
	
	static void swap(Integer a, Integer b) {
		//int temp = a;
		Integer temp = a;
		a = b;
		b = temp;
	}
	
//example swap doesn't work on variables a and b
	//but if we convert them to Integer a and b, then they become reference variables
	//to the object
/* It still don't work bec
 * Integer class is final
 */
	
	
}
