public class BankTransferPayment extends Payment{

    private  String accountNumber;

    public BankTransferPayment(String name, String accountNumber) {
        super(name);
        this.accountNumber = accountNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Processing Bank Transfer...");
        System.out.println("Account; " + accountNumber);
        System.out.println("Paid ₦" + amount + " via Bank Transfer.");
        receipt(amount);
    }
}
