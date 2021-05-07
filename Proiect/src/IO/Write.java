package IO;

import Users.*;
import Menu.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Write {
    private static Write instance = null;

    public static Write getInstance() {
        if (instance == null)
            instance = new Write();
        return instance;
    }

    public static void writeRestaurantsCsv(Restaurant restaurant) {
        try (var out = new BufferedWriter(new FileWriter("src/Data/restaurant.csv", true))) {
            out.write(restaurant.getName() + ", " + restaurant.getEmail() + ", " + restaurant.getPhone() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeClientsCsv(Client client) {
        try (var out = new BufferedWriter(new FileWriter("src/Data/clients.csv", true))) {
            out.write(client.getName() + ", " + client.getEmail() + ", " + client.getPhone() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDriversCsv(Driver driver) {
        try (var out = new BufferedWriter(new FileWriter("src/Data/drivers.csv", true))) {
            out.write(driver.getName() + ", " + driver.getEmail() + ", " + driver.getPhone() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCartCsv(String item, Integer nr ) {
        try (var out = new BufferedWriter(new FileWriter("src/Data/cart.csv", true))) {
            out.write(item + ", " + nr + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAudit(String action) {
        try (var out = new BufferedWriter(new FileWriter("src/Data/audit.csv", true))) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            out.write(action + ", " + timestamp.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
