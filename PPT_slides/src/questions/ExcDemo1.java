package questions;

public class ExcDemo1 {
	public static void main(String args[]) {
		int nums[] = new int[4];
		
		try {
			System.out.println("Before the exception is generted");
			nums[7] = 10;
			System.out.println("ye nhi dikhega");
			}
		catch(ArrayIndexOutOfBoundsException exc){
			System.out.println("Index bound ke bahaar hai bhai");
		}
		System.out.println("catch vagehra sab khatam ho gya, agar try catch nhi hota, toh ye"
				+ " statement kabhi nhi dikhta, kyoki exception pr program khatam ho jaata");
	}
}
	