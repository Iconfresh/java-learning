import java.util.List;
import java.util.Scanner;

/*
* MainCLI is the upgraded command-line program.
* It loads data, requires admin login, and exposes all operations.
* */

public class MainCLI {
    private static final String DATA_FILE= "students.dat";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        School school = new School();
        StorageManager storage = new StorageManager(DATA_FILE);
        AdminManager admin = new AdminManager();

        // Load data if exits
        storage.load(school);

        System.out.println("Welcome to the Upgraded Student Management System V2.1");

        // Admin login required
        boolean loggedIn = false;
        for (int tries = 0; tries < 3 && !loggedIn; tries++) {
            System.out.print("Admin username: ");
            String user = input.nextLine();
            System.out.print("Admin password: ");
            String pass = input.nextLine();

            if (admin.login(user, pass)) {
                loggedIn = true;
                System.out.println("Login Successful.");
            } else {
                System.out.println("Login failed. Try again.");
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting.");
            return;
        }

        // Main Loop
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. Enter Sore for Student Course");
            System.out.println("4. Calculate Student GPA");
            System.out.println("5. View Student Details");
            System.out.println("6. View All Students");
            System.out.println("7. Remove Student");
            System.out.println("8. Edit Student Info");
            System.out.println("9. Edit Course (name/code/units) or Remove Course");
            System.out.println("10. Search Student by Name");
            System.out.println("11. Sort Students (Name/GPA?Department)");
            System.out.println("12. Save Data");
            System.out.println("13. Change Admin Credentials");
            System.out.println("14. Launch Basic GUI (optional)");
            System.out.println("15. Exit");
            System.out.println("Choose an option: ");


            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Department: ");
                    String dept = input.nextLine();

                    school.addStudent(new Student(id, name, age, dept));
                }

                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = Integer.parseInt(input.nextLine());
                    Student s = school.findStudent(sid);
                    if (s == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter Course Name: ");
                    String cname = input.nextLine();

                    System.out.print("Enter Course Code: ");
                    String ccode = input.nextLine();

                    System.out.print("Enter Credit Units (integer): ");
                    int units = Integer.parseInt(input.nextLine());

                    s.addCourse(new Course(cname, ccode, units));
                }

                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = Integer.parseInt(input.nextLine());
                    Student s = school.findStudent(sid);
                    if (s == null) {
                        System.out.println("Student not found.");
                        break;
                }
                    System.out.print("Enter Course Code: ");
                    String code = input.nextLine();
                    Course c = s.findCourse(code);
                    if (c == null) {
                        System.out.println("Course not found.");
                        break;
                    }
//                    System.out.print("Enter Course Code: ");
//                    String code = input.nextLine();
//                    Course c = s.findCourse(code);
//                    if (c == null) {
//                        System.out.println("Course not found.");
//                        break;
//                    }
                    System.out.print("Enter Score (0-100): ");
                    double score = Double.parseDouble(input.nextLine());
                    c.setScore(score);
                    System.out.println("Score updated. ");

                }
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = Integer.parseInt(input.nextLine());
                    Student s = school.findStudent(sid);
                    if (s == null) System.out.println("Student not found.");
                    else System.out.printf("GPA: %.2f%n", s.calculateGPA());
                }

                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = Integer.parseInt(input.nextLine());
                    Student s = school.findStudent(sid);
                    if (s == null) System.out.println("Student not found.");
                    else s.showInfo();
                }

                case 6 -> school.viewAll();

                case 7 -> {
                    System.out.print("Enter Student ID to remove: ");
                    int sid = Integer.parseInt(input.nextLine());
                    school.removeStudent(sid);
                }

                case 8 -> {
                    System.out.print("Enter Student ID to Edit: ");
                    int sid = Integer.parseInt(input.nextLine());
                    Student s = school.findStudent(sid);
                    if (s == null) {
                        System.out.println("Student not found.");
                        break;
                }
                    System.out.print("Enter new name (or blank to keep): ");
                    String nm = input.nextLine();
                    if (!nm.isBlank()) s.setName(nm);

                    System.out.print("Enter new age (or blank to keep): ");
                    String ageStr = input.nextLine();
                    if (!ageStr.isBlank()) s.setAge(Integer.parseInt(ageStr));

                    System.out.print("Enter new department (or blank to keep): ");
                    String d = input.nextLine();
                    if (!d.isBlank()) s.setDepartment(d);

                    System.out.println("Student updated");
                }

            case 9 -> {
                System.out.print("Enter Student ID: ");
                int sid = Integer.parseInt(input.nextLine());
                Student s = school.findStudent(sid);
                if (s == null) {
                    System.out.println("Student not found. ");
                    break;
                }
                System.out.println("1. Edit Course Name/Code/Units");
                System.out.println("2. Remove Course");
                System.out.println("Choose: ");
                int sub = Integer.parseInt(input.nextLine());
                if (sub == 1){
                    System.out.print("Enter Course Code: ");
                    String code = input.nextLine();
                    Course c = s.findCourse(code);
                    if (c == null) {
                        System.out.println("Course not found");
                        break;
                    }
                    System.out.print("Enter new name (or blank): ");
                    String newName = input.nextLine();
                    if (!newName.isBlank()) c.setCourseName(newName);
                    System.out.print("Enter new units (or blank): ");
                    String unitsStr = input.nextLine();
                    if (!unitsStr.isBlank()) c.setCreditUnits(Integer.parseInt(unitsStr));
                    System.out.println("Course updated.v");
                } else if (sub == 2) {
                    System.out.print("Enter Course code to remove: ");
                    String code = input.nextLine();
                    s.removeCourse(code);
                } else System.out.println("Invalid choice.");
                }

                case 10 -> {
                    System.out.print("Enter name to search: ");
                    String q = input.nextLine();
                    List<Student> results = school.searchByName(q);
                    if (results.isEmpty()) System.out.println("No matches.");
                    else results.forEach(Student::showInfo);
                }

                case 11 -> {
                    System.out.println("Sort by: 1) Name 2) GPA (desc) 3) Department" );
                    int sopt = Integer.parseInt(input.nextLine());
                    List<Student> sorted;
                    if (sopt == 1) sorted = school.sortByName();
                    else if (sopt == 2) sorted = school.sortByGPADesc();
                    else sorted = school.sortByDepartment();
                    sorted.forEach(Student::showInfo);
                }

                case 12 -> storage.save(school);

                case 13 -> {
                    System.out.print("Enter new admin username: ");
                    String nu = input.nextLine();
                    System.out.print("Enter new admin password: ");
                    String np = input.nextLine();
                    admin.changeCredentials(nu, np);
                }

                case 14 -> {
                    // Launch the basic Swing GUI (Uses same school + storage)
                    javax.swing.SwingUtilities.invokeLater(() -> {
                      MainGUI.LaunchGUI(school, storage);
                    });
                }

                case 15 -> {
                    System.out.println("Saving data and exiting...");
                    storage.save(school);
                    return;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }
}