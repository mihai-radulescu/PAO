package Service;

import IO.Write;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CartService {
    private HashMap<String, Integer> cart;

    private static CartService instance = null;

    private CartService(){
        cart = new HashMap<>();
    }

    public static CartService getInstance() {
        if(instance == null) {
            instance = new CartService();
        }
        return instance;
    }

    public void addToCart(String item, Integer nr, boolean ok){
        cart.put(item, nr);
        if(ok == true){
            Write.writeCartCsv(item, nr);
            Write.writeAudit("Added to cart");
        }
    }

    public void showCart(){
        Set set = cart.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            HashMap.Entry mentry = (HashMap.Entry)iterator.next();
            System.out.println(mentry.getKey() + " " + mentry.getValue());
        }

    }
}
