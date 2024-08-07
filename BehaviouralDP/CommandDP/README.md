# Command Design Pattern

The Command design pattern is a behavioral design pattern that encapsulates a request as an object, allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests. It also supports undoable operations.

## Key Concepts

1. **Command Interface**: Defines a common interface for all concrete command classes. It typically has an `execute()` method that is called to perform the action.

2. **Concrete Command**: Implements the `Command` interface and defines the binding between a receiver object and an action. It invokes the appropriate action on the receiver.

3. **Receiver**: The object that knows how to perform the operations required by the command. It is the actual object that performs the work when the command is executed.

4. **Invoker**: The object that asks the command to execute the request. It holds a command and calls the command's `execute()` method when required.

5. **Client**: The object that creates and configures the command objects and associates them with the invoker.

## Benefits

- **Encapsulation of Requests**: The Command pattern encapsulates all details of a request, including the method call, the method parameters, and the receiver.

- **Decoupling**: The pattern decouples the sender of a request from the object that performs the action, allowing for more flexible and reusable code.

- **Undo/Redo**: Commands can be stored and executed later, allowing for undo and redo operations.

- **Logging**: Commands can be logged or stored for historical purposes, providing a history of actions.

## Example Scenario

Let's consider a simple example: a remote control system for a home automation setup. The remote control can perform various actions, such as turning on and off lights or changing TV channels. Each action is encapsulated as a command.

## Example Code

### Command Interface

```java
interface Command {
    void execute();
}
```

### Receiver
```java
class Light {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}
```

### Concrete Command
```java
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
```

### Invoker
```java
class RemoteControl {
private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### Client
```java
public class CommandPatternDemo {
public static void main(String[] args) {
Light light = new Light();
Command lightOn = new LightOnCommand(light);
Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
```

## Explanation

- **Command Interface**: `Command` interface declares the `execute()` method that concrete commands will implement.

- **Concrete Command**: `LightOnCommand` and `LightOffCommand` classes implement the `Command` interface and execute the appropriate action on the `Light` receiver.

- **Receiver**: `Light` class performs the actual work of turning the light on and off.

- **Invoker**: `RemoteControl` class acts as the invoker. It holds a reference to a `Command` object and calls its `execute()` method when the button is pressed.

- **Client**: The `CommandPatternDemo` class sets up the command objects and the invoker, and simulates pressing the remote control buttons.

## Advanced Usage

- **Undo/Redo**: Commands can be extended to support undo and redo operations by adding additional methods and maintaining a history of executed commands.

- **Macro Commands**: Commands can be composed into composite commands, allowing multiple actions to be executed as a single command.

The Command design pattern provides a flexible way to handle requests and actions, making it easier to manage and extend the functionality of your application.

