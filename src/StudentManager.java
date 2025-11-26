import java.util.ArrayList;

// Manages multiple students using ArrayList
public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added Successfully.");
    }

    // Remove a student by ID
    public void removeStudent(String id) {
        Student found = searchStudent(id);

        if (found != null) {
            students.remove(found);
            System.out.println("Student removed Successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search for a student by ID
    public Student searchStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                return s;
            }
        }
        return null;

    }

    // Display all Students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        for (Student s : students) {
            s.displayInfo();
        }
    }
}
