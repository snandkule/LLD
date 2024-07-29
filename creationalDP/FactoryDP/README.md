# Implementing the Factory Design Pattern

You are tasked with creating a notification system that can send different types of notifications (e.g., Email, SMS, Push Notifications). Implement the Factory design pattern to create instances of these different notification types based on user input.

## Requirements

### Notification Interface

1. Create a `Notification` interface with a method `send(String message)`.

### Concrete Notification Classes

1. Implement at least three classes that implement the `Notification` interface:
    - `EmailNotification`: Sends an email notification.
    - `SMSNotification`: Sends an SMS notification.
    - `PushNotification`: Sends a push notification.

### NotificationFactory Class

1. Create a `NotificationFactory` class with a static method `createNotification(String type)` that returns an instance of the appropriate notification type.
2. The `createNotification` method should take a `String` parameter to determine the type of notification to create (e.g., "EMAIL", "SMS", "PUSH").

### Testing

1. Create a test class `NotificationTest` that demonstrates the use of the factory to create different types of notifications and send messages with them.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        Notification email = NotificationFactory.createNotification("EMAIL");
        email.send("This is an email message.");

        Notification sms = NotificationFactory.createNotification("SMS");
        sms.send("This is an SMS message.");

        Notification push = NotificationFactory.createNotification("PUSH");
        push.send("This is a push notification message.");
    }
}
