import example.stockMarketApp.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        StockMarket stockMarket = new BombayStockMarket();
        InvestorClient investorClient = new InvestorClient(stockMarket);
        AnallyticsClient anallyticsClient = new AnallyticsClient(stockMarket);
        AnallyticsClient anallyticsClient2 = new AnallyticsClient(stockMarket);
        NewAgencyClient newAgencyClient = new NewAgencyClient(stockMarket);
        InvestorClient investorClient2 = new InvestorClient(stockMarket);
        InvestorClient investorClient3 = new InvestorClient(stockMarket);

        Stock stock1 = new Stock("Apple", "450USD");
        Stock stock2 = new Stock("Microsoft", "350USD");

        stockMarket.registerStock(stock1);
        stockMarket.registerStock(stock2);

        stockMarket.registerClient(investorClient, stock1);
        stockMarket.registerClient(investorClient2, stock1);
        stockMarket.registerClient(investorClient2,stock2);
        stockMarket.registerClient(investorClient3,stock2);
        stockMarket.registerClient(anallyticsClient,stock1);
        stockMarket.registerClient(anallyticsClient2,stock2);
        stockMarket.registerClient(newAgencyClient, stock1);

        System.out.println("--------------------------");

        stockMarket.notify(stock1);
        stock1.setPrice("480USD");
        stockMarket.notify(stock1);

        System.out.println("--------------------------");

        stockMarket.notify(stock2);
        stock1.setPrice("290USD");
        stockMarket.notify(stock2);

        System.out.println("--------------------------");

    }
}