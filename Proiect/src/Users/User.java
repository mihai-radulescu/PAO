package Users;

import java.time.LocalDate;

public class User {

    protected String name;
    protected String email;
    protected String phone;
    protected LocalDate registrationDate;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = LocalDate.now();
    }

    public User(Client client) {
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }

    public User(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.email = restaurant.getEmail();
        this.phone = restaurant.getPhone();
    }

    public User(Driver driver) {
        this.name = driver.getName();
        this.email = driver.getEmail();
        this.phone = driver.getPhone();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
