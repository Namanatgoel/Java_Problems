import java.util.*;
import java.util.ArrayList;
public class ArrayListExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>(10);
		list.add(67);
		list.add(7);
		list.add(6);
		//can add as many as we want despite 10 being specified there as the initial capacity
		//add is a list method
		System.out.println(list);
		System.out.println(list.contains(67));
		
		list.set(0, 99);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		for(int i = 0; i<5; i++) {
			list.add(in.nextInt());
		}
		System.out.println(list);
		for(int i = 0; i<5; i++) {
			System.out.println(list.get(i)); //list[index] syntax dont work
			//pass index here to get item at any index
		}
	}

}
