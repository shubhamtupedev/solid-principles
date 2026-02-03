package example.dependencyinversionprinciple;

public class WithoutDiExample {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.get(61);
    }
}

class UserService {
    SQLRepository sqlRepository = new SQLRepository();

    public void get(int id) {
        sqlRepository.get(id);
    }
}

class SQLRepository {
    public void get(int id) {
        System.out.println("User is fetched from SQL DB");
    }
}

class MongoRepository {
    public void find(int id) {
        System.out.println("User is fetched from Mongo DB");
    }
}
