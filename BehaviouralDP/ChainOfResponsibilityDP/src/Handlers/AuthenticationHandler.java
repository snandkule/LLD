package Handlers;

public class AuthenticationHandler implements Handler{
    Handler next;
    @Override
    public void setNextHandler(Handler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if(isAuthenticated(request)) {
            System.out.println("Authentication successful.");
            if(next!=null)
                next.handleRequest(request);
        }else{
            System.out.println("Authentication failed.");
        }

    }

    private boolean isAuthenticated(Request request) {
        System.out.println("Handling request in Authentication with request content =" + request.getContent());
        return true;
    }
}
