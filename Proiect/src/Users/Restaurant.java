package Users;

import Menu.Menu;
import Menu.Item;

import java.util.List;

public class Restaurant extends User {

    protected String address;
    protected String program;

    public Restaurant(String name, String email, String phone) {
        super(name, email, phone);
    }

    public Restaurant(Restaurant restaurant) {
        super(restaurant);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "address='" + address + '\'' +
                ", program='" + program + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

}
