package Handlers;


public class LoggingHandler implements Handler {
    private Handler next;

    @Override
    public void setNextHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {
        log(request);
        if (next != null) {
            next.handleRequest(request);
        }
    }

    private void log(Request request) {
        System.out.println("Logging request: " + request.getContent());
    }
}
