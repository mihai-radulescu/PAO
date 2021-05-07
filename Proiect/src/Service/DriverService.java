package Service;

import IO.Write;
import Users.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverService {
    private List<Driver> driverList;

    private static DriverService instance = null;

    private DriverService(){
        driverList = new ArrayList<>();
    }

    public static DriverService getInstance() {
        if(instance == null) {
            instance = new DriverService();
        }
        return instance;
    }

    public void addDriver(Driver driver, boolean ok){
        driverList .add(new Driver(driver));
        if(ok == true) {
            Write.writeDriversCsv(driver);
            Write.writeAudit("Added driver");
        }
    }

    public void showDrivers(){
        for(Driver d : driverList)
            System.out.println(d.toString());
    }

    public Driver getDriver(int i){
        return this.driverList.get(i);
    }
}
