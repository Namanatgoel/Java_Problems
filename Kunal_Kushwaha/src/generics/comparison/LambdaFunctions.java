package generics.comparison;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i<5; i++) {
			arr.add(i+1);
		}
		
		arr.forEach((item) -> System.out.println(item*2));
		/*
		 * the (item) is containing the parameters 
		 * and the part ahead of '->' is containing the body of the function
		 */
		
		Consumer<Integer> fun = (item) -> System.out.println(item*2);
		arr.forEach(fun);
	
		Operation sum = (a,b) -> a+b; //Integer::sum
		Operation prod = (a,b) -> a*b;
		Operation sub = (a,b) -> a-b;
		
		LambdaFunctions myCalculator = new LambdaFunctions();
		System.out.println(myCalculator.operate(5,3,sum));
		System.out.println(myCalculator.operate(5,3,prod));
		System.out.println(myCalculator.operate(5,3,sub));
	}
	
	private int operate(int a, int b, Operation op) {
		return op.operation(a, b);
	}
}

interface Operation{
	int operation(int a, int b);
}
