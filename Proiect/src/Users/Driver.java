package Users;

import Menu.Order;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User{

    private List<Order> orders = new ArrayList<>();
    private boolean active = false;

    public Driver(String name, String email, String phone) {
        super(name, email, phone);
    }

    public Driver(Driver driver) {
        super(driver);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "orders=" + orders +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
