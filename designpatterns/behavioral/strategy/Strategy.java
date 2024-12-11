package designpatterns.behavioral.strategy;

// Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class,
// and make their objects interchangeable.

// The Strategy Pattern is a behavioral design pattern that allows a class's behavior to be selected at runtime.
// It defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// This promotes the Open/Closed Principle by enabling new algorithms to be added without modifying the existing code.

// Advantages of the Strategy Pattern
//  1. Open/Closed Principle:
//      You can add new strategies without changing existing code.
//
//  2. Avoids Conditional Logic:
//      Replaces long if-else or switch statements with strategy objects.
//
//  3. Flexibility:
//      Strategies can be swapped at runtime, providing dynamic behavior.


//Code without Strategy pattern:

// public class PaymentService {
//    public void pay(String paymentMethod, int amount) {
//        if (paymentMethod.equalsIgnoreCase("CreditCard")) {
//            // Credit card payment logic
//            System.out.println("Paid " + amount + " using Credit Card.");
//        } else if (paymentMethod.equalsIgnoreCase("PayPal")) {
//            // PayPal payment logic
//            System.out.println("Paid " + amount + " using PayPal.");
//        } else {
//            System.out.println("Invalid payment method.");
//        }
//    }
// }

// 1. Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// 2. Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}


// 3. Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Constructor injection
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}

// In the above class, we could have defined a paymentConte

// Usage
public class Strategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("1234-5678-9101-1121", "John Doe"));
        context.pay(1000); // Paid 1000 using Credit Card.

        // Switching to another strategy
        context.setPaymentStrategy(new PayPalPayment("john@example.com"));
        context.pay(500); // Paid 500 using PayPal.
    }
}
