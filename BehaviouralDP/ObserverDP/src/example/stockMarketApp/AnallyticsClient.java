package example.stockMarketApp;

public class AnallyticsClient implements UserClient{
    StockMarket stockMarket;

    public AnallyticsClient(StockMarket stockMarket){
        this.stockMarket = stockMarket;
    }
    @Override
    public void display() {
        System.out.println("Displaying stock price in AnallyticsClient: "+ this.stockMarket.getStock());
    }
}
