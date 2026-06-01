interface PaymentProcessor {
    void processPayment(double amount);
}

// ✅ New CreditCard class
class CreditCard {
    private String cardNumber;
    private String cardHolderName;

    public CreditCard(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}

class CreditCardProcessor implements PaymentProcessor {
    private CreditCard creditCard;

    public CreditCardProcessor(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void processPayment(double amount) {
        System.out.println("processing credit card payment " + amount +
                " using card " + creditCard.getCardNumber() +
                " (" + creditCard.getCardHolderName() + ")");
    }
}

class PaypalProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("processing PayPal payment " + amount);
    }
}

class ShoppingCart {
    private PaymentProcessor paymentProcessor;

    public ShoppingCart(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        CreditCard card = new CreditCard("1234-5678-9012", "John Doe");
        PaymentProcessor processor = new CreditCardProcessor(card);

        ShoppingCart cart = new ShoppingCart(processor);
        cart.checkout(100.0);
    }
}