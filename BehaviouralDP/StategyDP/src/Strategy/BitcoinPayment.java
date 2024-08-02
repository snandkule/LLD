package Strategy;

public class BitcoinPayment implements PaymentStrategy{
    @Override
    public void pay(Double amt) {
        System.out.println("Paying the amount: "+ amt +" CHF using Bitcoin Account");
    }
}
