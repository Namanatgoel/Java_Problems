package generics;

import java.util.ArrayList;

public class Inbuilt_arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(10);
		/*
		 * over here, <Integer> is called generics, they help us provide type
		 * to these values (ArrayList)
		 * 
		 * like our CustomArray only could take integers
		 * but the inbuilt ArrayList has options of integer, string etc
		 * 
		 * ArrayList<Integer>
		 * This class ArrayList will only have a particular type of objects which
		 * is <Integer> over here
		 * They cannot be primitives but only classes can be used here
		 * ex-: <int> won't work
		 * 
		 */
		System.out.println(list.add(45));
		System.out.println(list.set(0, 32));
		System.out.println(list.get(0));
		System.out.println(list.remove(0));
		/*
		 * if we put list.set here, it will give an error because
		 * set() does NOT insert elements.
		 * It only replaces an existing element.
		 * 
		 * WRONG- new ArrayList<>(10) means: [0,0,0,0,0,0,0,0,0,0]
		 * IT actually means: []
		 * with capacity to hold 10 elements.
		 * 
		 * empty shelf with space for 10 books
		 * But until you add books, the shelf is empty.
		 */
		System.out.println(list.size());
		System.out.println(list.isEmpty()); 
		System.out.println(list);
	}

}
