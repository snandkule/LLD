### State Design Pattern

The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. The object will appear to change its class.

#### Key Concepts

1. **Context**: This is the class that contains the current state and delegates the state-specific behavior to the state objects.
2. **State Interface**: This interface declares the state-specific behavior that concrete state classes must implement.
3. **Concrete States**: These classes implement the state-specific behavior. Each concrete state corresponds to a particular state of the context.

#### Benefits

- **Encapsulation of State-Specific Behavior**: State-specific behaviors are encapsulated in separate classes, making the context class simpler.
- **Single Responsibility Principle**: The context class is relieved of state-specific behaviors, adhering to the Single Responsibility Principle.
- **Open/Closed Principle**: Adding new states is easy and doesn’t affect the context class or existing states.

#### Example: Vending Machine

Let's consider a simple example of a vending machine with three states: HasCoin, NoCoin, and SoldOut.

#### UML Diagram

```plaintext
  +------------------+
  |     Context      |
  |------------------|
  | - state: State   |
  +------------------+
  | + setState(s: State) |
  | + insertCoin()   |
  | + ejectCoin()    |
  | + dispense()     |
  +--------|---------+
           |
           v
  +------------------+
  |      State       |
  |------------------|
  | + insertCoin()   |
  | + ejectCoin()    |
  | + dispense()     |
  +--------|---------+
           |
 +---------+---------+
 |                   |
 v                   v
+------------------+ +------------------+
|     HasCoin      | |     NoCoin       |
+------------------+ +------------------+
| + insertCoin()   | | + insertCoin()   |
| + ejectCoin()    | | + ejectCoin()    |
| + dispense()     | | + dispense()     |
+------------------+ +------------------+
```
#### Implementation
```java
// State interface
interface State {
    void insertCoin();
    void ejectCoin();
    void dispense();
}

// Context class
class VendingMachine {
    private State hasCoinState;
    private State noCoinState;
    private State soldOutState;
    private State state;
    private int count;

    public VendingMachine(int count) {
        hasCoinState = new HasCoinState(this);
        noCoinState = new NoCoinState(this);
        soldOutState = new SoldOutState(this);
        this.count = count;

        if (count > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseProduct() {
        if (count > 0) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void dispense() {
        state.dispense();
    }
}

// Concrete State: HasCoinState
class HasCoinState implements State {
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned.");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing product...");
        vendingMachine.releaseProduct();
        if (vendingMachine.getCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoCoinState());
        } else {
            System.out.println("Sold out.");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }
}

// Concrete State: NoCoinState
class NoCoinState implements State {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to return.");
    }

    @Override
    public void dispense() {
        System.out.println("Insert coin first.");
    }
}

// Concrete State: SoldOutState
class SoldOutState implements State {
    private VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Sold out. Can't accept coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to return.");
    }

    @Override
    public void dispense() {
        System.out.println("Sold out.");
    }
}

// Demo class to test the Vending Machine with different states
public class StatePatternDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(2);

        vendingMachine.insertCoin();
        vendingMachine.dispense();

        vendingMachine.insertCoin();
        vendingMachine.ejectCoin();

        vendingMachine.insertCoin();
        vendingMachine.dispense();

        vendingMachine.insertCoin();
        vendingMachine.dispense();
    }
}
```

### Explanation

- **State Interface**: `State` defines the methods that each state will implement.

- **Concrete States**:
    - **HasCoinState**: Represents the state where a coin is already inserted.
    - **NoCoinState**: Represents the state where no coin is inserted.
    - **SoldOutState**: Represents the state where the machine is sold out.

- **Context Class**: `VendingMachine` contains an instance of each state and maintains the current state. It delegates the behavior to the current state.

### Benefits and Usage

- **Flexibility**: The pattern allows an object to alter its behavior when its internal state changes.
- **Encapsulation**: Each state-related behavior is encapsulated in a separate class.
- **Open/Closed Principle**: New states can be added without modifying existing states or the context class.
- **Real-world Usage**: The state pattern is useful in scenarios like vending machines, traffic lights, state machines in parsers, and UI components with different states (enabled, disabled, etc.).

By following the State Design Pattern, we ensure that the `VendingMachine` class is simplified and adheres to the SOLID principles, particularly the Open/Closed Principle and the Single Responsibility Principle.
