package designprinciples.solid;

/**
 * Liskov Substitution Principle (LSP) - Demonstration in Java
 * <p>
 * Definition:
 * Objects of a superclass should be replaceable with objects of its subclasses
 * without altering the correctness of the program.
 * <p>
 * Subclass should extend the capability of parent class not narrow it down
 * <p>
 * Explanation:
 * A subclass should enhance, not break or replace, the functionality of the parent class.
 * Subtypes must fulfill the contract established by their parent class.
 * <p>
 * Example Scenario:
 * We'll create a base class `Bird` and two subclasses: `FlyingBird` and `Penguin`.
 * Using LSP, we'll ensure that substituting a `FlyingBird` or `Penguin` object
 * for a `Bird` object does not break the program.
 */

// Base class: Bird
class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Method to describe bird movement.
     * Subclasses may override this behavior to provide specific implementations.
     */
    public String move() {
        return getName() + " is moving.";
    }
}

/**
 * Subclass: FlyingBird
 * Represents birds that can fly.
 * Extends Bird and adds flying behavior.
 */
class FlyingBird extends Bird {

    public FlyingBird(String name) {
        super(name);
    }

    /**
     * Overrides move() method to add flying-specific behavior.
     */
    @Override
    public String move() {
        return getName() + " is flying in the sky.";
    }
}

/**
 * Subclass: Penguin
 * Represents birds that cannot fly but can swim.
 * Extends Bird without breaking the contract.
 */
class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    /**
     * Overrides move() method to provide penguin-specific behavior.
     */
    @Override
    public String move() {
        return getName() + " is swimming in the water.";
    }
}

/**
 * Main class to test the Liskov Substitution Principle.
 */
public class LiskovPrinciple {

    public static void main(String[] args) {
        // Create instances of Bird, FlyingBird, and Penguin
        Bird sparrow = new FlyingBird("Sparrow");
        Bird penguin = new Penguin("Penguin");

        // Both objects can be treated as Bird (superclass)
        System.out.println(sparrow.move()); // Sparrow is flying in the sky.
        System.out.println(penguin.move()); // Penguin is swimming in the water.

        /**
         * Explanation:
         * - The program works correctly regardless of whether the `Bird` object
         *   is replaced with a `FlyingBird` or a `Penguin`.
         * - This satisfies the Liskov Substitution Principle.
         */

        /**
         * Violating LSP:
         * If the `move()` method in `FlyingBird` or `Penguin` had introduced
         * functionality that contradicts the expectations of `Bird`, the principle
         * would have been violated.
         * Example: Adding a fly() method to the base Bird class would make no sense
         * for Penguin objects, leading to design issues.
         */
    }
}

