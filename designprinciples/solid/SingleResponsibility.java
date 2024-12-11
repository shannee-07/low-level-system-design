package designprinciples.solid;

// Single Responsibility Principle (SRP) Example
// A class should have only one reason to change

// Why is SRP Important?
// - Easier to maintain and extend code.
// - Reduces the risk of unintended side effects when changes are made.
// - Simplifies debugging and testing.

// Class to demonstrate SRP
public class SingleResponsibility {

    public static void main(String[] args) {
        // Creating an EmailService instance
        EmailService emailService = new EmailService();

        // Passing EmailService instance to UserManager
        UserManager userManager = new UserManager(emailService);

        // Creating a user and sending a welcome email
        userManager.createUser("John Doe", "john.doe@example.com");
    }
}

// UserManager class: Responsible only for user management
class UserManager {
    private EmailService emailService; // Dependency on EmailService

    // Constructor to inject EmailService
    public UserManager(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Creates a user and sends a welcome email.
     * @param name  the name of the user
     * @param email the email of the user
     */
    public void createUser(String name, String email) {
        // Logic to create a user (simulated with a print statement)
        System.out.println("User created: " + name);

        // Sending a welcome email using EmailService
        emailService.sendEmail(email, "Welcome " + name + "!");
    }
}

// EmailService class: Responsible only for sending emails
class EmailService {

    /**
     * Sends an email to the specified recipient.
     * @param email   the recipient's email address
     * @param message the email message
     */
    public void sendEmail(String email, String message) {
        // Logic to send an email (simulated with a print statement)
        System.out.println("Email sent to: " + email + " with message: " + message);
    }
}

/* Notes:
   - The UserManager class is now focused only on user-related operations.
   - The EmailService class is responsible for email-related operations.
   - This separation of responsibilities makes the code easier to maintain, extend, and test.
   - If the email-sending logic changes (e.g., switching to a new email provider), we only update the EmailService class.
*/

