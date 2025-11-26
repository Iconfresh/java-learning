public class PayPalPayment extends Payment{
    private String email;

    public PayPalPayment(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal Payment... ");
        System.out.println("PayPal Email: " + email);
        System.out.println("Paid ₦" + amount + " through PayPal.");
        receipt(amount);
    }
}
