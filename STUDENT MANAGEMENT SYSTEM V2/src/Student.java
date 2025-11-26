import java.util.ArrayList;

// Student class holds personal info + courses + GPA calculation
public class Student {
    private int id;
    private String name;
    private int age;
    private String department;

    private ArrayList<Course> courses = new ArrayList<>();

    // Constructor
    public Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Add a course tot he student
    public void addCourse(Course course) {
        System.out.println("Course added Successfully.");
    }

    // Find course by code
    public Course findCourse(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }

        return null;
    }

    // Calculate GPA ( A=5, B=4, C=3, D=2, F=0 )
    public double calculateGPA() {
        if (courses.isEmpty()) return 0;

        double totalPoints = 0;

        for (Course c : courses) {
            String g = c.getGrade();

            switch (g) {
                case "A": totalPoints += 5; break;
                case "B": totalPoints += 4; break;
                case "C": totalPoints += 3; break;
                case "D": totalPoints += 2; break;
                default: totalPoints += 0;
            }
        }

        return totalPoints / courses.size();
    }

    // Display full student info
    public void showInfo() {
        System.out.println("\n======== Student Details ========");
        System.out.println("ID: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Number of Courses: " + courses.size());

        System.out.println("-------- Courses --------");
        for (Course c : courses) {
            c.showCourse();
        }

        System.out.println("GPA: " + calculateGPA());
        System.out.println("===================================");
    }

    //Getters
    public int getId() { return id;}
}
