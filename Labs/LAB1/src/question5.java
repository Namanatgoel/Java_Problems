import java.util.Scanner;
public class question5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		String[] ProductName = new String[n];
		double[] price = new double[n];
		int[] quantity = new int[n];
		
		System.out.println("Enter product details: ");
		sc.nextLine();
		for(int i = 0; i<n; i++) {
			System.out.print("\nProduct Name: ");
			ProductName[i] = sc.nextLine();
			System.out.print("\nPrice: ");
			price[i] = sc.nextDouble();
			System.out.print("Available quantity: ");
			quantity[i] = sc.nextInt();
			sc.nextLine();
		}
		double totalBill = 0;
		System.out.print("Enter the number of products: ");
		int buycount = sc.nextInt();
		for(int i = 0; i<buycount; i++) {
			System.out.print("Enter product number: ");
			int choice = sc.nextInt()-1;
			System.out.print("Quantity to buy: ");
			int buyQty = sc.nextInt();
			
			if(buyQty <= quantity[choice]) {
				double cost = buyQty*price[choice];
				totalBill += cost;
				quantity[choice] -= buyQty;}
			else {
				System.out.println("Insufficient cost! ");
			}
		}
		System.out.println("Total bill: "+totalBill);
		sc.close();	
	}
}
