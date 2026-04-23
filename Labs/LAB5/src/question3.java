/*3. Implement a ShoppingCart class that contains an inner class Item. 
a) The Item class should have fields like itemName, quantity, and price. 
b) The ShoppingCart class should provide methods to add items, calculate the total price, 
and display the cart contents. */
import java.util.Scanner;
class ShoppingCart{
	Scanner sc = new Scanner(System.in);
	int n=0;
	double total = 0.0;
	Item arr[];
	
	class Item{
		String itemName;
		int quantity;
		double price;
		
		Item(String item, int qty, double price){
			this.itemName = item;
			this.quantity = qty;
			this.price = price;
			
		}
	}
	void add_items(){
		System.out.println("Enter the number of items: ");
		n = sc.nextInt();
		arr = new Item[n];
		for(int i = 0; i<n; i++) {
			System.out.println("ItemName: ");
			itemName[i] = sc.next();
			System.out.println("quantity: ");
			quantity[i] = sc.nextInt();
			System.out.println("price: ");
			price[i] = sc.nextDouble();
			Item temp = new Item();
		}
	}
	void price(){
		System.out.println("Total Price: ");
		while(n>0) {
			n--;
			total += quantity*price;
		}
	}
	void display(){
		System.out.println("Content's of the cart: ");
		while(n>0) {
			n--;
			System.out.println("ItemName: "+itemName);
			System.out.println("Quantity: "+quantity);
			System.out.println("Price: "+price);
			System.out.println();
		}
	}
}

public class question3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingCart sct = new ShoppingCart();
		sct.add_items();
		sct.price();
		sct.display();
	}

}
