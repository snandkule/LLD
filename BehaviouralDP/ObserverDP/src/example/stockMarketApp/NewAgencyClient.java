package example.stockMarketApp;

public class NewAgencyClient implements UserClient{
    StockMarket stockMarket;

    public NewAgencyClient(StockMarket stockMarket){
        this.stockMarket = stockMarket;
    }
    @Override
    public void display() {
        System.out.println("Displaying stock price in NewAgencyClient: "+ this.stockMarket.getStock());
    }
}