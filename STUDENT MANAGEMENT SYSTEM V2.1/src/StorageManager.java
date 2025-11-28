import java.io.*;
import java.util.ArrayList;

/*
* StorageManager handles saving / loading the students list toa file.
* Uses java Serializable (binary). File path is configurable.
* */

public class StorageManager {
    private final String filePath;

    public StorageManager(String filePath) {
        this.filePath = filePath;
    }

    // Save the list to file
    public void save(School school) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            oos.writeObject(school.getAllStudents());
            System.out.println("Data saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    // Load list from file and set into school
    @SuppressWarnings("unchecked")
    public void load(School school) {
        File f = new File(filePath);
        if (!f.exists()) {
            System.out.println("No data file found - starting with empty system");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
            school.setAllStudents(list);
            System.out.println("Data loaded from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load failed: " + e.getMessage());
        }
    }
}
