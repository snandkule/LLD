import Strategy.BitcoinPayment;
import Strategy.PaymentStrategy;

public class MobilePaymentContext extends PaymentContext{
    public MobilePaymentContext() {
        super(new BitcoinPayment());
    }
}
