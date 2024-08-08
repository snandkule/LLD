package example.stockMarketApp;

public class InvestorClient implements UserClient{
    StockMarket stockMarket;

    public InvestorClient(StockMarket stockMarket){
        this.stockMarket = stockMarket;
    }
    @Override
    public void display() {
        System.out.println("Displaying stock price in InvestorClient: "+ this.stockMarket.getStock());
    }
}
