package polymorphism;

public class Numbers {
	int sum(int a, int b) {
		return a+b;
	}
	
	double sum(float a, int b) {
		return a+b;
	}
	
	int sum(int a, int b, int c) {
		return a+b+c;
	}
	
	/*
	 * CHANGE OF ORDER OF TYPE WORKS BELOW
	 */
	
	void sum(int a, String b) {
		
	}
	
	void sum(String b, int a) {
		
	}
	/*
	 * BOTH OF THEM WORKS, BUT NOT TOGETHER
	void sum(String a, int b) {
		
	}*/
	
	/*
	 * Below is an explanation of casting, int is casted to double but not vice-versa
	 */
	double sum(double a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		Numbers obj = new Numbers();
		
		System.out.println(obj.sum(12, 2));
		System.out.println(obj.sum(3, 3));
		/*
		 * Below dont work as there is no (int, double)
		 * System.out.println(obj.sum(3, 3.0));
		 */
		//the below one works bec we have (double, int)
		System.out.println(obj.sum(3.0, 3));
	}
}

