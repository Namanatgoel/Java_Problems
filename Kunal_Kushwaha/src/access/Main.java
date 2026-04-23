package access;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A(10, "Kaala");
		/*
		 * DO the following:
		 * 1. Access the data members
		 * 2. Modify the data members
		 */
		obj.getNum();
		//as public method so can be accessed from anywhere
		
		int n = obj.num;
	}

}
