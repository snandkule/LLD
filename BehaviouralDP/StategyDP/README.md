# Strategy Design Pattern

The **Strategy** design pattern is a behavioral design pattern that enables selecting an algorithm's implementation at runtime. It defines a family of algorithms, encapsulates each algorithm in a separate class, and makes them interchangeable. This allows the client to choose an algorithm from a family of algorithms without altering the code that uses the algorithms.

## Key Components

1. **Strategy Interface**: Defines a common interface for all supported algorithms or strategies. It declares a method that all concrete strategies must implement.

2. **Concrete Strategies**: Specific implementations of the Strategy interface. Each class provides a different algorithm or behavior.

3. **Context**: Maintains a reference to a Strategy object and uses it to execute the algorithm. The Context can switch strategies dynamically at runtime.

## Benefits

- **Flexibility**: Allows changing algorithms or behaviors at runtime without modifying the client code.
- **Encapsulation**: Encapsulates the algorithm implementation, keeping it separate from the client code.
- **Open/Closed Principle**: New strategies can be added without changing existing code, adhering to the open/closed principle.

## Example: Payment Processing System

Imagine a payment processing system for an online shopping cart. We want to allow users to pay using different methods, such as credit cards, PayPal, or bank transfers. We’ll use the Strategy pattern to encapsulate each payment method as a separate strategy.

### UML Diagram
```plaintext
+------------------+      +------------------------+
| PaymentStrategy  |<-----| ConcreteStrategies     |
+------------------+      +------------------------+
| + pay(amount: int)|      | + pay(amount: int)     |
+------------------+      +------------------------+
         ^                  | + CreditCardStrategy   |
         |                  | + PaypalStrategy       |
         |                  | + BankTransferStrategy |
         |                  +------------------------+
         |
+------------------+ 
| ShoppingCart     | 
+------------------+
| - items: List<Item> |
| + addItem(item: Item) |
| + removeItem(item: Item) |
| + calculateTotal(): int |
| + pay(strategy: PaymentStrategy) |
+------------------+
         |
+------------------+
| Item             |
+------------------+
| - name: String   |
| - price: int     |
| + getName(): String |
| + getPrice(): int  |
+------------------+

```
### 1. Strategy Interface

Define a common interface for all payment strategies:

```java
interface PaymentStrategy {
    void pay(int amount);
}
```
### 2. Concrete Strategies
Implement various payment strategies:

```java
// Payment via Credit Card
class CreditCardStrategy implements PaymentStrategy {
private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Credit Card.");
    }
}

// Payment via PayPal
class PaypalStrategy implements PaymentStrategy {
private String emailId;

    public PaypalStrategy(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

// Payment via Bank Transfer
class BankTransferStrategy implements PaymentStrategy {
private String accountNumber;

    public BankTransferStrategy(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Bank Transfer.");
    }
}
```
### 3. Context
Create a class that uses the strategy for payment processing:
```java
import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

class Item {
private String name;
private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
```
### 4. Client Code
Use the ShoppingCart with different payment strategies:

```java
public class StrategyPatternDemo {
public static void main(String[] args) {
ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Laptop", 1000);
        Item item2 = new Item("Mouse", 50);

        cart.addItem(item1);
        cart.addItem(item2);

        // Pay using Credit Card
        PaymentStrategy creditCard = new CreditCardStrategy("1234567890123456");
        cart.pay(creditCard);

        // Pay using PayPal
        PaymentStrategy paypal = new PaypalStrategy("myemail@example.com");
        cart.pay(paypal);

        // Pay using Bank Transfer
        PaymentStrategy bankTransfer = new BankTransferStrategy("987654321");
        cart.pay(bankTransfer);
    }
}
```
## Explanation

- **Strategy Interface (`PaymentStrategy`)**: This interface declares the `pay()` method that all concrete strategies must implement.

- **Concrete Strategies (`CreditCardStrategy`, `PaypalStrategy`, `BankTransferStrategy`)**: Each class provides a specific implementation of the `pay()` method, representing different payment methods.

- **Context (`ShoppingCart`)**: This class uses the `PaymentStrategy` to handle payments. It maintains a list of items and calculates the total amount. The `pay()` method delegates the payment process to the strategy object.

- **Client Code**: The `StrategyPatternDemo` class demonstrates how to use different payment methods with the `ShoppingCart`. The `pay()` method of `ShoppingCart` accepts a `PaymentStrategy` object, allowing the payment method to be changed at runtime.

## Summary

The Strategy pattern is effective in scenarios where multiple algorithms or behaviors are needed, and the choice of algorithm needs to be made at runtime. By encapsulating each algorithm in a separate class and using a common interface, the Strategy pattern promotes flexibility, maintainability, and adherence to the open/closed principle. It allows clients to select and switch strategies easily, making the system adaptable to changes and new requirements.
