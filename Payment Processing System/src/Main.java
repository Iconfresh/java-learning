public class Main {

    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();

        Payment p1 = new CreditCardPayment("Ephraim", "1234567812345678");
        Payment p2 = new BankTransferPayment("Noel", "0012345678");
        Payment p3 = new PayPalPayment("Kushi", "ephraimyusuf@gmail.com");

        manager.processPayment(p1, 5000);
        manager.processPayment(p2, 15000);
        manager.processPayment(p3, 2500);
    }
}