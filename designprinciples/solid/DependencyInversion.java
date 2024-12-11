package designprinciples.solid;

// Dependency Inversion Principle (DIP)
// The Dependency Inversion Principle states that high-level modules should not depend on low-level modules.
// Both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.

// Example: Notification1 System
// Goal: Use DIP to decouple the high-level module (Notification1Service) from low-level modules (Email, SMS).

// Step 1: Define an abstraction (interface) for Notification1
interface Notification1 {
    void send(String message);
}

// Step 2: Create low-level modules implementing the Notification1 interface
class EmailNotification1 implements Notification1 {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification1 implements Notification1 {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Step 3: Create the high-level module (depends on the abstraction, not the details)
class Notification1Service {
    private Notification1 notification1; // Depends on abstraction

    public Notification1Service(Notification1 notification1) {
        this.notification1 = notification1;
    }

    public void notifyUser(String message) {
        notification1.send(message);
    }
}

// Main class to demonstrate Dependency Inversion Principle
public class DependencyInversion {
    public static void main(String[] args) {
        // Using EmailNotification1 (low-level module)
        Notification1 emailNotification1 = new EmailNotification1();
        Notification1Service emailService = new Notification1Service(emailNotification1);
        emailService.notifyUser("Your order has been shipped!");

        // Switching to SMSNotification1 (low-level module)
        Notification1 smsNotification1 = new SMSNotification1();
        Notification1Service smsService = new Notification1Service(smsNotification1);
        smsService.notifyUser("Your OTP is 123456.");
    }
}

/*
Notes:
1. **Without DIP**:
   - The Notification1Service would directly depend on EmailNotification1 and SMSNotification1.
   - If a new notification1 method (e.g., PushNotification1) is added, the high-level module would require changes.

2. **With DIP**:
   - High-level module (Notification1Service) depends on the abstraction (Notification1 interface).
   - Adding a new type of notification1 only requires creating a new class that implements the Notification1 interface.

3. **Advantages**:
   - Promotes loose coupling between high-level and low-level modules.
   - Makes the system flexible and extensible.

4. **Key Concept**: Always program to an interface or abstraction, not to concrete implementations.
*/

