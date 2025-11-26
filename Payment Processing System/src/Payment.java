public abstract class Payment implements payable {

    protected String name;

    public Payment(String name) {
        this.name = name;
    }

    // All payment types must implement this
    public abstract void pay(double amount);

    public void receipt(double amount) {
        System.out.println("Payment receipt for " + name + ": ₦" + amount);
    }
}
