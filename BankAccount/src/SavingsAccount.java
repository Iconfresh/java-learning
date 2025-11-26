public class SavingsAccount extends BankAccount{

    private double interestRate = 0.05;

    public SavingsAccount(String accNo, String owner, double balance) {
        super(accNo, owner, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;

        System.out.println("Interest added (Savings): " + interest);
    }

    @Override
    public void calulateInterest() {

    }

}
