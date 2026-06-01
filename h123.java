public interface PaymentProcessor{
    void processPayment(double amount);
}

public class CreditCardProcessor implements PaymentProcessor{
    public void processPayment(double amount){
        System.out.println("processing credit card payment "+ amount);
    }
}

public class PaypalProcessor implements PaymentProcessor{
    public void processPayment(double amount){
        System.out.println("processing PayPal payment "+ amount);
    }
}

public class ShoppingCart{
    private PaymentProcessor paymentProcessor;

    public ShoppingCart(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount){
        paymentProcessor.processPayment(amount);
    }
}

public class Main{
    public static void main(String [] args){
        PaymentProcessor processor = new PaypalProcessor();
        ShoppingCart cart = new ShoppingCart(processor);
        cart.checkout(100.0);
    }
}

Main.main(null)