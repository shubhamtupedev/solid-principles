package example.interfacesegressionprinciple;

public class WithoutIspExample {
    public static void main(String[] args) {
        RestaurantWorker waiter = new Waiter();
        waiter.cook(); // wrong
    }
}

interface RestaurantWorker {
    void cook();

    void serve();

    void washDishes();
}

class Chef implements RestaurantWorker {
    public void cook() {
        System.out.println("Cooking food...");
    }

    public void serve() {
        // ❌ Not a chef’s job!
        throw new UnsupportedOperationException("Chef doesn't serve food.");
    }

    public void washDishes() {
        // ❌ Not a chef’s job!
        throw new UnsupportedOperationException("Chef doesn't wash dishes.");
    }
}

class DishWasher implements RestaurantWorker {

    @Override
    public void cook() {
        // ❌ Not the dishwasher’s job
        throw new UnsupportedOperationException("Dishwasher doesn't cook food.");
    }

    @Override
    public void serve() {
        // ❌ Not the dishwasher’s job
        throw new UnsupportedOperationException("Dishwasher doesn't serve food.");
    }

    @Override
    public void washDishes() {
        System.out.println("Dishwasher is cleaning all the dirty dishes...");
    }
}

class Waiter implements RestaurantWorker {

    @Override
    public void cook() {
        // ❌ Not the waiter’s job
        throw new UnsupportedOperationException("Waiter doesn't cook food.");
    }

    @Override
    public void serve() {
        System.out.println("Waiter is serving food to customers...");
    }

    @Override
    public void washDishes() {
        // ❌ Not the waiter’s job
        throw new UnsupportedOperationException("Waiter doesn't wash dishes.");
    }
}
