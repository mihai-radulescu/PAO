package Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Menu.Order;

public class Client extends User{

    protected List<String> addresses = new ArrayList<>();
    protected List<Order> orders = new ArrayList<>();

    public Client(String name, String email, String phone) {
        super(name, email, phone);
    }

    public Client(Client client) {
        super(client);
    }

    @Override
    public String toString() {
        return "Client{" +
                "addresses=" + addresses +
                ", orders=" + orders +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Client client){
        return this.name.compareTo(client.getName());
    }*/
}
