import java.util.Scanner;

class Counter{
	static int count = 0;
	Counter(){
		count ++;
	}
	
	static void showCount() {
		System.out.println("Number of objects created is " + count);
	}
}

public class question4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		
		System.out.println("How many objects do you want to create: ");
		n = in.nextInt();
		
		Counter[] objects = new Counter[n];
		for(int i = 0; i < n; i++) {
			objects[i] = new Counter();
			Counter.showCount();
		}
	}

}
