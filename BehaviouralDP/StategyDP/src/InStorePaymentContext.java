import Strategy.CreditCardPayment;
import Strategy.PaymentStrategy;

public class InStorePaymentContext extends PaymentContext{

    public InStorePaymentContext() {
        super(new CreditCardPayment());
    }
}
