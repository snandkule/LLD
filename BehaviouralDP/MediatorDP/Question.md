# Question: Implementing the Mediator Design Pattern in a Smart Home System

## Overview

You are tasked with designing a smart home system where various devices (e.g., Lights, Thermostat, Security Cameras) need to interact with each other based on specific events (e.g., a door opening triggers lights to turn on). Implement the Mediator design pattern to manage interactions between these smart home devices without direct references to each other.

## Requirements

### 1. Mediator Interface
- Create a `SmartHomeMediator` interface with the following methods:
    - `registerDevice(String name, SmartHomeDevice device)`: Registers devices with the mediator.
    - `notify(String event, SmartHomeDevice sender)`: Handles notifications and coordinates device interactions.

### 2. Concrete Mediator
- Implement a `SmartHomeHub` class that implements the `SmartHomeMediator` interface. This class will manage device registration and handle event-based communication.

### 3. SmartHomeDevice Class
- Create an abstract class `SmartHomeDevice` with the following features:
    - Field: `SmartHomeMediator mediator`.
    - Constructor to initialize the mediator.
    - Abstract method `onEvent(String event)`: Handles events triggered by the mediator.

### 4. Concrete Devices
- Implement at least four classes that extend `SmartHomeDevice`:
    - `Light`: Responds to events by turning on or off.
    - `Thermostat`: Adjusts temperature based on events.
    - `SecurityCamera`: Activates or deactivates based on events.
    - `DoorSensor`: Sends notifications when the door is opened or closed.

### 5. Event Handling
- Ensure that when a device triggers an event, the `SmartHomeHub` class coordinates the response from other devices.

### 6. Testing
- Create a test class `SmartHomeTest` to demonstrate how different devices interact with each other through the `SmartHomeHub` in response to events.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        // Create the mediator (SmartHomeHub)
        SmartHomeHub hub = new SmartHomeHub();

        // Create devices
        Light livingRoomLight = new Light(hub);
        Thermostat thermostat = new Thermostat(hub);
        SecurityCamera camera = new SecurityCamera(hub);
        DoorSensor doorSensor = new DoorSensor(hub);

        // Register devices with the smart home hub
        hub.registerDevice("LivingRoomLight", livingRoomLight);
        hub.registerDevice("Thermostat", thermostat);
        hub.registerDevice("SecurityCamera", camera);
        hub.registerDevice("DoorSensor", doorSensor);

        // Simulate door opening
        doorSensor.onEvent("DoorOpened");

        // Simulate door closing
        doorSensor.onEvent("DoorClosed");
    }
}
```
## Notes

- **SmartHomeHub**: The `SmartHomeHub` should manage device registration and handle event-based communication between devices. It acts as the central mediator, ensuring that devices can interact without needing direct references to each other.

- **SmartHomeDevice**: Each `SmartHomeDevice` should use the mediator to send and receive event notifications, ensuring loose coupling and flexible interactions. This design allows for easy modification or addition of new devices without altering the existing system.
