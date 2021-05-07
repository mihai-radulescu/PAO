package IO;

import Users.*;
import Menu.*;
import Service.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Read {
    private static Read instance = null;

    private Read() {
    }

    public static Read getInstance() {
        if (instance == null)
            instance = new Read();
        return instance;
    }

    public static void readRestaurantsCsv(){
        try(var in = new BufferedReader(new FileReader("src/Data/restaurant.csv"))){
            String line;
            RestaurantsService rs = RestaurantsService.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.replaceAll(" ", "").split(",");
                rs.addRestaurant(new Restaurant(fields[0], fields[1], fields[2]), false);
            }

            System.out.println("\nRestaurants: \n");
            rs.showRestaurants();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readClientsCsv(){
        try(var in = new BufferedReader(new FileReader("src/Data/clients.csv"))){
            String line;
            ClientService cl = ClientService.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.replaceAll(" ", "").split(",");
                cl.addClient(new Client(fields[0], fields[1], fields[2]), false);
            }

            System.out.println("\nClients: \n");
            cl.showClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDriversCsv(){
        try(var in = new BufferedReader(new FileReader("src/Data/drivers.csv"))){
            String line;
            DriverService dr = DriverService.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.replaceAll(" ", "").split(",");
                dr.addDriver(new Driver(fields[0], fields[1], fields[2]), false);
            }

            System.out.println("\nDrivers: \n");
            dr.showDrivers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCartCsv(){
        try(var in = new BufferedReader(new FileReader("src/Data/cart.csv"))){
            String line;
            CartService cart = CartService.getInstance();

            while ( (line = in.readLine()) != null) {
                String []fields = line.replaceAll(" ", "").split(",");
                cart.addToCart(fields[0], Integer.valueOf(fields[1]), false);
            }

            System.out.println("\nCart: \n");
            cart.showCart();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
