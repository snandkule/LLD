# Adapter (or Wrapper) Pattern

The Adapter (or Wrapper) Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by wrapping one interface with another, making it possible for the existing code to interact with the wrapped object as if it were the expected interface.

## Detailed Explanation

**Intent:**
The Adapter Pattern allows a class to work with methods of another class that it would not normally be compatible with. It essentially “adapts” the interface of one class to another interface that clients expect.

**Components:**
1. **Target:** Defines the domain-specific interface that the client uses.
2. **Adapter:** Implements the Target interface and translates requests from the Target to the Adaptee.
3. **Adaptee:** The existing interface that needs adapting.
4. **Client:** Uses the Target interface.

## UML Diagram

Here’s a textual UML diagram of the Adapter Pattern:

```plaintext
+---------------------+
|       Client        |
+---------------------+
           |
           | uses
           v
+---------------------+              +---------------------+
|       Target        |              |       Adaptee        |
+---------------------+              +---------------------+
| +request(): void    |              | +specificRequest(): void |
+---------------------+              +---------------------+
           ^
           |
           | adapts
+---------------------+
|       Adapter       |
+---------------------+
| -adaptee: Adaptee   |
| +request(): void    |
+---------------------+
```
## Example

Let's illustrate the Adapter Pattern with a practical example.

### Problem Statement

Suppose you have a legacy system that provides data using an interface called `OldService`, and you need to integrate it into a new system that expects data in a format provided by `NewService`.

### OldService Interface

```java
public interface OldService {
    void oldMethod(); // Method that provides data
}
```
### NewService Interface
```java
public interface NewService {
    void newMethod(); // New method that expects data
}
```
### Legacy Service Implementation
```java
public class LegacyService implements OldService {
    @Override
    public void oldMethod() {
        System.out.println("Legacy service data");
    }
}
```
### Adapter Implementation
```java
public class ServiceAdapter implements NewService {
    private OldService oldService;

    public ServiceAdapter(OldService oldService) {
        this.oldService = oldService;
    }

    @Override
    public void newMethod() {
        // Adapt the old method to the new method
        oldService.oldMethod();
    }
}
```
### Client Code
```java
public class Client {
    private NewService newService;

    public Client(NewService newService) {
        this.newService = newService;
    }

    public void useService() {
        newService.newMethod();
    }

    public static void main(String[] args) {
        OldService oldService = new LegacyService();
        NewService adaptedService = new ServiceAdapter(oldService);
        Client client = new Client(adaptedService);
        client.useService();  // Outputs: Legacy service data
    }
}
```
## How It Works

1. **Client** is designed to use the `NewService` interface.
2. The `ServiceAdapter` implements `NewService` and internally uses an instance of `OldService` (which is the legacy system).
3. The `ServiceAdapter` translates calls from `NewService` to the appropriate calls on `OldService` (in this case, mapping `newMethod()` to `oldMethod()`).
4. **Client** interacts with `ServiceAdapter` through the `NewService` interface, allowing it to work seamlessly with the `LegacyService` even though it has a different interface.

In this way, the Adapter Pattern enables a system to work with interfaces that it wasn’t originally designed to be compatible with, promoting flexibility and reusability.
