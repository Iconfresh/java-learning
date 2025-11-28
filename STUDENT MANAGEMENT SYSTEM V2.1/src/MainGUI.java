import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI {
    private  JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private School school;
    private StorageManager storage;

    public MainGUI(School school, StorageManager storage) {
        this.school = school;
        this.storage =storage;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Student Management GUI (Basic)");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[] {"ID", "Name", "Dept", "GPA"}, 0);
        table = new JTable(model);
        refreshTable();

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> addStudentDialog());

        JPanel top = new JPanel();
        top.add(btnRefresh);
        JButton btnAdd = new JButton("Add Student");
        btnAdd.addActionListener(e -> addStudentDialog());
        top.add(btnAdd);

        frame.add(top, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void refreshTable() {
        // Clear
        model.setRowCount(0);
        ArrayList<Student> students = school.getAllStudents();
        for (Student s : students) {
            model.addRow(new Object[] {s.getId(), s.getName(), s.getDepartment(), String.format("%.2f", s.calculateGPA())});

        }
    }

    private void addStudentDialog() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField deptField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Name:", nameField,
                "Age:", ageField,
                "Dept:", deptField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String dept = deptField.getText();
                Student s = new Student(id, name, age, dept);
                school.addStudent(s);
                storage.save(school);
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number input.");
            }
        }
    }



    // Launch utility so MainCLI can call it
    public static void LaunchGUI(School school, StorageManager storage) {
        new MainGUI(school, storage);
    }
}
