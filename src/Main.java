import java.util.Scanner;

public class Main {
    private static String name;
    private static String department;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Subject Score");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume newLine

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name");
                    String nam = input.nextLine();

                    System.out.print("Enter age: ");
                    int age = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    Student s = new Student(name, age, id, department);
                    manager.addStudent(s);
                }

                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();
                    ;

                    Student s = manager.searchStudent(id);

                    if (s != null) {
                        System.out.print("Enter subject: ");
                        String subject = input.nextLine();

                        System.out.print("Enter score: ");
                        double score = input.nextDouble();

                        s.addScore(subject, score);
                    } else {
                        System.out.println("Student not found!");
                    }

                }

                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    Student s = manager.searchStudent(id);

                    if (s != null) s.displayInfo();
                    else System.out.println("Student not found");
                }

                case 4 -> {
                    System.out.println("Enter Student ID to remove: ");
                    String id = input.nextLine();
                    manager.removeStudent(id);

                }
                case 5 -> manager.displayAllStudents();

                case 6 -> {
                    System.out.println("Exiting sytem...");
                    return;
                }

                default -> System.out.println("Invalid option!");
            }

        }
    }
}