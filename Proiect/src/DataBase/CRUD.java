package DataBase;

import Menu.Item;
import Users.Client;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
    private static Connection conn = DBConnection.getInstance().getConnection();
    static Statement statement = null;

    public static void addToMenu(Integer restaurant_id, Integer item_id){
        try {
            statement = conn.createStatement();

            String query = "insert into menu (restaurant_id, item_id) values (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, restaurant_id);
            stmt.setInt(2, item_id);


            if(stmt.executeUpdate() > 0)
                System.out.println("Item added to menu");


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
    }

    public static ResultSet findItem(Integer id){
        try{
            statement = conn.createStatement();

            String sql = "select * from item where item_id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet data = stmt.executeQuery();
            if(data.next()) {
                return data;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
            finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
            return null;
    }

    public static void showItems(){
        try {
            statement = conn.createStatement();

            //String query = "insert into item values (null, 'Pizza', 'e o Pizza ', '18.99', 'main')";
            //statement.executeUpdate(query);

            String sql = "select * from item";
            ResultSet data = statement.executeQuery(sql);
            while(data.next())
                System.out.println(data.getInt("item_id") + " " + data.getString("name") + " "
                        + data.getDouble("price") + " " + data.getString("description"));

            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
    }

    public static void insertItem(Item item, Integer restaurant_id){
        try {
            Integer id = item.getId();
            String name = item.getItemName();
            String desc = item.getDescription();
            Double price = item.getPrice();
            String cat = item.getCategory();

            statement = conn.createStatement();

            String query = "insert into item (item_id, name, description, price, category) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, desc);
            stmt.setDouble(4, price);
            stmt.setString(5, cat);

            if(stmt.executeUpdate() > 0){
                System.out.println("Item added");
                ResultSet ps = stmt.getGeneratedKeys();
                if(ps.next()) {
                    //System.out.println(ps.getInt(1));
                    Integer item_id = ps.getInt(1);
                    CRUD.addToMenu(restaurant_id, item_id);
                }
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
    }

    public static void updateItem(Item item){
        System.out.println(item.toString() + "\n" + "Rewrite to keep the same:");

        Integer id = item.getId();
        String name = item.getItemName();
        String desc = item.getDescription();
        Double price = item.getPrice();
        String cat = item.getCategory();

        Scanner in = new Scanner(System.in);

        System.out.println("Item name is " + name + ": ");
        name = in.nextLine();

        System.out.println("Item description is " + desc + ": ");
        desc = in.nextLine();

        System.out.println("Item price is " + price + ": ");
        price = in.nextDouble();
        in.nextLine();

        System.out.println("Item category is " + cat + ": ");
        cat = in.nextLine();

        try {
            statement = conn.createStatement();

            String query = "update item set name = ?, description = ?, price = ?, category = ? where item_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setString(1, name);
            stmt.setString(2, desc);
            stmt.setDouble(3, price);
            stmt.setString(4, cat);
            stmt.setInt(5, id);

            if(stmt.executeUpdate() > 0){
                System.out.println("Item updated");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}

            item.setItemName(name);
            item.setCategory(cat);
            item.setDescription(desc);
            item.setPrice(price);
        }

    }

    public static void deleteItem(Integer id){
        try {
            statement = conn.createStatement();

            String query = "delete from Item where item_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            if(stmt.executeUpdate() > 0){
                System.out.println("Item deleted");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
    }

    public static void showRestaurant(){
        try {
            statement = conn.createStatement();

            String sql = "select * from restaurant";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet data = stmt.executeQuery();
            while(data.next())
                System.out.println(data.getInt("restaurant_id") + " " + data.getString("name") + " "
                        + data.getString("email") + " " + data.getString("phone"));

            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }

    }

    public static ResultSet restaurantLogIn(String name){
        try {
            statement = conn.createStatement();

            String sql = "select * from restaurant where name = ? or email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setString(2, name);

            ResultSet data = stmt.executeQuery();

            if(data.next())
                return data;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
        return null;
    }

    public static void showMenu(Integer restaurant_id){
        try {
            statement = conn.createStatement();

            String sql = "SELECT * FROM `item` WHERE item_id in (SELECT p.item_id from `menu` p where p.restaurant_id = ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, restaurant_id);

            ResultSet data = stmt.executeQuery();
            while(data.next())
                System.out.println(data.getInt("item_id") + " " + data.getString("name") + " "
                        + data.getDouble("price") + " " + data.getString("description") + " " + data.getString("category"));


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
    }

    public static ResultSet clientLogIn(String name){
        try {
            statement = conn.createStatement();

            String sql = "select * from client where name = ? or email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setString(2, name);

            ResultSet data = stmt.executeQuery();
            Integer id = 0;
            if(data.next()) {
                return data;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
        return null;
    }

    public static void deleteFromMenu(Integer item_id, Integer restaurant_id){
        try {
            statement = conn.createStatement();

            String query = "delete from menu where item_id = ? and restaurant_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, item_id);
            stmt.setInt(2,restaurant_id);

            if(stmt.executeUpdate() > 0){
                System.out.println("Item deleted");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException sqle) {}
        }
    }
}

