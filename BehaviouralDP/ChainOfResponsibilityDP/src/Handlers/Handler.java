package Handlers;


public interface Handler {
    Handler nextHandler = null;

    public void setNextHandler(Handler nextHandler);

    public void handleRequest(Request request);

}
