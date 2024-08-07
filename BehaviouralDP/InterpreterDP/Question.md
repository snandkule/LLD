# Implementing the Interpreter Design Pattern

You are tasked with creating a simple arithmetic expression interpreter that can evaluate expressions with addition, subtraction, multiplication, and division. Implement the Interpreter design pattern to provide a flexible solution for parsing and evaluating arithmetic expressions.

## Requirements

### Expression Interface
- Create an `Expression` interface with a method `int interpret()`.

### Terminal Expressions
- Implement classes for terminal expressions that represent numbers:
    - `NumberExpression`: Represents a number in the expression.

### Non-Terminal Expressions
- Implement classes for non-terminal expressions that represent operations:
    - `AdditionExpression`: Represents an addition operation.
    - `SubtractionExpression`: Represents a subtraction operation.
    - `MultiplicationExpression`: Represents a multiplication operation.
    - `DivisionExpression`: Represents a division operation.

### Context Class
- Create a `Context` class that provides the necessary input and environment for interpreting expressions. *(Optional)*

### Interpreter Class
- Create an `Interpreter` class to parse and interpret the expression string into a tree of expressions. *(Optional)*

### Testing
- Create a test class `InterpreterTest` that demonstrates the use of the interpreter to evaluate various arithmetic expressions.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        // Create context and expression
        Expression expression = new AdditionExpression(
                                    new NumberExpression(5),
                                    new MultiplicationExpression(
                                        new NumberExpression(10),
                                        new SubtractionExpression(
                                            new NumberExpression(20),
                                            new NumberExpression(5)
                                        )
                                    )
                                );

        // Interpret and evaluate the expression
        int result = expression.interpret();
        System.out.println("Result: " + result);
    }
}
```

## Hints

- **Define the Expression Interface**:
    - Create an `Expression` interface with a method `int interpret()`. This method will be used to evaluate the expression.

- **Implement Terminal and Non-Terminal Expression Classes**:
    - **Terminal Expressions**: Implement classes that represent the basic units of the expression, such as `NumberExpression`, which handles individual numbers.
    - **Non-Terminal Expressions**: Implement classes for operations, such as:
        - `AdditionExpression`: Represents an addition operation.
        - `SubtractionExpression`: Represents a subtraction operation.
        - `MultiplicationExpression`: Represents a multiplication operation.
        - `DivisionExpression`: Represents a division operation.
    - These classes should extend the `Expression` interface and use composition to build complex expressions.

- **Use the Context Class to Manage Input or State (Optional)**:
    - Create a `Context` class if your expressions need to manage or pass additional information or state. This is optional and depends on whether you need a shared environment for interpreting expressions.

- **Implement the Interpreter Class (Optional)**:
    - If you need to parse expression strings or build an expression tree programmatically, implement an `Interpreter` class. This class will convert raw expressions into the structured expression objects.

- **Use the Test Class to Demonstrate Evaluation**:
    - Create a test class, `InterpreterTest`, to demonstrate how the interpreter processes and evaluates different arithmetic expressions. Ensure that it validates the correct interpretation and output for various test cases.
