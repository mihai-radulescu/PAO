package Main;

import Menu.Menu;
import Menu.Item;
import Service.*;
import Users.Client;
import Users.Driver;
import Users.Restaurant;
import IO.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hey user!");

        UserService us = UserService.getInstance();
        RestaurantsService rs = RestaurantsService.getInstance();
        ClientService cl = ClientService.getInstance();
        DriverService dr = DriverService.getInstance();
        CartService cart = CartService.getInstance();

        Read.readRestaurantsCsv();
        rs.addRestaurant(new Restaurant("Spartan", "mail", "0561354"), true);
        //rs.showRestaurants();

        Read.readClientsCsv();
        cl.addClient(new Client("Simona", "a@mail3.com", "54684"), true);
        //cl.showClients();

        Read.readDriversCsv();
        dr.addDriver(new Driver("Razvan", "test@mail.ro", "075984"), true);
        //dr.showDrivers();

        Read.readCartCsv();
        cart.addToCart("Limonada", 5, true);
        //cart.showCart();
    }
}
