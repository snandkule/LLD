# Implementing the Chain of Responsibility Design Pattern

You are tasked with creating a request processing system that can handle various types of requests (e.g., Authentication, Authorization, Logging, and Data Validation) in a sequence. Implement the Chain of Responsibility design pattern to provide a flexible solution for processing requests through a chain of handlers.

## Requirements

### Request Class
- Create a `Request` class with fields such as `String type` and `String content`.
- Provide appropriate getter and setter methods.

### Handler Interface
- Create a `Handler` interface with methods `setNextHandler(Handler next)` and `handleRequest(Request request)`.

### Concrete Handlers
- Implement at least four classes that implement the `Handler` interface:
    - `AuthenticationHandler`: Checks if the request is authenticated.
    - `AuthorizationHandler`: Checks if the user is authorized to perform the action.
    - `LoggingHandler`: Logs the request details.
    - `DataValidationHandler`: Validates the request data.

### Chain Setup
- Create a method to set up the chain of handlers in a desired sequence.

### Testing
- Create a test class `ChainOfResponsibilityTest` that demonstrates the processing of different types of requests through the chain of handlers.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        // Setup chain of handlers
        Handler authHandler = new AuthenticationHandler();
        Handler authzHandler = new AuthorizationHandler();
        Handler loggingHandler = new LoggingHandler();
        Handler validationHandler = new DataValidationHandler();

        authHandler.setNextHandler(authzHandler);
        authzHandler.setNextHandler(loggingHandler);
        loggingHandler.setNextHandler(validationHandler);

        // Create and process request
        Request request = new Request("DATA_VALIDATION", "Sample request content");
        authHandler.handleRequest(request);
    }
}
