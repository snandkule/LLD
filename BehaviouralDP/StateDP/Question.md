# Exercise: Traffic Light System

## Problem Statement

You are tasked with designing a traffic light control system for an intersection. The traffic light system has different states based on the traffic light colors and their durations:

1. **Red Light:** The light is red, and vehicles must stop.
2. **Green Light:** The light is green, and vehicles can go.
3. **Yellow Light:** The light is yellow, and vehicles should prepare to stop.

The traffic light should transition between these states based on a predefined sequence and time intervals.

## Requirements

1. **State Management:**
    - Implement the State design pattern to manage the state transitions of the traffic light.
    - The traffic light should start in the Red Light state and transition to Green Light after a set duration.
    - After the Green Light state, it should transition to Yellow Light and then back to Red Light.

2. **State Transitions:**
    - Implement methods to handle transitions such as `changeLight()`, which moves the traffic light to the next state based on a timer.
    - Ensure that each state handles the method `handle()` according to its behavior and transitions to the next appropriate state.

3. **State Behavior:**
    - **Red Light:** Vehicles must stop, and the light will change to Green after the set duration.
    - **Green Light:** Vehicles can go, and the light will change to Yellow after the set duration.
    - **Yellow Light:** Vehicles should prepare to stop, and the light will change to Red after the set duration.

4. **Implementation Details:**
    - Use a State interface to define common methods that all states will implement, such as `handle()` and `emergencyOverride()`.
    - Create concrete classes for each state that implement the State interface.
    - The TrafficLight class should maintain a reference to the current state and delegate state-specific behavior to the current state object.

5. **Extension (Optional):**
    - **Dynamic Light Durations:** Implement timing logic to allow adjustment of light durations based on traffic conditions (e.g., longer green lights during rush hours).
    - **Emergency Override:** Add a feature to immediately transition to the Red Light state when an emergency override is activated.

## Challenge

- Ensure that the design adheres to the State pattern principles by encapsulating state-specific behavior in separate classes.
- Demonstrate the traffic light's state transitions and behavior with sample interactions, showing how the system handles state changes over time and the emergency override feature.

## Example Usage

```java
public class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        
        // Simulate state transitions
        System.out.println("Traffic Light Simulation:");
        trafficLight.changeLight(); // Red -> Green
        // Simulate some delay before emergency override
        try {
            Thread.sleep(2000); // Delay to show the effect before override
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficLight.emergencyOverride(); // Immediate Red Light due to emergency
    }
}
```

## Expected Output
```plaintext
Traffic Light Simulation:
Red Light - Vehicles must stop.
Green Light - Vehicles can go.
Yellow Light - Prepare to stop.
Red Light - Vehicles must stop.
Emergency Override - Immediate transition to Red Light.
```