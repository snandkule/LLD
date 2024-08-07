### Interpreter Design Pattern

The Interpreter design pattern is used to define a grammatical representation for a language and provides an interpreter to interpret sentences in that language. This pattern is particularly useful for simple grammars or when interpreting expressions, such as in scripting languages, mathematical expressions, or configuration files.

#### Key Concepts

1. **Abstract Expression**: An interface or abstract class that defines the `interpret` method.
2. **Terminal Expression**: Implements the `interpret` method for terminal symbols in the grammar.
3. **Non-Terminal Expression**: Implements the `interpret` method for non-terminal symbols, which may involve recursively calling the `interpret` method on its sub-expressions.
4. **Context**: Contains information that is global to the interpreter, such as input data or variables.

### Example: Simple Mathematical Expression Interpreter

Let's create a simple interpreter for evaluating mathematical expressions like "3 + 5" and "10 - 2".

#### UML Diagram
```plaintext
+------------------+
|    <<interface>> |
|    Expression    |
+------------------+
| + int interpret()|
+------------------+
        ^
        |
        |
+------------------+         +------------------+
|     Number       |         |        Add        |
+------------------+         +------------------+
| - int number     |         | - Expression left|
+------------------+         | - Expression right|
| + Number(int)    |         +------------------+
| + int interpret()|         | + Add(Expression, |
+------------------+         |     Expression)   |
                            | + int interpret() |
                            +------------------+
                                   ^
                                   |
                                   |
                            +------------------+
                            |    Subtract      |
                            +------------------+
                            | - Expression left|
                            | - Expression right|
                            +------------------+
                            | + Subtract(Expression, |
                            |     Expression)  |
                            | + int interpret()|
                            +------------------+

```

1. **Abstract Expression**:

```java
interface Expression {
    int interpret();
}
```

2. **Terminal Expression:** Represents numbers in the expressions.

```java
class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
```

3. **Non-Terminal Expressions:** Represents operations (e.g., addition and subtraction).

```java
class Add implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Add(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

class Subtract implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Subtract(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}
```
4. **Context:** In this simple example, the context is not necessary as we directly create and interpret the expressions.

5. **Client Code:** Demonstrates how to use the interpreter.

```java
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // Example: 3 + 5
        Expression expression1 = new Add(new Number(3), new Number(5));
        System.out.println("3 + 5 = " + expression1.interpret());

        // Example: 10 - 2
        Expression expression2 = new Subtract(new Number(10), new Number(2));
        System.out.println("10 - 2 = " + expression2.interpret());

        // Example: (10 - 2) + (3 + 5)
        Expression expression3 = new Add(expression2, expression1);
        System.out.println("(10 - 2) + (3 + 5) = " + expression3.interpret());
    }
}
```

### Detailed Explanation

- **Expression Interface**: The `Expression` interface declares the `interpret` method which is implemented by all terminal and non-terminal expression classes.

- **Number Class**: This is a terminal expression class that simply returns the number it represents.

- **Add and Subtract Classes**: These are non-terminal expression classes that represent addition and subtraction operations. They take two expressions (left and right) as arguments and perform the respective operations.

- **Client Code**: The client code demonstrates the creation of complex expressions using the terminal and non-terminal expression classes. It shows how to interpret these expressions to get the result.

### Use Cases

The Interpreter pattern is suitable for the following scenarios:

1. **Scripting Languages**: Implementing simple scripting languages.
2. **Parsing Expressions**: Evaluating mathematical expressions, logical expressions, etc.
3. **Configuration Files**: Interpreting configuration files with a specific syntax.

### Pros and Cons

**Pros**:

- Simplifies the implementation of simple grammars.
- Extensible: Easy to extend the grammar by adding new expression classes.

**Cons**:

- Complex grammars can lead to a large number of classes, making the pattern less practical for complex languages.
- Can become hard to maintain if the grammar is complex or frequently changes.

The Interpreter design pattern is a powerful tool for designing systems that need to process and evaluate expressions. It is particularly useful in scenarios where the grammar is simple and relatively stable.
