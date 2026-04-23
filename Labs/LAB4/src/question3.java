import java.util.Scanner;

class bankAccount{
	String name;
	int accNo;
	String accType;
	double balanceAmount;
	double minBalance;
	static double roi = .07;
	
	bankAccount(){
		name = "N//A";
		accNo = -1;
		accType = "N//A";
		balanceAmount = -1;
		minBalance = -1;
	}
	
	bankAccount(String name, int accNo, String accType, double balanceAmount, double minBalance){
		this.name = name;
		this.accNo = accNo;
		this.accType = accType;
		this.balanceAmount = balanceAmount;
		this.minBalance = minBalance;
	}
	
	void deposit(double amount) {
		balanceAmount += amount;
		System.out.println(amount + "Rs. deposited");
	}
	
	void withdraw(double amount) {
		if (balanceAmount - amount < minBalance) {
			System.out.println("Not enough money!!");
		}else {
			balanceAmount -= amount;
			System.out.println(amount + "Rs. withdrawn");
		}
	}
	
	void display() {
		System.out.println("Name of account holder: " + name);
		System.out.println("Account number: " + accNo);
		System.out.println("Account type: " + accType);
		System.out.println("Account balance: " + balanceAmount);
	}
	
	static void rateOfInterest() {
		System.out.println();
		System.out.println("Rate of interest is: " + roi);
		System.out.println();
	}
	
}

public class question3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int tNo;
		double tBalance, tMinBalance, amount;
		String tName, tType;
		
		bankAccount.rateOfInterest();
		bankAccount account1 = new bankAccount();
		System.out.println("Enter values of first account: ");
		System.out.println("Enter name: ");
		account1.name = in.nextLine();
		System.out.println("Enter account number: ");
		account1.accNo = in.nextInt();
		System.out.println("ENter account type: ");
		account1.accType = in.nextLine();
		account1.accType = in.nextLine();
		System.out.println("Enter account balance: ");
		account1.balanceAmount = in.nextDouble();
		System.out.println("Enter minimum account balance: ");
		account1.minBalance = in.nextDouble();
		System.out.println("Enter ammount to deposit: ");
		amount = in.nextDouble();
		account1.deposit(amount);
		System.out.println();
		account1.display();
		
		System.out.println();
		System.out.println();
		System.out.println("Enter values of second account: ");
		System.out.println("Enter name: ");
		tName = in.nextLine();
		tName = in.nextLine();
		System.out.println("Enter account number: ");
		tNo = in.nextInt();
		System.out.println("ENter account type: ");
		tType = in.nextLine();
		tType = in.nextLine();
		System.out.println("Enter account balance: ");
		tBalance = in.nextDouble();
		System.out.println("Enter minimum account balance: ");
		tMinBalance = in.nextDouble();
		
		bankAccount account2 = new bankAccount(tName, tNo, tType, tBalance, tMinBalance);
		System.out.println("Enter amount to withdraw: ");
		amount = in.nextDouble();
		account2.withdraw(amount);
		System.out.println();
		account2.display();
	}

}
