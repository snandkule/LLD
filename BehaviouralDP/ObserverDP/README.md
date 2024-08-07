# Observer Design Pattern

The **Observer** design pattern is a behavioral pattern that defines a one-to-many dependency between objects. When a change in one object (the subject) occurs, all its dependents (observers) are notified and updated automatically. This pattern is used to minimize coupling between the subject and its observers, promoting a flexible and dynamic relationship.

## Key Concepts

1. **Subject (or Observable)**: The object that maintains a list of observers and notifies them of any state changes. It provides methods to attach and detach observers.

2. **Observer**: The interface or abstract class that defines the `update` method, which is called by the subject to notify observers of changes.

3. **ConcreteSubject**: A subclass of the Subject that maintains the state of interest to ConcreteObservers. It sends a notification to the observers when its state changes.

4. **ConcreteObserver**: A subclass of Observer that implements the `update` method to respond to changes in the subject.

## How It Works

1. **Attach/Subscribe**: Observers subscribe to the subject to receive updates.

2. **Detach/Unsubscribe**: Observers can unsubscribe from the subject to stop receiving updates.

3. **Notify**: When the subject’s state changes, it notifies all subscribed observers about the change.

## Benefits

- **Decoupling**: The subject and observers are loosely coupled, meaning that the subject does not need to know the concrete classes of its observers.
- **Dynamic Relationship**: Observers can be added or removed at runtime.
- **Single Responsibility**: The subject manages the state and its changes, while observers handle the response to state changes.

#### UML Diagram
```plaintext
+--------------------------------+
|          <<interface>>         |
|            Subject             |
+--------------------------------+
| +registerObserver(o: Observer) |
| +removeObserver(o: Observer)   |
| +notifyObservers()             |
+--------------------------------+
                ^
                |
+--------------------------------+
|         ConcreteSubject        |
+--------------------------------+
| -observers: List<Observer>     |
| -state: State                  |
| +getState(): State             |
| +setState(state: State): void  |
| +registerObserver(o: Observer) |
| +removeObserver(o: Observer)   |
| +notifyObservers(): void       |
+--------------------------------+
|
|
+--------------------------------+
|        <<interface>>           |
|           Observer             |
+--------------------------------+
| +update(state: State): void    |
+--------------------------------+
                ^
                |
+--------------------------------+
|        ConcreteObserver        |
+--------------------------------+
| -subject: Subject              |
| -state: State                  |
| +update(state: State): void    |
| +display(): void               |
+--------------------------------+
```
## Example: Weather Monitoring System

### Step-by-Step Implementation

#### 1. Define the Observer Interface

```java
interface Observer {
    void update(float temperature, float humidity, float pressure);
}
```
#### 2. Define the Subject Interface
```java
interface Subject {
void registerObserver(Observer o);
void removeObserver(Observer o);
void notifyObservers();
}
```

#### 3. Implement the Concrete Subject
```java
import java.util.ArrayList;
import java.util.List;

class WeatherData implements Subject {
private List<Observer> observers;
private float temperature;
private float humidity;
private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // Simulate a change in weather measurements
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }
}
```
#### 4. Implement Concrete Observers
```java
class CurrentConditionsDisplay implements Observer {
private float temperature;
private float humidity;
private Subject weatherData;

public CurrentConditionsDisplay(Subject weatherData) {
this.weatherData = weatherData;
weatherData.registerObserver(this);
}

@Override
public void update(float temperature, float humidity, float pressure) {
this.temperature = temperature;
this.humidity = humidity;
display();
}

public void display() {
System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
}
}
```
#### 5. Test the Pattern
```java
   public class ObserverPatternDemo {
   public static void main(String[] args) {
   WeatherData weatherData = new WeatherData();

        // Create displays
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        // Simulate weather changes
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
   }
   }
```
## Summary

The **Observer** pattern is used to establish a one-to-many relationship between objects. It allows the subject to notify all registered observers of changes in its state, without being tightly coupled to the observers.

In the weather monitoring system example:
- The `WeatherData` class acts as the **subject**. It maintains a list of registered observers and notifies them whenever there is a change in the weather measurements.
- The `CurrentConditionsDisplay` class acts as a **concrete observer**. It receives updates from the `WeatherData` subject and updates its display accordingly.

This design promotes loose coupling between the subject and its observers, making it easier to add or remove observers dynamically and to maintain and extend the system with minimal impact on existing code.


## Key Differences Between Mediator and Observer DP

### Purpose

- **Mediator**: Centralizes control and interaction between multiple objects to reduce dependencies and simplify communication.

- **Observer**: Provides a way to notify multiple objects about state changes in a subject, promoting loose coupling and dynamic updates.

### Interaction

- **Mediator**: Manages interactions between colleagues by acting as an intermediary.

- **Observer**: Allows subjects to notify multiple observers of state changes directly.

### Use Case

- **Mediator**: Best for complex interaction scenarios where centralized control is needed.

- **Observer**: Best for scenarios where multiple objects need to be updated based on changes to a single subject.

### Summary

While both patterns help manage dependencies and interactions between objects, the **Mediator** pattern is focused on centralizing communication and reducing direct dependencies between objects, whereas the **Observer** pattern is focused on allowing multiple objects to observe and react to changes in a single subject.
