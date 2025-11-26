public class CreditCardPayment extends Payment {

    private String cardNumber;

    public  CreditCardPayment(String name, String cardNumber) {
        super(name);
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment...");
        System.out.println("Card Number: **** **** ****" + cardNumber.substring(12));
        System.out.println("Paid ₦" + amount + " using Credit Caard.");
        receipt(amount);
    }

}
