package Strategy;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(Double amt) {
        System.out.println("Paying the amount: "+ amt +" CHF using Paypal Account");
    }
}
