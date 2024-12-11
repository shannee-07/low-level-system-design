package designprinciples.solid;

// Interface Segregation Principle (ISP)
// ISP states that a class should not be forced to implement interfaces it does not use.
// Instead of one large interface, it is better to have multiple smaller, specific interfaces.

// Main class to demonstrate Interface Segregation Principle
public class InterfaceSegregation {

    public static void main(String[] args) {

        // Create instances of workers
        Chef chef = new Chef();
        Server server = new Server();

        // Chef can cook
        chef.cook();

        // Server can serve
        server.serve();
    }
}

// PROBLEM WITHOUT ISP
// Imagine a large interface forcing all implementations to include methods irrelevant to their role.
// Example: A "RestaurantWorker" interface might have both cooking and serving responsibilities.

// This violates ISP, as not all workers cook and serve.
interface RestaurantWorker {
    void cook();
    void serve();
}

// Chef implements "RestaurantWorker" but is forced to implement "serve" (which is irrelevant to chefs).
class ChefWithoutISP implements RestaurantWorker {
    public void cook() {
        System.out.println("Chef is cooking food.");
    }

    // Unnecessary implementation
    public void serve() {
        throw new UnsupportedOperationException("Chefs don't serve!");
    }
}

// Server implements "RestaurantWorker" but is forced to implement "cook" (which is irrelevant to servers).
class ServerWithoutISP implements RestaurantWorker {
    public void cook() {
        throw new UnsupportedOperationException("Servers don't cook!");
    }

    public void serve() {
        System.out.println("Server is serving food.");
    }
}

// SOLUTION WITH ISP
// Split the large interface into smaller, more specific interfaces.

// Smaller interface for cooking responsibility
interface CookingWorker {
    void cook();
}

// Smaller interface for serving responsibility
interface ServingWorker {
    void serve();
}

// Chef implements only the CookingWorker interface
class Chef implements CookingWorker {
    public void cook() {
        System.out.println("Chef is cooking food.");
    }
}

// Server implements only the ServingWorker interface
class Server implements ServingWorker {
    public void serve() {
        System.out.println("Server is serving food.");
    }
}
