package example.singleresponsibilityprinciple;

public class WithSrpExample {
    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.registerUser("Shubham Tupe", "Shubham_tupe@outlook.com", "Shubham@123");
    }
}

class Users {
    private String name;
    private String email;
    private String password;

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String hashPassword) {
        this.password = hashPassword;
    }
}

class UserRepository {
    public void save(User user) {
        System.out.println("saving user to database: " + user.getName());
    }
}

class LoggerService {
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        System.out.println("Sending Welcome email to: " + email);
    }
}

class UserService {
    private final UserRepository userRepository = new UserRepository();
    private final EmailService emailService = new EmailService();
    private final LoggerService loggerService = new LoggerService();

    public void registerUser(String name, String email, String password) {
        String hashPassword = Integer.toHexString(password.hashCode());
        User user = new User(name, email, hashPassword);

        userRepository.save(user);

        emailService.sendWelcomeEmail(user.getEmail());

        loggerService.log("transaction completed successfully");
    }
}
