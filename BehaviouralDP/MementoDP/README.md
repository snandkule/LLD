# Memento Design Pattern

The Memento design pattern is a behavioral pattern that allows an object's state to be saved and restored at a later time without exposing its internal details. This pattern is particularly useful for implementing undo/redo functionality or restoring an object to a previous state.

## Components of the Memento Pattern

1. **Originator**: The object whose state needs to be saved and restored. It creates a Memento to capture its current state and can use the Memento to restore its state.

2. **Memento**: A container object that stores the state of the Originator. It provides access to the state but does not expose the details of how the state is stored.

3. **Caretaker**: Manages the Memento objects. It is responsible for keeping track of multiple Mementos, usually in a history list, and can request the Originator to restore its state from a specific Memento.

## Example Scenario

Let’s take the example of a simple text editor that supports undo functionality. The text editor can save the state of its text (the Originator) and restore it later using saved states (Mementos).

## Detailed Example

### UML Diagram
```plaintext
+----------------+       +------------------+       +----------------+
|   Originator   |       |     Memento      |       |   Caretaker    |
+----------------+       +------------------+       +----------------+
| - state: String|       | - state: String  |       | - mementoList  |
+----------------+       +------------------+       | : List<Memento>|
| + setState()   |       | + getState():    |       +----------------+
| + getState():  |       |   String         |       | + add(memento):|
|   String       |       |                  |       |   void         |
| + saveStateToM |       +------------------+       | + get(index):  |
|   emento():    |                                 |   Memento      |
|   Memento      |                                 +----------------+
| + getStateFrom |
|   Memento(m:   |
|   Memento):    |
|   void         |
+----------------+
```
### 1. Define the Memento Class

The Memento class stores the state of the Originator. It’s usually a private inner class within the Originator to encapsulate the state.

```java
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```
### 2. Define the Originator Class
   The Originator class creates a Memento to capture its current state and uses a Memento to restore its state.

```java
class Originator {
private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```
### 3. Define the Caretaker Class
   The Caretaker class keeps track of the Memento objects. It’s responsible for saving and retrieving the Memento objects.

```java
import java.util.ArrayList;
import java.util.List;

class Caretaker {
private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
```
### 4. Demonstration of the Memento Pattern
   Finally, let’s demonstrate how to use these classes to save and restore the state of the Originator.

```java
public class MementoPatternDemo {
public static void main(String[] args) {
Originator originator = new Originator();
Caretaker caretaker = new Caretaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

## Explanation of the Example

### Creating and Saving States

1. **Originator** sets its state to `"State #1"` and `"State #2"`, and saves this state to a `Memento` object.
2. The state is then changed to `"State #3"`, and this new state is also saved to a `Memento` object.
3. The state changes again to `"State #4"`.

### Restoring States

1. The current state (`"State #4"`) is printed.
2. The state is restored from the first saved `Memento` (which has the state `"State #2"`).
3. The state is then restored from the second saved `Memento` (which has the state `"State #3"`).

## Benefits of the Memento Pattern

1. **Encapsulation**: The Memento pattern encapsulates the internal state of the Originator object, which helps in maintaining the integrity of the object and prevents exposure of its internal details.

2. **Undo/Redo Functionality**: It supports undo/redo functionality by storing different states of an object and allowing them to be restored as needed.

3. **Separation of Concerns**: It separates the responsibility of saving and restoring the state from the Originator, allowing the Originator to focus on its core responsibilities.

## Drawbacks of the Memento Pattern

1. **Memory Usage**: If many states are saved, it can consume a lot of memory. Proper management of `Memento` objects is needed to avoid excessive memory usage.

2. **Complexity**: It adds additional classes and complexity to the design, which might be unnecessary for simpler scenarios.

In summary, the Memento design pattern is useful for saving and restoring the state of objects, especially when implementing undo functionality or managing different states in applications.
