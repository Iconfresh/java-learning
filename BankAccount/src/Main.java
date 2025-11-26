public class Main {

    public static void main(String[] args) {

        // Create Accounts
        SavingsAccount acc1 = new SavingsAccount("001", "Ephraim", 20000);
        CurrentAccount acc2 = new CurrentAccount("002", "Yusuf", 3000);

        // Display initial data
        acc1.display();
        acc2.display();

        // Deposit & Withdraw
        acc1.deposit(100000);
        acc1.withdraw(20000);


        acc2.withdraw(6000); // uses overdraft

        // Interest
        acc1.calculateInterest();
        acc2.calculateInterest();

        // Transfer Service
        TransferService bank = new TransferService();
        bank.transfer(acc1, acc2, 10000);

        // Final Balances
        acc1.display();
        acc2.display();


    }
}