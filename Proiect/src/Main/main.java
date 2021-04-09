package Main;

import Service.UserService;
import Users.Client;
import Users.Restaurant;
import Menu.Menu;
import Menu.Item;

public class main {

    public static void main(String[] args) {
        System.out.println("Hey user!");

        UserService us = UserService.getInstance();
        us.addClient(new Client("Mihai", "mail", "013534"));
        us.showClients();

        Client c =  us.getClient(0);
        c.setName("Mihai-Alexandru");
        System.out.println(c.toString());

        Restaurant res = new Restaurant("KFC", "mail", "05648654");
        Menu menu = res.getMenu();
        menu.addMainCourse(new Item("Chicken Wings", "description", 12.50, "mainCourse"));

        res.showMenu();
    }

}
