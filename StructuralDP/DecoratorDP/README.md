# Decorator Pattern

The Decorator Pattern is a structural design pattern used to dynamically add or augment the functionality of objects without modifying their structure. It is particularly useful when you want to extend the behavior of individual objects in a flexible and reusable way.

## Key Concepts

- **Component**: An interface or abstract class defining the interface for objects that can have responsibilities added to them dynamically.
- **ConcreteComponent**: A class that implements the Component interface. This is the core object to which additional functionalities can be added.
- **Decorator**: An abstract class that implements the Component interface and has a reference to a Component object. It delegates operations to the wrapped component, potentially adding additional behavior.
- **ConcreteDecorator**: A class that extends the Decorator class and adds specific functionality.

## UML Diagram

Here’s a textual representation of the UML diagram for the Decorator Pattern:

```plaintext
  +-----------------+                                                           +-----------------+
|    Coffee       |<------------------------------------------------------------| CoffeeDecorator |
  +-----------------+                                                           +-----------------+
  | + getDescription(): String  |                                               | - decoratedCoffee: Coffee  |
  | + cost(): double            |                                               | + getDescription(): String |<------------------
  +-----------------+                                                           | + cost(): double           |                   |
      ^      ^                                                                  +-----------------+                              |
      |      |----------------                                                              ^                                        |
  +-----------------+        |      +-----------------+                                 |                                        |
| SimpleCoffee    |          -------| FilterCoffee    |                         +-------------------------+        +-------------------------+
  +-----------------+               +-----------------+                         |  MilkDecorator          |        | SugarDecorator          |
  | + getDescription(): String  |   | + getDescription(): String  |             | + getDescription(): String |     | + getDescription(): String |
  | + cost(): double            |   | + cost(): double            |             | + cost(): double           |     | + cost(): double           |
  +-----------------+               +-----------------+                         +-------------------------+        +-------------------------+
                                                                                            ^
                                                                                            |
                                                                                +-------------------------+
                                                                                | ChocolateDecorator      |
                                                                                +-------------------------+
                                                                                | + getDescription(): String |
                                                                                | + cost(): double           |
                                                                                +-------------------------+
```
## Explanation

- **`Coffee`**: This is the interface or abstract class defining the operations `getDescription()` and `cost()`.

- **`SimpleCoffee`**: A concrete implementation of the `Coffee` interface that provides the basic functionality.

- **`CoffeeDecorator`**: An abstract decorator class that implements the `Coffee` interface and contains a reference to a `Coffee` object. It delegates method calls to the wrapped `Coffee` object.

- **`MilkDecorator`**, **`SugarDecorator`**, and **`ChocolateDecorator`**: Concrete decorators that extend `CoffeeDecorator` and add specific functionalities (milk, sugar, chocolate) to the `Coffee` object they wrap.


## Example

Let’s use a coffee shop as an example to illustrate the Decorator Pattern.

### Problem

You want to create a base coffee object and then dynamically add various features like milk, sugar, and chocolate to it without modifying the original coffee class.

### Solution

Here’s how you can apply the Decorator Pattern:

1. **Component Interface**

```java
public interface Coffee {
   String getDescription();
   double cost();
}
```
2. **ConcreteComponent**

```java
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.00;
    }
}
```
3. **Decorator**

```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}
```
4. **ConcreteDecorators**

```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 1.50;
    }
}

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.75;
    }
}

public class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Chocolate";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 2.00;
    }
}
```
5. **Client Code**

```java
public class CoffeeShop {
public static void main(String[] args) {
Coffee coffee = new SimpleCoffee();
System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(milkCoffee.getDescription() + " Cost: $" + milkCoffee.cost());

        Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(sugarMilkCoffee.getDescription() + " Cost: $" + sugarMilkCoffee.cost());

        Coffee deluxeCoffee = new ChocolateDecorator(new SugarDecorator(new MilkDecorator(new SimpleCoffee())));
        System.out.println(deluxeCoffee.getDescription() + " Cost: $" + deluxeCoffee.cost());
    }
}
```
6. **Output**
```bash
Simple Coffee Cost: $5.0
Simple Coffee, Milk Cost: $6.5
Simple Coffee, Milk, Sugar Cost: $7.25
Simple Coffee, Milk, Sugar, Chocolate Cost: $9.25
```
## Summary

In this example:

- **`SimpleCoffee`** is the core object that provides the base functionality.
- **`CoffeeDecorator`** is an abstract decorator class that wraps the `Coffee` object.
- **`MilkDecorator`**, **`SugarDecorator`**, and **`ChocolateDecorator`** add specific functionalities (milk, sugar, chocolate) to the coffee.

The Decorator Pattern allows you to combine various decorators in different ways to achieve different functionalities without altering the core `SimpleCoffee` class. This pattern is flexible and adheres to the Open/Closed Principle, allowing you to extend functionality without changing ex
