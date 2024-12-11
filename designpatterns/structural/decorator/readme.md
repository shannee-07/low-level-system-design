The Decorator Design Pattern is a structural design pattern that allows behavior to be added to individual objects dynamically, without affecting the behavior of other objects from the same class. It involves creating a set of decorator classes that are used to wrap concrete components.

# Decorator Pattern Explanation

The **Decorator Pattern** allows you to dynamically add new functionality or modify the behavior of an object without altering its structure. Below is a structured explanation of how to use this pattern:

---

## **Steps to Implement Decorator Pattern**

### 1. Define an Interface (A)
- Create an interface that specifies the functionality all components (base and decorated) should have.
- **Example**: `Coffee` interface with methods like `getDescription()` and `getCost()`.

---

### 2. Create a Basic Implementation (B)
- Implement a basic or default version of the interface.
- **Example**: `PlainCoffee` class implements `Coffee` and provides plain coffee functionality.

---

### 3. Create an Abstract Decorator Class (C)
- This class also implements the interface (A) but serves as a **wrapper** for objects of the same interface.
- It holds a reference to an object implementing the interface and forwards method calls to it.
- **Example**: `CoffeeDecorator` class wraps a `Coffee` object and forwards calls to `getDescription()` and `getCost()`.

---

### 4. Create Concrete Decorators (Extend C)
- Create subclasses of the abstract decorator to add or modify functionality.
- Each concrete decorator represents a single "decoration" or feature to add.
- **Examples**:
    - `MilkDecorator` adds milk functionality.
    - `SugarDecorator` adds sugar functionality.

---

## **How It Works**
1. The interface (A) ensures all components and decorators share the same contract.
2. The basic implementation (B) provides a default starting point.
3. The abstract decorator (C) serves as a flexible wrapper for chaining behaviors.
4. Concrete decorators (subclasses of C) add specific features dynamically.

---

## **Chaining the Decorators**
- Combine multiple decorators dynamically by wrapping them around the base component or other decorators.
- **Example**:
  ```java
  Coffee coffee = new PlainCoffee();
  coffee = new MilkDecorator(coffee);  // Add milk
  coffee = new SugarDecorator(coffee); // Add sugar
