package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {

	private int[] data;
	private static int DEFAULT_SIZE = 10;
	private int size = 0;//also working as index value, check out the remove method
	
	public CustomArrayList() {
		this.data = new int[DEFAULT_SIZE];
	}
	
	/*
	 * Creating our own methods, we don't want the user to change or modify the arraylist
	 * we want them to access it using the get and set methods
	 */
	
	public void add(int num) {
		if(this.isFull()) {
			resize();
		}
		
		data[size++] = num;
	}
	
	private void resize() {
		/*
		 * resize is to make another array double the size of the previous one
		 * and copy the current items into the new array
		 */
		int[] temp = new int[data.length*2];
		
		//now copying the current items in the new array
		for(int i = 0; i<data.length; i++) {
			temp[i] = data[i];
		}
		
		data = temp;
		/*
		 * when this resize function is over, the temp array will go out of scope
		 * so it will be finished but data is outside this function
		 * data is an instance variable and will go out of scope only when the 
		 * object is finished
		 */
	}
	
	/*
	 * creating a remove function now, which returns the value which is removed
	 */
	public int remove() {
		int removed = data[--size];
		/*
		 * removed item is the last one as we are just decreasing the size by 1
		 */
		return removed;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(data.length==0) {
			return true;
		}
		return false;
	}
	
	public void set(int index, int value) {
		data[index] = value;
	}
	
	public int get(int index) {
		return data[index];
	}
	
	private boolean isFull() {
		// TODO Auto-generated method stub
		/*isFull is for checking if the ArrayList is full 
		 * 
		 * ie, if size == data array length
		 * */
		return size == data.length;
	}

	@Override
	public String toString() {
		return "CustomArrayList{" +
				"data=" + Arrays.toString(data) +
				", size=" + size +
				'}';
		/*
		 * the number stored in the size variable is not the actual size of the 
		 * array, rather the size of the data we have entered
		 */
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomArrayList list = new CustomArrayList();
		list.add(32);
		list.add(2);
		list.add(3);

	/*		
 * System.out.println(list.toString());
 * System.out.println(list);
 * The above two prints it in the object way till the time toString is not overridden
 * OUTPUT: generics.CustomArrayList@2b2fa4f7
 * */

		System.out.println(list);
		System.out.println(list.toString());
		
		for(int i = 0; i<14; i++) {
			list.add(2*i);
		}
		System.out.println(list);
	}

}
