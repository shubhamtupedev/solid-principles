package example.openclosedprinciple;

public class WithOcpExample {
    public static void main(String[] args) {
        Payments payments = new Payments(new PaypalPayment());
        payments.pay();
    }
}

interface PaymentMethod {
    void pay();
}

class PaypalPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying through paypal");
    }
}

class GooglePayPayment implements PaymentMethod {

    @Override
    public void pay() {
        System.out.println("Paying through google pay");
    }
}

class Payments {
    private final PaymentMethod paymentMethod;

    public Payments(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay() {
        paymentMethod.pay();
    }
}
