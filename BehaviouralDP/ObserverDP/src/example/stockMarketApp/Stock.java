package example.stockMarketApp;

public class Stock {
    String name;
    String price;
    public Stock(String name, String price){
        this.name = name;
        this.price = price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
