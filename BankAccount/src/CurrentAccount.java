public class CurrentAccount extends BankAccount{

    private double overdraftLimit = 5000;


    public CurrentAccount(String accNo, String owner, double balance) {
        super(accNo, owner, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit < amount) {
            System.out.println("Overdraft limit exceeded!");
            return;
        }
        balance -= amount;
        System.out.println(amount + " Withdrawn from Current Account. ");
    }

    @Override
    public void calculateInterest() {

    }

    @Override
    public void calulateInterest() {
        System.out.println("Current account does not offer interest.");
    }
}
