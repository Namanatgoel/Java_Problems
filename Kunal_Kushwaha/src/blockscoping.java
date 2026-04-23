import java.util.Scanner;
public class blockscoping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		System.out.println("1st " + a);
		{
		//gives an error	//int a = 100;
			a = 100; //we reassign the original reference variable to some other value
			//we are not creating a new as we are not initializing it again
			System.out.println("2nd "+a);
			int b = 20;
			System.out.println("i "+b);
		}
		System.out.println("3rd "+a);
		a = 1000;
		System.out.println("4th "+a);
		//can't modify the variable in a block from outside it in the same method b = 40;
		//but we can re-initialize it
		int b = 200;
		System.out.println("ii "+b);
		 b =2000;
		 System.out.println("iii "+b);
		 {
			 b = 90;
			 System.out.println("iv "+b);
		 }
	}

}
