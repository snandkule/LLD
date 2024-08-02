import Handlers.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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