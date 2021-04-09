package Service;

import Users.Client;
import Users.Driver;
import Users.Restaurant;
import Users.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<Client> clientList;
    private List<Driver> driverList;
    private List<Restaurant> restaurantList;

    private static UserService instance = null;

    private UserService(){
        clientList = new ArrayList<>();
        driverList = new ArrayList<>();
        restaurantList = new ArrayList<>();
    }

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    ///Clients methods
    public void addClient(Client client){
        clientList.add(new Client(client));
    }

    public void showClients() {
        for(Client c : clientList)
            System.out.println(c.toString());
    }

    public Client getClient(int i){
        return this.clientList.get(i);
    }

    ///Driver methods
    public void addDriver(Driver driver){
        driverList .add(new Driver(driver));
    }

    public void showDrivers(){
        for(Driver d : driverList)
            System.out.println(d.toString());
    }

    public Driver getDriver(int i){
        return this.driverList.get(i);
    }

    ///Restaurants methods
    public void addRestaurant(Restaurant restaurant){
        restaurantList.add(new Restaurant(restaurant));
    }

    public void showRestaurants(){
        for(Restaurant r : restaurantList)
            System.out.println(r.toString());
    }

    public Restaurant getRestaurant(int i){
        return this.restaurantList.get(i);
    }
}
