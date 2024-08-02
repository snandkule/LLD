package Strategy;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(Double amt) {
        System.out.println("Paying the amount: "+amt+" CHF using Credit card");
    }
}
