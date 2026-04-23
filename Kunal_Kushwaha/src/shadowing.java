import java.util.Scanner;
public class shadowing {
	static int x = 90; //x will be available in the entire block, it is the higher level
	//static for using it in main function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun();
		System.out.println(x); 
		x = 10;
		System.out.println(x);
		fun();
		x = 98;
		fun();
		System.out.println(x);
		int x = 100; //from this moment, x stops changing for the outside main x as we 
		//as we initialize a new x
		System.out.println(x);
		fun();
		x = 88; //now as it is re-initialized, it changes only in this scope
		System.out.println(x);
		fun();
	}
	static void fun() {
		System.out.println("it is called by fun " + x);//the scope of x in main remains till there
		//the x used here is the upper level one
	}
//SHADOWING IN JAVA -> using two variables with the same name within the scope that overlaps
//lower level scope is riding the upper level scope
//higher level is shadowed
//scope will begin when the value is initialized and not just declared 
}
