package Menu;

import Users.Client;
import Users.Driver;
import Users.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Restaurant restaurant;
    private List<Item> itemsList = new ArrayList<>();
    private Client client;
    private Driver driver;
    private Float price;
    private boolean delivered = false;

    public Order(Restaurant restaurant, List<Item> itemsList, Client client, Driver driver, Float price) {
        this.restaurant = restaurant;
        this.itemsList = itemsList;
        this.client = client;
        this.driver = driver;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "restaurant=" + restaurant +
                ", itemsList=" + itemsList +
                ", client=" + client +
                ", driver=" + driver +
                ", price=" + price +
                ", delivered=" + delivered +
                '}';
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
