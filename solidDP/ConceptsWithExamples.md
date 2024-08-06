# SOLID Principles

The SOLID principles are a set of five design principles in object-oriented programming and design intended to make software designs more understandable, flexible, and maintainable. By adhering to these principles, software design becomes more modular, easier to understand, and more adaptable to change.

## Summary
- **SRP:** One class, one responsibility.
- **OCP:** Extendable without modifying.
- **LSP:** Subtypes must be substitutable for their base types.
- **ISP:** Prefer smaller, specific interfaces.
- **DIP:** Depend on abstractions, not on concrete implementations.

## 1. Single Responsibility Principle (SRP)
**Definition:** A class should have only one reason to change, meaning it should have only one job or responsibility.

**Explanation:** This principle helps in keeping classes focused and manageable. By ensuring that a class only has one responsibility, changes to one part of the system (e.g., business logic) do not affect other unrelated parts (e.g., UI).

**Example:**

**Before SRP:**

```java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

    // Method to send an email
    public void sendEmail(String message) {
        // Code to send email
        System.out.println("Sending email: " + message);
    }
}
```
**After SRP:**

```java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
}

public class EmailService {
    public void sendEmail(String email, String message) {
        // Code to send email
        System.out.println("Sending email to " + email + ": " + message);
    }
}
```

## 2. Open/Closed Principle (OCP)

**Definition:** Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

**Explanation:** This means that the behavior of a module can be extended without modifying its source code. This is often achieved using polymorphism, where you can add new functionalities by creating new subclasses.

**Example:**

**Before OCP:**

```java
public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

public class AreaCalculator {
    public int calculateArea(Rectangle rectangle) {
        return rectangle.calculateArea();
    }
}
```
**After OCP:**

```java
public interface Shape {
    int calculateArea();
}

public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }
}

public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }
}

public class AreaCalculator {
    public int calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
```

## 3. Liskov Substitution Principle (LSP)

**Definition:** Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

**Explanation:** Subtypes must be substitutable for their base types. This ensures that derived classes extend the base class without changing its behavior, leading to more robust and maintainable code.

**Example:**

**Before LSP:**

```java
public class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly!");
    }
}
```
In this example, the Ostrich class extends the Bird class but does not support the fly method, which violates the Liskov Substitution Principle because an Ostrich cannot be used in place of a Bird where flying is expected.

**After LSP:**
```java
public interface Flyable {
    void fly();
}

public class Sparrow implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Ostrich {
    // Ostrich does not implement Flyable
    public void run() {
        System.out.println("Running...");
    }
}
```
In this example, the Flyable interface is introduced to represent objects that can fly. Sparrow implements Flyable, while Ostrich does not, thus adhering to the Liskov Substitution Principle. This approach ensures that each class behaves as expected without forcing inappropriate behaviors onto subclasses.

## 4. Interface Segregation Principle (ISP)

**Definition:** No client should be forced to depend on methods it does not use.

**Explanation:** This principle advocates for creating specific and fine-grained interfaces rather than a single, broad one. This way, classes that implement the interfaces are not burdened with unnecessary methods.

**Example:**

**Before ISP:**

```java
public interface Worker {
void work();
void eat();
}

public class HumanWorker implements Worker {
@Override
public void work() {
System.out.println("Working...");
}

    @Override
    public void eat() {
        System.out.println("Eating...");
    }
}

public class RobotWorker implements Worker {
@Override
public void work() {
System.out.println("Working...");
}

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robot doesn't eat!");
    }
}
```

**After ISP:**

```java
public interface Workable {
void work();
}

public interface Eatable {
void eat();
}

public class HumanWorker implements Workable, Eatable {
@Override
public void work() {
System.out.println("Working...");
}

    @Override
    public void eat() {
        System.out.println("Eating...");
    }
}

public class RobotWorker implements Workable {
@Override
public void work() {
System.out.println("Working...");
}
}
```

##5. Dependency Inversion Principle (DIP)
  
**Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details. Details should depend on abstractions.

**Explanation:** This principle suggests that code should depend on abstractions (interfaces or abstract classes) rather than concrete implementations. It promotes decoupling and enhances the flexibility and testability of the code.

**Example:**

**Before DIP:**

```java
public class LightBulb {
public void turnOn() {
System.out.println("LightBulb turned on");
}

    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

public class Switch {
private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void operate() {
        bulb.turnOn();
    }
}
```

**After DIP:**

```java
public interface Switchable {
void turnOn();
void turnOff();
}

public class LightBulb implements Switchable {
@Override
public void turnOn() {
System.out.println("LightBulb turned on");
}

    @Override
    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

public class Switch {
private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
```