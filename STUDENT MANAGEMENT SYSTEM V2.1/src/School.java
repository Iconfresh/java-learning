import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
* School manages the collection of students.
* Provides add/ remove / search / edit / sort functionalities.
* */

public class School {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added Successfuly.");
    }

    public Student findStudent(int id){
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public boolean removeStudent(int id) {
        Student s = findStudent(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student removed.");
        }
        return true;

    }

    public List<Student> searchByName(String name) {
        String lower = name.toLowerCase();
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    // Sorting helpers (return new lists)
    public List<Student> sortByName() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Student> sortByGPADesc() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::calculateGPA).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> sortByDepartment() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getDepartment, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) s.showInfo();
    }

    // For Persistence
    public ArrayList<Student> getAllStudents() { return students;}
    public void setAllStudents(ArrayList<Student> list) {
        this.students = list;
    }
}
