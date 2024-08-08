# Proxy Pattern

## Overview

The Proxy Pattern is a structural design pattern that provides a surrogate or placeholder object to control access to another object. It can be used for various purposes such as lazy initialization, access control, logging, or remote method invocation.

## Components

1. **Subject Interface**
    - Defines the common interface for both the RealSubject and the Proxy.
    - This ensures that the Proxy can be used wherever the RealSubject is expected.

2. **RealSubject**
    - The actual object that the Proxy represents. It implements the Subject interface and contains the core functionality.

3. **Proxy**
    - Maintains a reference to the RealSubject.
    - Controls access to the RealSubject and may add additional functionality (e.g., lazy initialization, access control).
    - Implements the same interface as the RealSubject.

## Textual UML Diagram

```plaintext
+-------------------+
|    Subject        |
|-------------------|
| +request()        |
+-------------------+
          ^
          |
          |
+-------------------+       +------------------+
|    Proxy          |       |   RealSubject    |
|-------------------|       |------------------|
| -realSubject:     |       |                  |
|  RealSubject      |       | +request()       |
|-------------------|       +------------------+
| +request()        |
+-------------------+
```

## Example in Java

### 1. Subject Interface

```java
public interface Subject {
    void request();
}
```
### 2. RealSubject Class
```java
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}
  ```
### 3. Proxy Class
```java
public class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
    }
    System.out.println("Proxy: Doing some preliminary work.");
    realSubject.request();
    System.out.println("Proxy: Doing some post-processing.");
    }
}
```
### 4. Client Code
```java
public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}
```
## Explanation

### Subject Interface
Defines the `request()` method that both `RealSubject` and `Proxy` implement. This interface ensures that both classes can be used interchangeably, allowing the `Proxy` to act as a substitute for the `RealSubject`.

### RealSubject
Implements the core functionality of the `request()` method. It performs the actual work that the client is interested in and defines the main logic of the operation.

### Proxy
Maintains a reference to `RealSubject` and controls access to it. The `Proxy` can handle any preliminary or post-processing logic before or after delegating the actual work to the `RealSubject`. This might include tasks like initialization, logging, or access control.

### Client Code
The client interacts with the `Proxy` through the `Subject` interface. This abstraction allows the client to operate without needing to know whether it is dealing with a `Proxy` or a `RealSubject`, simplifying the client’s interaction and reducing coupling.

## Use Cases

### Lazy Initialization
Delays the creation of expensive objects until they are actually needed. This can be useful to avoid unnecessary resource allocation and improve performance.

### Access Control
Controls access to an object based on certain criteria. For example, a `Proxy` might restrict access to sensitive functionality or data based on user permissions or other factors.

### Logging
Provides additional logging or monitoring functionalities. The `Proxy` can log information about the requests being handled, which is useful for auditing and debugging purposes.

### Remote Proxy
Represents an object that is located on a different address space, such as a different machine in a distributed system. The `Proxy` manages communication with the remote object, handling details like network communication and serialization.

## Summary

The Proxy Pattern demonstrates how you can control access to an object, add additional behavior, and manage object creation in a flexible way. It provides a mechanism to manage interactions with an object while hiding its complexities and potentially adding additional functionality.

