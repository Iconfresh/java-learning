// Student class represents one student in the school

public class Student {

    private int studentId;
    private String name;
    private String classLevel;
    private double totalFees;
    private double feesPaid;

    // Constructor to initialize student

    public Student(int studentId, String name, String classLevel, double totalFees, double feesPaid) {
        this.studentId = studentId;
        this.name = name;
        this.classLevel = classLevel;
        this.totalFees = totalFees;
        this.feesPaid = feesPaid;
    }

    public Student(int id, String name, String classLevel, double totalFees) {

    }

    // method to pay school fees
    public  void payFees(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Payment must be Positive");
            return;
        }

        if (feesPaid + amount > totalFees) {
            System.out.println("Payment exceeds total fees!");
            return;
        }
        feesPaid += amount;
        System.out.println("Payment Successful. You paid: " + amount);
    }

    // Check remaining balance
    public double getBalance() {
        return totalFees - feesPaid;
    }

    // Getters for display purposes
    public int getStudentId() { return studentId;}
    public String getName() { return name; }
    public String getClassLevel() { return classLevel;}
    public double getTotalFees() { return totalFees;}
    public double getFeesPaid() {return feesPaid;}

    // Display student info
    public void showInfo() {
        System.out.println("----------------------------");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Class: " + classLevel);
        System.out.println("Total Fees: " + totalFees);
        System.out.println("Fees Paid: " + feesPaid);
        System.out.println("Balance: " + getBalance());
        System.out.println("----------------------------");
    }


}
