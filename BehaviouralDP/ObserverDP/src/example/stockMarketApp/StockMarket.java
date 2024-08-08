package example.stockMarketApp;

public interface StockMarket {

    public void registerStock(Stock stock);
    public void unregisterStock(Stock stock);
    public void registerClient(UserClient client, Stock stock);
    public void unregisterClient(UserClient client, Stock stock);
    public void notify(Stock stock);

    public Stock getStock();
}
