package interfaces.examples;

public class Example2
{
    public static void main(String[] args)
    {
        Payment.paymentInfo(); // static method
        int num = Payment.MAX_AMOUNT;

        Payment p = new CreditCardPayment();
        p.pay(99.99);
        p.showReceipt(); // default method
    }
}



interface Payment
{
    int MAX_AMOUNT = 10000; // constant
    void pay(double amount);

    // Default method
    default void showReceipt() {
        System.out.println("Receipt: Payment successful.");
    }

    // Static method
    static void paymentInfo() {
        System.out.println("Payments can be done online or offline.");
    }
}

class CreditCardPayment implements Payment
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

