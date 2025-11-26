import java.util.ArrayList;

//School class manages all students and payments

public class School {
    private ArrayList<Student> students = new ArrayList<>();

    // Add new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student aded Successfully!");
    }
    
    // Find student by ID
    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null; // Not found
    }

    // Display all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }

        for (Student s : students){
            s.showInfo();
        }
    }
}
