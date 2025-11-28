/*
* AdminManager provides a simple in-memory admin login.
* You can later store hashed passwords in a file or DB.
* */


public class AdminManager {
    //Default credentials (change as needed)
    private String username = "admin";
    private String password = "password123";

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    //Allowing changing credentials at runtime
    public void changeCredentials(String newUser, String newPass) {
        this.username = newUser;
        this.password = newPass;
        System.out.println("Admin credentials updated.");
    }
}
