import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\n==== School Fees Payment System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Pay Fees");
            System.out.println("3. Check Student Balance");
            System.out.println("4. view All Students");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    int id = input.nextInt();
                    input.nextInt(); // Consume leftover newLine

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Class: ");
                    String classLevel = input.nextLine();

                    System.out.println("Enter Total Fees: ");
                    double totalFees = input.nextDouble();

                    Student s = new Student(id, name, classLevel, totalFees);
                    school.addStudent(s);
                    break;

                case 2:
                    System.out.print("enter Student ID: ");
                    int sid = input.nextInt();

                    Student studentPay = school.findStudent(sid);

                    if (studentPay == null) {
                        System.out.println("Student not found! ");
                    } else {
                        System.out.print("Enter amount to pay: ");
                        double amount = input.nextDouble();
                        studentPay.payFees(amount);
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid2 = input.nextInt();

                    Student studentCheck = school.findStudent(sid2);

                    if (studentCheck == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("Balance: " + studentCheck.getBalance());
                    }
                    break;

                case 4:
                    school.viewAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again");
            }
        }
    }
}