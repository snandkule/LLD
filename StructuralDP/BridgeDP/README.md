# Bridge Pattern

The Bridge Pattern is a structural design pattern that separates an abstraction from its implementation so that the two can evolve independently without affecting each other. This separation helps in creating a flexible and maintainable system.

## Components of the Bridge Pattern

1. **Abstraction:** Defines the abstraction's interface and maintains a reference to an object of type Implementor.
2. **Refined Abstraction:** Extends the interface defined by the Abstraction and can add additional functionality.
3. **Implementor:** Defines the interface for the implementation classes. This interface is not necessarily the same as the Abstraction's interface; it is usually more abstract.
4. **Concrete Implementor:** Implements the Implementor interface with specific functionality.

## UML Diagram

Here’s a textual representation of the UML diagram for the Bridge Pattern:

```plaintext
 +-------------------+
 |    Abstraction    |
 +-------------------+
 | -implementor: Implementor
 +-------------------+
 | +operation(): void
 +-------------------+
          |
          | uses
          |
 +-------------------+
 | RefinedAbstraction|
 +-------------------+
 | +operation(): void
 +-------------------+

 +-------------------+
 |    Implementor    |
 +-------------------+
 | +operationImpl(): void
 +-------------------+
          ^
          |
          |
 +-------------------+
 | ConcreteImplementor|
 +-------------------+
 | +operationImpl(): void
 +-------------------+

```

## Detailed Explanation

1. **Abstraction:**
    - This class defines the high-level control logic and maintains a reference to an object of type Implementor.
    - **Example:** `RemoteControl` which might have operations to turn on or off a device.

2. **Refined Abstraction:**
    - This class extends the Abstraction class by implementing more specific functionality.
    - **Example:** `AdvancedRemoteControl` which adds additional functionality like volume control.

3. **Implementor:**
    - This interface defines the low-level operations that are needed to perform the actual work. It does not specify what these operations are but provides the basic methods.
    - **Example:** `Device` interface with methods like `turnOn()` and `turnOff()`.

4. **Concrete Implementor:**
    - This class implements the Implementor interface and provides the actual behavior.
    - **Example:** `TV` or `Radio` classes that provide the actual implementation of turning on and off.

## Example in Code

Here’s a simplified example of the Bridge Pattern in Java:

```java
// Implementor
interface Device {
    void turnOn();
    void turnOff();
}

// ConcreteImplementor
class TV implements Device {
    public void turnOn() {
        System.out.println("TV is turned on");
    }
    public void turnOff() {
        System.out.println("TV is turned off");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio is turned on");
    }
    public void turnOff() {
        System.out.println("Radio is turned off");
    }
}

// Abstraction
abstract class RemoteControl {
    protected Device device;
    
    public RemoteControl(Device device) {
        this.device = device;
    }
    
    public abstract void pressOnButton();
    public abstract void pressOffButton();
}

// RefinedAbstraction
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }
    
    public void pressOnButton() {
        device.turnOn();
    }
    
    public void pressOffButton() {
        device.turnOff();
    }
}

// Client code
public class BridgePatternDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new AdvancedRemoteControl(tv);
        remote.pressOnButton();  // Output: TV is turned on
        remote.pressOffButton(); // Output: TV is turned off
        
        Device radio = new Radio();
        remote = new AdvancedRemoteControl(radio);
        remote.pressOnButton();  // Output: Radio is turned on
        remote.pressOffButton(); // Output: Radio is turned off
    }
}
```
## How It Works

- **Abstraction** (`RemoteControl`) and **Refined Abstraction** (`AdvancedRemoteControl`) define the high-level operations and rely on the **Implementor** (`Device`) interface to perform the actual work.
- **Concrete Implementor** (`TV`, `Radio`) provides specific implementations of the device operations.
- By using the Bridge Pattern, the `RemoteControl` class can work with any type of device (`TV`, `Radio`) without needing to know the details of how the device operates.

The Bridge Pattern is useful when you want to decouple abstraction from implementation, making it easier to extend both the abstraction and implementation independently.
