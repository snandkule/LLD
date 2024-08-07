# Mediator Design Pattern

The **Mediator** design pattern is a behavioral pattern that promotes loose coupling between objects by ensuring that they interact only through a mediator object. This pattern is used to reduce the dependencies between communicating objects, making the system more flexible and easier to maintain.

## Mediator Pattern Overview

### Intent
The Mediator pattern defines an object that encapsulates how a set of objects interact. By centralizing communication, it avoids direct communication between objects, which can lead to tight coupling and complex dependencies.

### Key Components
1. **Mediator**: Defines an interface for communication between Colleague objects.
2. **ConcreteMediator**: Implements the Mediator interface and coordinates communication between Colleague objects.
3. **Colleague**: Defines an interface for communication with other Colleague objects through the Mediator.
4. **ConcreteColleague**: Implements the Colleague interface and communicates with other Colleagues through the Mediator.

## Example: Chat Room

Let's illustrate the Mediator pattern with a chat room example. In this example, multiple users communicate in a chat room, but the chat room itself (the Mediator) handles the communication between users.

### Components

1. **Mediator Interface (`ChatRoomMediator`)**:
   Defines the method for communication between users.

2. **Concrete Mediator (`ChatRoom`)**:
   Implements the Mediator interface and manages user communication.

3. **Colleague Interface (`User`)**:
   Defines the method for sending messages.

4. **Concrete Colleague (`ChatUser`)**:
   Implements the Colleague interface and communicates with the Mediator.

### Code Implementation

```java
// Mediator Interface
interface ChatRoomMediator {
    void showMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatRoomMediator {
    @Override
    public void showMessage(User user, String message) {
        System.out.println(user.getName() + ": " + message);
    }
}

// Colleague Interface
abstract class User {
    protected ChatRoomMediator mediator;
    protected String name;

    public User(ChatRoomMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public String getName() {
        return name;
    }
}

// Concrete Colleague
class ChatUser extends User {
    public ChatUser(ChatRoomMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.showMessage(this, message);
    }
}

// Client Code
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoom();

        User user1 = new ChatUser(mediator, "Alice");
        User user2 = new ChatUser(mediator, "Bob");

        user1.sendMessage("Hi Bob!");
        user2.sendMessage("Hello Alice!");
    }
}
```

## How It Works

- **Mediator**: `ChatRoom` implements the `ChatRoomMediator` interface and handles the communication logic.
- **Colleague**: `ChatUser` represents users in the chat room and communicates with the `ChatRoom` mediator.
- **Interaction**:
    1. When `user1` sends a message, it calls the `sendMessage` method.
    2. The `sendMessage` method in `ChatUser` invokes the `showMessage` method on the `ChatRoom` mediator.
    3. The `ChatRoom` mediator prints the message along with the user's name, thus facilitating the communication between users.

## Example 2: Air Traffic Control System

The **Mediator** design pattern is a behavioral pattern that centralizes communication between objects to reduce their dependencies. In this example, we use the Mediator pattern to manage communication between different aircraft and the Air Traffic Control (ATC) system.

In this scenario, the ATC acts as the mediator, ensuring that aircraft communicate with each other through a central point, avoiding direct communication between aircraft.

### UML Diagram
```plaintext
+-----------------------------+
|       AirTrafficControl     |<---------+------+
|-----------------------------|          |      |
| + registerAircraft(Aircraft)|          |      |
| + sendMessage(Aircraft, String)|       |      |
+-----------------------------+          |      |
                                         |      |
                                         |      |
                                         |      |
                                         |      |
                                         |      |
+-----------------------------+          |      |
| ConcreteAirTrafficControl   |          |      |
|-----------------------------|          |      |
| - aircrafts: List<Aircraft> |          |      |
|-----------------------------|          |      |
| + registerAircraft(Aircraft)|          |      |
| + sendMessage(Aircraft, String)|       |      |
+-----------------------------+          |      |
                                         |      |
                                         |      |
                                         |      |
                                         |      |
                                         |      |
+-----------------------------+          |      |
|          Aircraft           |          |      |
|-----------------------------|          |      |
| # mediator: AirTrafficControl|         |      |
| # name: String               |         |      |
|-----------------------------|          |      |
| + sendMessage(String)       |          |      |
| + receiveMessage(Aircraft, String)|    |      |
+-----------------------------+          |      |
                                         |      |
                                         |      |
                                         |      |
                                         |      |
+-----------------------------+          |      |
|       ConcreteAircraft      |----------+------+
|-----------------------------|
| + ConcreteAircraft(AirTrafficControl, String) |
| + sendMessage(String)       |
| + receiveMessage(Aircraft, String)|
+-----------------------------+

```
### Components

1. **Mediator Interface (`AirTrafficControl`)**:
   Defines the method for aircraft communication.

2. **Concrete Mediator (`ConcreteAirTrafficControl`)**:
   Implements the Mediator interface and manages aircraft communication.

3. **Colleague Interface (`Aircraft`)**:
   Defines the method for sending and receiving messages.

4. **Concrete Colleague (`ConcreteAircraft`)**:
   Implements the Colleague interface and communicates with the Mediator.

### Code Implementation

```java
// Mediator Interface
interface AirTrafficControl {
    void registerAircraft(Aircraft aircraft);
    void sendMessage(Aircraft sender, String message);
}

// Concrete Mediator
class ConcreteAirTrafficControl implements AirTrafficControl {
    private List<Aircraft> aircrafts = new ArrayList<>();

    @Override
    public void registerAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    @Override
    public void sendMessage(Aircraft sender, String message) {
        for (Aircraft aircraft : aircrafts) {
            // Send message to all aircraft except the sender
            if (aircraft != sender) {
                aircraft.receiveMessage(sender, message);
            }
        }
    }
}

// Colleague Interface
abstract class Aircraft {
    protected AirTrafficControl mediator;
    protected String name;

    public Aircraft(AirTrafficControl mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(Aircraft sender, String message);
}

// Concrete Colleague
class ConcreteAircraft extends Aircraft {
    public ConcreteAircraft(AirTrafficControl mediator, String name) {
        super(mediator, name);
        mediator.registerAircraft(this);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(Aircraft sender, String message) {
        System.out.println(name + " received from " + sender.name + ": " + message);
    }
}

// Client Code
public class MediatorPatternDemo {
    public static void main(String[] args) {
        AirTrafficControl atc = new ConcreteAirTrafficControl();

        Aircraft aircraft1 = new ConcreteAircraft(atc, "Flight A");
        Aircraft aircraft2 = new ConcreteAircraft(atc, "Flight B");
        Aircraft aircraft3 = new ConcreteAircraft(atc, "Flight C");

        aircraft1.sendMessage("Requesting landing clearance.");
        aircraft2.sendMessage("Acknowledged, landing clearance received.");
    }
}
```
## How It Works

- **Mediator (`ConcreteAirTrafficControl`)**: Manages the registration of aircraft and coordinates communication between them.
- **Colleague (`ConcreteAircraft`)**: Represents individual aircraft. Each aircraft communicates through the ATC, sending and receiving messages.

### Interaction

1. When `Flight A` sends a message, it uses the `sendMessage` method.
2. The `sendMessage` method in `ConcreteAircraft` calls `sendMessage` on the `ConcreteAirTrafficControl` mediator.
3. The `ConcreteAirTrafficControl` mediator then broadcasts the message to all other registered aircraft, excluding the sender.
4. Other aircraft receive the message and process it accordingly.

## Benefits

- **Decouples Colleagues**: Mediator reduces the dependency between Colleague objects, promoting loose coupling.
- **Centralizes Control**: Communication logic is centralized in one place (the Mediator), making it easier to manage and modify.
- **Simplifies Object Interactions**: By using a mediator, the interaction between objects is simplified, as they only need to communicate with the mediator rather than with each other directly.

## Drawbacks

- **Mediator Complexity**: The Mediator can become complex if it handles too many interactions or if there are many Colleagues.
- **Single Point of Failure**: The Mediator can become a single point of failure if it becomes too central to the application's logic.

## Conclusion

The Mediator pattern is particularly useful in scenarios where you have multiple objects that need to communicate in a coordinated way, but you want to avoid the complexity and tight coupling of direct interactions between these objects. It centralizes communication in one object, simplifying and managing the communication process more effectively.
