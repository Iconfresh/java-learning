import java.util.ArrayList;

// manages all student in the institution
public class School {
    private ArrayList<Student> students = new ArrayList<>();

    // Add new student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added Successfully!");
    }

    // Find student by ID
    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId()  == id) return  s;
        }
        return null;
    }

    //Remove student
    public void removeStudent(int id) {
        Student s = findStudent(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student removed Successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // View all students
    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            s.showInfo();
        }
    }
}
