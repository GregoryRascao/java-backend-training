package interfaces.exercises;

/**
 * TODO:
 * Exercise 2:
 * Define an interface Payment with a method pay(double amount).
 * Implement classes: PaypalPayment, BankTransferPayment.
 * Each class should print a custom payment message.
 * Write a Demo that processes both payments.
 */

public class Exercise2 {
    interface Payment{
        void pay(double amount);
    }

    static class PaypalPayment implements Payment{
        @Override 
        public void pay(double amount){
            System.out.println("Paypal paid you " + amount);
        }
    }

    static class BankTransferPayment implements Payment {
        @Override 
        public void pay(double amount){
            System.out.println("The bank give's you " + amount);
        }
       
    }
    public static void main(String[] args) {
        Payment paypal = new PaypalPayment();
        Payment bankTransfert = new BankTransferPayment();

        paypal.pay(10);
        bankTransfert.pay(1000);
    }
}
