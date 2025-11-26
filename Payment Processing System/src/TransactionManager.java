public class TransactionManager {

    public void  processPayment(Payment payment, double amount) {
        System.out.println("\n--- Transaction Started ---");
        payment.pay(amount);
        System.out.println("--- Transaction Completed ---\n");
    }
}
