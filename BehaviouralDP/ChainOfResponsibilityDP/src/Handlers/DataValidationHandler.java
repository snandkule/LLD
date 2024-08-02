package Handlers;

public class DataValidationHandler implements Handler{
    private Handler next;

    @Override
    public void setNextHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {
        if (validate(request)) {
            System.out.println("Data validation successful.");
            if (next != null) {
                next.handleRequest(request);
            }
        } else {
            System.out.println("Data validation failed.");
        }
    }

    private boolean validate(Request request) {
        return true;
    }
}
