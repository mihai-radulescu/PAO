package Main;

import DataBase.CRUD;
import DataBase.DBConnection;
import Menu.Item;
import Users.Client;
import Users.Restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void functionClient(){
        Scanner in = new Scanner(System.in);
        System.out.println("Name:");
        String username = in.nextLine();

        ResultSet data = CRUD.clientLogIn(username);

        try {
            Integer id = data.getInt("client_id");
            String name = data.getString("name");
            String email = data.getString("email");
            String phone = data.getString("phone");
            String reg = data.getString("registration");
            String add = data.getString("address");

            Client cl = new Client(name, email, phone);
            System.out.println("Id " + id + " " + cl.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while(true){
            System.out.println("Pentru a inchide scrie \"exit\"");
            System.out.println("Foloseste nr-ul de langa un obiect pentru a selecta");
            System.out.println("1) Arata toate restaurantele");
            System.out.println("2) Arata meniul unui restaurant");

            String inputString = in.nextLine();

            switch (inputString){
                case("exit"):{
                    return;
                }
                case("1"):{
                    CRUD.showRestaurant();
                    break;
                }
                case("2"):{
                    System.out.println("Care este indicele restaurantului?");
                    Integer restaurant_id = in.nextInt();
                    in.nextLine();
                    CRUD.showMenu(restaurant_id);
                    break;
                }
                default:{
                    System.out.println("Optiune invalida");
                }
            }
        }
    }

    public static void functionRestaurant() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Name:");
        String username = in.nextLine();

        ResultSet data = CRUD.restaurantLogIn(username);

        try {
            Integer id = data.getInt("restaurant_id");
            String name = data.getString("name");
            String email = data.getString("email");
            String phone = data.getString("phone");
            String reg = data.getString("registration");
            String add = data.getString("address");

            Restaurant rs = new Restaurant(name, email, phone);
            System.out.println("Id " + id + " " + rs.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while(true){
            System.out.println("Pentru a inchide scrie \"exit\"");
            System.out.println("Foloseste nr-ul de langa un obiect pentru a selecta");
            System.out.println("1) Arata meniul");
            System.out.println("2) Sterge un item din meniu");
            System.out.println("3) Adauga un item in meniu");
            System.out.println("4) Modifica un item din meniu");

            String inputString = in.nextLine();

            switch (inputString){
                case("exit"):{
                    return;
                }
                case("1"):{
                    try{
                        Integer id = data.getInt("restaurant_id");
                        CRUD.showMenu(id);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                }
                case("2"):{
                    System.out.println("Item id:");
                    Integer itemId = in.nextInt();
                    in.nextLine();

                    Integer restaurant_id = data.getInt("restaurant_id");

                    CRUD.deleteFromMenu(itemId, restaurant_id);

                    CRUD.deleteItem(itemId);

                    break;
                }
                case("3"):{
                    Integer restaurant_id = data.getInt("restaurant_id");

                    System.out.println("Item name: ");
                    String name = in.nextLine();

                    System.out.println("Item description: ");
                    String desc = in.nextLine();

                    System.out.println("Item price is: ");
                    Double price = in.nextDouble();
                    in.nextLine();

                    System.out.println("Item category: ");
                    String cat = in.nextLine();

                    Item i = new Item(0, name, desc, price, cat);

                    CRUD.insertItem(i, restaurant_id);

                    break;
                }
                case("4"):{
                    System.out.println("Item id:");
                    Integer itemId = in.nextInt();
                    in.nextLine();

                    ResultSet item = CRUD.findItem(itemId);

                    Item i = new Item(
                            item.getInt("item_id"),
                            item.getString("name"),
                            item.getString("description"),
                            item.getDouble("price"),
                            item.getString("category")
                    );

                    CRUD.updateItem(i);
                    break;
                }
                default:{
                    System.out.println("Optiune invalida");
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Hey user!");

        DBConnection dbc = DBConnection.getInstance();

        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("Pentru a inchide scrie \"exit\"");
            System.out.println("Alege rolul:\n1)Client \n2)Proprietar restaurant");
            String inputString = in.nextLine();
            switch (inputString){
                case("exit"):{
                    DBConnection.getInstance().closeConnection();
                    return;
                }
                case("1"):{
                    functionClient();
                    break;
                }
                case("2"):{
                    functionRestaurant();
                    break;
                }
                default:{
                    System.out.println("Optiune invalida");
                }
            }
        }

/*
        UserService us = UserService.getInstance();
        RestaurantsService rs = RestaurantsService.getInstance();
        ClientService cl = ClientService.getInstance();
        DriverService dr = DriverService.getInstance();
        CartService cart = CartService.getInstance();

        Read.readRestaurantsCsv();
        //rs.addRestaurant(new Restaurant("Spartan", "mail", "0561354"), true);

        Read.readClientsCsv();
        cl.addClient(new Client("Simona", "a@mail3.com", "54684"), true);

        Read.readDriversCsv();
        dr.addDriver(new Driver("Razvan", "test@mail.ro", "075984"), true);

        Read.readCartCsv()
        cart.addToCart("Limonada", 5, true);
        cart.showCart();
*/
    }
}
