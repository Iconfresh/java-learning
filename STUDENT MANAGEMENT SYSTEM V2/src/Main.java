import  java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. Enter Score for student Course");
            System.out.println("4. Calculate Student GPA");
            System.out.println("5. View Student Details");
            System.out.println("6. View All Students");
            System.out.println("7. Remove Student");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Age: ");
                    int age = input.nextInt();
                    input.nextInt();

                    System.out.print("Enter Department: ");
                    String dept = input.nextLine();

                    school.addStudent(new Student(id, name, age, dept));
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = input.nextInt();
                    input.nextInt();

                    Student student = school.findStudent(sid);

                    if (student == null) {
                        System.out.println("Student not found! ");
                    } else {
                        System.out.print("Enter Course Name: ");
                        String cname = input.nextLine();

                        System.out.print("Enter Course Code: ");
                        String ccode = input.nextLine();

                        student.addCourse(new Course(cname, ccode));
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid2 = input.nextInt();
                    input.nextInt();

                    Student stu = school.findStudent(sid2);

                    if (stu == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.print("Enter Course Code: ");
                        String cc = input.nextLine();

                        Course course = stu.findCourse(cc);

                        if (course == null) {
                            System.out.println("Course not found! ");
                        } else {
                            System.out.print("Enter Score: ");
                            double score = input.nextDouble();
                            course.setScore(score);
                            System.out.println("Score updated. ");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int sid3 = input.nextInt();

                    Student st = school.findStudent(sid3);

                    if (st == null) {
                        System.out.println("Student not found!");
                    } else  {
                        System.out.println("GPA: " + st.calculateGPA());
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int sid4 = input.nextInt();

                    Student st2 = school.findStudent(sid4);

                    if (st2 == null) {
                        System.out.println("Student not found!");
                    } else {
                        st2.showInfo();
                    }
                    break;

                case 6:
                    school.viewAll();
                    break;
                case 7:
                    System.out.print("Enter Student ID to remove: ");
                    int sid5 = input.nextInt();
                    school.removeStudent(sid5);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}