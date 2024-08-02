package Handlers;

public class AuthorizationHandler implements Handler{
    Handler next;

    @Override
    public void setNextHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {

        if(authorize(request)){
            System.out.println("Request Authorized successfully");
            if(next!=null){
                next.handleRequest(request);
            }
        }else{
            System.out.println("Request authorization failed");
        }
    }

    private boolean authorize(Request request) {
        System.out.println("Handling request in Authorization with request content =" + request.getContent());
        return true;
    }
}
