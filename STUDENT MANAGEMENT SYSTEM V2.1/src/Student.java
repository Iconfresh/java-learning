import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

/*
* Student holds personal info + list of courses.
* Implements weighted GPA calculation using credit units.
* */

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private String department;

    private ArrayList<Course> courses = new ArrayList<>();

    public Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Add course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added Successfully.");
    }

    // Remove course by code
    public boolean removeCourse(String code) {
        Optional<Course> oc = courses.stream()
                .filter(c -> c.getCourseCode().equalsIgnoreCase(code))
                .findFirst();
        if (oc.isPresent()) {
            courses.remove(oc.get());
            System.out.println("Course not found.");

        }
        return false;
    }

    // Find course by code
    public Course findCourse(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }

    //Weighted GPA: sum(gradePoint * creditUnits) / sum(creditUnits)
    public double calculateGPA() {
        if (courses.isEmpty()) return 0.0;

        double totalPoints = 0.0;
        int totalUnits = 0;
        for (Course c : courses) {
            if (c.getScore() < 0) continue; // skip courses without score
            totalPoints += c.getGradePoint() * c.getCreditUnits();
            totalUnits += c.getCreditUnits();
        }
        if (totalUnits == 0) return 0.0;
        return totalPoints / totalUnits;
    }

    // Display info
    public void showInfo() {
        System.out.println("\n========Student ========");
        System.out.printf("ID: %d | Name: %s | Age: %d | Dept: %s%n", id, name, age, department);
        System.out.println("Course:");
        if (courses.isEmpty()) {
            System.out.println(" No courses added yet.");
        } else {
            for (Course c : courses) c.showCourse();
        }
        System.out.println("GPA: %.2f%n" + calculateGPA());
        System.out.println("============================");
    }

    // Editing methods
    public void setName(String name) { this.name = name;}
    public void setAge(int age) { this.age = age;}
    public void setDepartment(String dept) { this.department = dept;}

    // Getters
    public int getId() { return id;}
    public String getName() { return name;}
    public int getAge() { return age;}
    public String getDepartment() { return department;}
    public ArrayList<Course> getCourses() { return courses;}
}
