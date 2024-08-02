# Implementing the Strategy Design Pattern with Context Inheritance

You are tasked with creating a payment processing system that supports multiple payment methods (e.g., Credit Card, PayPal, and Bitcoin). Implement the Strategy design pattern to provide a flexible solution for choosing different payment algorithms at runtime. Additionally, the system should support different use cases (e.g., OnlinePayment, InStorePayment) by inheriting the `PaymentContext` class.

## Requirements

### PaymentStrategy Interface
- Create a `PaymentStrategy` interface with a method `pay(double amount)`.

### Concrete Payment Strategies
- Implement at least three classes that implement the `PaymentStrategy` interface:
    - `CreditCardPayment`: Simulates payment processing via credit card.
    - `PayPalPayment`: Simulates payment processing via PayPal.
    - `BitcoinPayment`: Simulates payment processing via Bitcoin.

### PaymentContext Class
- Create a `PaymentContext` class that uses a `PaymentStrategy` to process payments.
- Provide a method `setPaymentStrategy(PaymentStrategy strategy)` to change the payment strategy.
- Provide a method `executePayment(double amount)` to process the payment using the current strategy.

### Inherit PaymentContext
- Create different classes for various use cases by inheriting the `PaymentContext` class:
    - `OnlinePaymentContext`: Specific to online payment processing.
    - `InStorePaymentContext`: Specific to in-store payment processing.
    - `MobilePaymentContext`: Specific to mobile payment processing.
- Each subclass can have additional methods or properties specific to the use case.

### Testing
- Create a test class `StrategyTest` that demonstrates the use of different payment strategies and different payment contexts by changing them at runtime.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        // Online payment context with different strategies
        PaymentContext onlineContext = new OnlinePaymentContext();
        onlineContext.setPaymentStrategy(new CreditCardPayment());
        onlineContext.executePayment(100.0);

        onlineContext.setPaymentStrategy(new PayPalPayment());
        onlineContext.executePayment(200.0);

        // In-store payment context with different strategies
        PaymentContext inStoreContext = new InStorePaymentContext();
        inStoreContext.setPaymentStrategy(new BitcoinPayment());
        inStoreContext.executePayment(300.0);

        inStoreContext.setPaymentStrategy(new CreditCardPayment());
        inStoreContext.executePayment(400.0);

        // Mobile payment context with different strategies
        PaymentContext mobileContext = new MobilePaymentContext();
        mobileContext.setPaymentStrategy(new PayPalPayment());
        mobileContext.executePayment(500.0);
    }
}
