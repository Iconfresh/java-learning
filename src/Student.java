import java.util.HashMap;

// Represent a single student in the system
public class Student {

    // Private: Encapsulation
    private String name;
    private int age;
    private String studentId;
    private String department;

    // Stores subject and their scores
    private  HashMap<String, Double> subjects = new HashMap<>();

    // Constructor
    public Student(String name, int age, String studentId, String department) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.department = department;
    }

    // Add a subject and score
    public void addScore(String subject, double score) {
        subjects.put(subject, score);
        System.out.println("Added: " + subject + " = " + score);
    }

    // Calculate average score
    public double getAverage() {
        if (subjects.isEmpty()) return 0;

        double total = 0;
        for (double score : subjects.values()) {
            total += score;
        }
        return total / subjects.size();
    }

    // Determine grade based on average
    public String getGrade() {
        double avg = getAverage();

        if (avg >= 70) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else if (avg >= 45) return "D";
        else return "F";
    }

    // Display student details
    public void displayInfo() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Subjects and Scores: " + subjects);
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
    }

    // Getter (Encapsulation)
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

}
