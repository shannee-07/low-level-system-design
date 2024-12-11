package designprinciples.solid;

// Open/Closed Principle Example
// The Open/Closed Principle states that a class should be open for extension but closed for modification.
// This means you should be able to add new functionality to existing classes without changing their code.
// Example: A notification system that sends messages via different channels.

// Step 1: Create an abstract class or interface for extensibility
interface Notification {
    void send(String message);
}

// Step 2: Create concrete classes that implement the interface
// These classes can be extended to add new notification channels
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Step 3: Create a new notification channel without modifying existing ones
// Example: Add a new notification channel for Push Notifications
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// Step 4: Use the Notification interface in the application logic
// This demonstrates the Open/Closed Principle
class NotificationService {
    private final Notification notification;

    // Dependency Injection: Pass the specific notification type at runtime
    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void notify(String message) {
        notification.send(message);
    }
}

// Main class to demonstrate the Open/Closed Principle in action
public class OpenClosed {

    public static void main(String[] args) {
        // Use Email Notification
        Notification emailNotification = new EmailNotification();
        NotificationService emailService = new NotificationService(emailNotification);
        emailService.notify("Your order has been shipped!");

        // Use SMS Notification
        Notification smsNotification = new SMSNotification();
        NotificationService smsService = new NotificationService(smsNotification);
        smsService.notify("Your OTP is 123456.");

        // Use Push Notification
        Notification pushNotification = new PushNotification();
        NotificationService pushService = new NotificationService(pushNotification);
        pushService.notify("You have a new friend request!");

        // Notice how we added PushNotification without modifying existing classes like EmailNotification or SMSNotification.
        // This adheres to the Open/Closed Principle.
    }
}

/*
Key Points:
1. The Notification interface makes the system open for extension. New notification types can be added easily.
2. Existing classes like EmailNotification and SMSNotification remain unchanged, making the system closed for modification.
3. Adding new functionality does not require altering existing, tested, and stable code, reducing the risk of introducing bugs.
4. The Open/Closed Principle encourages dependency injection and polymorphism.
*/
