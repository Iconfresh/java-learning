public class TransferService {

    public void transfer(BankAccount from, BankAccount to, double amount) {
        System.out.println("\n--- Transfer Started ---");

        if (from.balance < amount) {
            System.out.println("Transfer failed! Insufficient funds.");
            return;
        }

        from.withdraw(amount);
        to.deposit(amount);

        System.out.println("Transfer of " + amount + "Completed.");
        System.out.println("--- Transfer Ended ---\n");
    }
}
