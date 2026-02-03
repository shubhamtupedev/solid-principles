package example.openclosedprinciple;

public class WithoutOcpPrinciple {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.pay(PaymentType.PAYTM);
    }
}

class Payment {
    public void pay(PaymentType paymentType) {
        if (paymentType == PaymentType.PAYPAL) {
            System.out.println("Paying through paypal");
        } else if (paymentType == PaymentType.GOOGLEPAY) {
            System.out.println("Paying through google pay");
        } else if (paymentType == PaymentType.PAYTM) {
            System.out.println("Paying through paytm");
        }
    }
}

enum PaymentType {
    PAYPAL, PAYTM, GOOGLEPAY, STRIPE;
}
