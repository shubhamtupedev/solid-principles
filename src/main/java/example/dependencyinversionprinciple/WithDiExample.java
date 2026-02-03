package example.dependencyinversionprinciple;

public class WithDiExample {
    public static void main(String[] args) {
        String id = "xyz";
        UserServices userService = new UserServices(new SQLRepositorys());

        // fetched from MySQL DB
        userService.get(id);

        // point the userService to MongoDB (no need to change service code)
        userService.setRepository(new MongoRepositorys());

        // fetched from MongoDB
        userService.get(id);
    }
}

class UserServices {
    // decoupled the repository from the service layer
    IRepository repository;

    public UserServices(IRepository repository) {
        this.repository = repository;
    }

    public void get(String id) {
        // no need to change to repository.find() for MongoRepository
        repository.get(id);
    }

    public void setRepository(IRepository repository) {
        this.repository = repository;
    }
}

interface IRepository {
    void get(String id);
}

class SQLRepositorys implements IRepository {

    @Override
    public void get(String id) {
        System.out.println("User is fetched from SQL DB");
    }
}

class MongoRepositorys implements IRepository {

    @Override
    public void get(String id) {
        System.out.println("User is fetched from Mongo DB");
    }
}

class FakeRepository implements IRepository {

    @Override
    public void get(String id) {
        System.out.println("User is fetched from Fake DB");
    }
}


