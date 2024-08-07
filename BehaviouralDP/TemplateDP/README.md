# Template Method Design Pattern

The Template Method design pattern is a behavioral design pattern that defines the skeleton of an algorithm in a base class, but lets subclasses override specific steps of the algorithm without changing its structure. This pattern allows you to define a sequence of steps for an algorithm, while letting subclasses provide the specific implementations for some of the steps.

## Key Components

1. **Abstract Class (Template)**:
    - Defines the template method which contains the steps of the algorithm.
    - Provides default implementations for some steps of the algorithm.
    - Defines abstract methods that must be implemented by subclasses.

2. **Concrete Class (Subclass)**:
    - Implements the abstract methods defined in the base class.
    - Provides specific implementations for some or all of the steps in the template method.

## Structure

1. **Abstract Class with Template Method**:
    - Contains the template method which defines the steps of the algorithm.
    - May contain default implementations for some steps.
    - Defines abstract methods that must be implemented by subclasses.

2. **Concrete Class**:
    - Implements the abstract methods defined in the base class.
    - Provides specific implementations for some or all of the steps in the template method.

## Benefits

- **Code Reuse**: Common code is implemented in the base class, reducing redundancy.
- **Control**: The base class controls the algorithm's structure while allowing flexibility in specific steps.
- **Consistency**: Ensures that the algorithm follows a consistent sequence of steps across different subclasses.

## Example: Coffee and Tea Preparation

Consider a scenario where we have a base class for making beverages like coffee and tea. The preparation process for these beverages involves similar steps but with specific details for each type of beverage.

### UML Diagram
```plaintext
+------------------+
|   <<abstract>>   |
|    Beverage      |
+------------------+
| - boilWater()    |
| - pourInCup()    |
| + prepareRecipe()|
| + brew() : void  |
| + addCondiments()|<------------------------
+------------------+                        |
| + boilWater() : void   |                  |
| + pourInCup() : void   |                  |
| + prepareRecipe() : void |                |
| - brew() : void        |                  |
| - addCondiments() : void|                 |
+------------------+                        |
         ^                                  |   
         |                                  |
   +-----------------+              +-----------------+ 
   |      Tea        |              |    Coffee       |
   +-----------------+              +-----------------+
   | + brew() : void |              | + brew() : void |
   | + addCondiments() : void |     | + addCondiments() : void |
   +-----------------+              +-----------------+

```

```java
abstract class Beverage {
    // Template method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Default implementation
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void brew();

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    protected abstract void addCondiments();
}

class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareRecipe();
        System.out.println();

        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
```
## Explanation of the Example

### Abstract Class `Beverage`

- **Template Method**: `prepareRecipe()` defines the sequence of steps for preparing the beverage. It includes calls to methods like `boilWater()`, `brew()`, `pourInCup()`, and `addCondiments()`.
- **Concrete Methods**: `boilWater()` and `pourInCup()` are concrete methods with default implementations.
- **Abstract Methods**: `brew()` and `addCondiments()` are abstract methods that must be implemented by subclasses.

### Concrete Classes `Tea` and `Coffee`

- **Tea**: Implements `brew()` to steep the tea and `addCondiments()` to add lemon.
- **Coffee**: Implements `brew()` to drip coffee through a filter and `addCondiments()` to add sugar and milk.

### Client Code

- Creates instances of `Tea` and `Coffee` and calls `prepareRecipe()` on each. The `prepareRecipe()` method follows the template defined in the `Beverage` class but uses the specific implementations provided by the subclasses.

## Summary

The Template Method pattern allows you to define the overall structure of an algorithm in a base class while letting subclasses implement specific steps. This pattern promotes code reuse and consistency while allowing flexibility in the implementation of certain parts of the algorithm.
