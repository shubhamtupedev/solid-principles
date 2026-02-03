package example.singleresponsibilityprinciple;

public class WithoutSrpExample {
    public static void main(String[] args) {

        User u = new User("Shubham Tupe", "shubham_tupe@outlook.com", "Shubham@123");
        u.saveToDatabase();
        u.sendWelcomeEmail();
        u.log("save transaction successfully completed");

    }
}

class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private String hasPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }

    public User saveToDatabase() {
        this.password = hasPassword(password);
        System.out.println("saving user to database :" + this.name);
        return this;
    }

    public void sendWelcomeEmail() {
        System.out.println("Sending welcome email to: " + this.email);
    }

    public void log(String msg) {
        System.out.println("LOG: " + msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
