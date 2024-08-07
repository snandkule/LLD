# Implementing the Singleton Design Pattern

You are tasked with creating a logging utility for an application that ensures only one instance of the logger exists throughout the application's lifecycle. This logger will be responsible for writing log messages to a file. Implement the Singleton design pattern to achieve this requirement.

## Requirements

### Logger Class

1. Create a `Logger` class that follows the Singleton design pattern.
2. Ensure that only one instance of `Logger` can be created.
3. Provide a method `getInstance` to get the single instance of `Logger`.

### Logging Functionality

1. Add a method `log(String message)` to the `Logger` class that writes the log message to a file called `log.txt`.
2. Ensure that each log message is appended to the file with a timestamp.

### Thread Safety

1. Ensure that the `Logger` class is thread-safe, meaning that multiple threads can use the `Logger` instance without causing any issues.

### Testing

1. Create a test class `LoggerTest` that demonstrates the singleton property by creating multiple threads that try to get the `Logger` instance and log messages.
2. Ensure that all log messages from different threads are written to the same `log.txt` file.

## Example Usage

```java
public class main.java.com.example.library.Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started.");

        // Simulate multiple threads logging messages
        Thread thread1 = new Thread(() -> {
            Logger.getInstance().log("Thread 1 logging a message.");
        });
        Thread thread2 = new Thread(() -> {
            Logger.getInstance().log("Thread 2 logging a message.");
        });

        thread1.start();
        thread2.start();
    }
}
