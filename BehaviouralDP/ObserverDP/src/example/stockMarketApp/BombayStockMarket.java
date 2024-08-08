package example.stockMarketApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BombayStockMarket implements StockMarket{
    Stock stock;
    Map<Stock, List<UserClient>> subscribedUsers;

    public BombayStockMarket(){
        subscribedUsers = new HashMap<>();
    }
    public void setStock(Stock stock){
        this.stock = stock;
    }

    public Stock getStock(){
        return this.stock;
    }
    @Override
    public void registerStock(Stock stock) {
        subscribedUsers.putIfAbsent(stock, new ArrayList<>());
    }

    @Override
    public void unregisterStock(Stock stock) {

        if(subscribedUsers.containsKey(stock))
            subscribedUsers.remove(stock);
    }

    @Override
    public void registerClient(UserClient client, Stock stock) {
        subscribedUsers.putIfAbsent(stock, new ArrayList<>());
        subscribedUsers.get(stock).add(client);
    }

    @Override
    public void unregisterClient(UserClient client, Stock stock) {
        if(subscribedUsers.containsKey(stock))
            subscribedUsers.get(stock).remove(client);
    }

    @Override
    public void notify(Stock stock) {
        this.setStock(stock);
        for(UserClient client: subscribedUsers.get(stock)){
            client.display();
        }
    }
}
