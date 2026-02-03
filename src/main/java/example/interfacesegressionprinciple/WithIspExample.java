package example.interfacesegressionprinciple;

public class WithIspExample {
    public static void main(String[] args) {
        ChefDuties chefDuties = new Chefs();
        chefDuties.cook();

        WaiterDuties waiterDuties = new Waiters();
        waiterDuties.serve();

        DishwasherDuties dishwasher = new Dishwashers();
        dishwasher.washDishes();

    }
}

interface ChefDuties {
    void cook();
}

class Chefs implements ChefDuties {
    public void cook() {
        System.out.println("Cooking delicious food...");
    }
}

interface DishwasherDuties {
    void washDishes();
}

class Dishwashers implements DishwasherDuties {
    public void washDishes() {
        System.out.println("Washing dishes...");
    }
}

interface WaiterDuties {
    void serve();
}

class Waiters implements WaiterDuties {
    public void serve() {
        System.out.println("Serving food to the customer...");
    }
}