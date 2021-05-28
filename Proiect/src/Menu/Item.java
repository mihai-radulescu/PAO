package Menu;

import java.util.Objects;

public class Item {

    protected Integer id = null;
    protected String itemName;
    protected String description;
    protected Double price;
    protected String category;

    public Item(Integer id, String itemName, String description, Double price, String category) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Item(Item item) {
        id = this.getId();
        itemName = this.getItemName();
        description = this.getDescription();
        price = this.getPrice();
        category = this.getCategory();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}