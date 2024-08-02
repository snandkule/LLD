import Strategy.BitcoinPayment;
import Strategy.CreditCardPayment;
import Strategy.PayPalPayment;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        PaymentContext onlineContext = new OnlinePaymentContext();
        onlineContext.setPaymentStrategy(new CreditCardPayment());
        onlineContext.executePayment(100.0);

        onlineContext.setPaymentStrategy(new PayPalPayment());
        onlineContext.executePayment(200.0);

        // In-store payment context with different strategies
        PaymentContext inStoreContext = new InStorePaymentContext();
        inStoreContext.setPaymentStrategy(new BitcoinPayment());
        inStoreContext.executePayment(300.0);

        inStoreContext.setPaymentStrategy(new CreditCardPayment());
        inStoreContext.executePayment(400.0);

        // Mobile payment context with different strategies
        PaymentContext mobileContext = new MobilePaymentContext();
        mobileContext.setPaymentStrategy(new PayPalPayment());
        mobileContext.executePayment(500.0);
    }
}

//paymentStategy
//-> pay(double amount)
//
//CreditCardPayment
//PaypalPayment
//BitcoinPayment
//UPIPayment
//
//
//PaymentContext
//-> PaymentStrategy
//-> setPAymentStrategy
//-> executePayment
//
//Online
//Instore
//Mobile