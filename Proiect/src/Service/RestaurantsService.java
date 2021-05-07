package Service;

import IO.Write;
import Users.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsService {
    private List<Restaurant> restaurantList;

    private static RestaurantsService instance = null;

    private RestaurantsService(){
        restaurantList = new ArrayList<>();
    }

    public static RestaurantsService getInstance(){
        if(instance == null) {
            instance = new RestaurantsService();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant, boolean ok){
        restaurantList.add(new Restaurant(restaurant));
        if(ok == true) {
            Write.writeRestaurantsCsv(restaurant);
            Write.writeAudit("Added restaurant");
        }
    }

    public void showRestaurants(){
        for(Restaurant r : restaurantList)
            System.out.println(r.toString());
    }

    public Restaurant getRestaurant(int i){
        return this.restaurantList.get(i);
    }

}
