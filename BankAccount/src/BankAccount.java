// Abstract class that defines common features for all bank accounts.
//Every account has an account number, owner's name, and balance.
// Subclass (Savings, Current) Must define  calculateInterest().

public abstract class BankAccount {

    protected String accountNumber;
    protected  String owner;
    protected double balance;

    // Constructor to initialize a bank account
    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    // Deposit money ( Common to all accounts )
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposit into " + accountNumber);
    }

    // Withdraw money ( Common but can be overriden by child classes)
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return;
        }
        balance -= amount;
        System.out.println(amount + " withdraw from" + accountNumber);
    }

    // Abstract: Every account type must calculate interest differently
    public abstract void calculateInterest();

    // Show account details
    public void display() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Owner: " + owner);
        System.out.println("Balance: " + balance);
    }

    public abstract void calulateInterest();
}
