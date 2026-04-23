class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String name, String accNo, String type, double initialBalance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = type;
        this.balance = initialBalance;
    }
    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void displayBalance() {
        System.out.println("Account No: " + accountNumber + " | Current Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate = 0.05; 

    SavingsAccount(String name, String accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " added to Savings Account.");
    }
    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

class CurrentAccount extends Account {
    double minBalance = 1000.0;
    double serviceTax = 150.0;

    CurrentAccount(String name, String accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }
    
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinBalance(); 
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    void checkMinBalance() {
        if (balance < minBalance) {
            balance -= serviceTax;
            System.out.println("Alert: Balance below minimum! Service tax of " + 
            serviceTax + " imposed.");
        }
    }
}

public class ques4 {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("Aryan", "SA101", 5000);
        sa.displayBalance();
        sa.deposit(1000);
        sa.computeAndDepositInterest();
        sa.withdraw(2000);
        sa.displayBalance();
        
        CurrentAccount ca = new CurrentAccount("B", "CA201", 1200);
        ca.displayBalance();
        ca.withdraw(300); 
        ca.displayBalance();
    }
}

