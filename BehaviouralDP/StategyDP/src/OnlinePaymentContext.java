import Strategy.PayPalPayment;

public class OnlinePaymentContext extends PaymentContext{
    public OnlinePaymentContext() {
        super(new PayPalPayment());
    }
}
