package Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    protected List<Item> mainCourse;
    private List<Item> sideDish;
    private List<Item> drinks;
    private List<Item> deserts;

    public Menu(List<Item> mainCourse, List<Item> sideDish, List<Item> drinks, List<Item> deserts) {
        this.mainCourse = mainCourse;
        this.sideDish = sideDish;
        this.drinks = drinks;
        this.deserts = deserts;
    }

    public Menu(){
        this.mainCourse = new ArrayList<>();
        this.sideDish = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.deserts = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Menu{" +
                "mainCourse=" + mainCourse +
                ", sideDish=" + sideDish +
                ", drinks=" + drinks +
                ", deserts=" + deserts +
                '}';
    }

    ///Getters and Setters
    public List<Item> getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(List<Item> mainCourse) {
        this.mainCourse = mainCourse;
    }

    public List<Item> getSideDish() {
        return sideDish;
    }

    public void setSideDish(List<Item> sideDish) {
        this.sideDish = sideDish;
    }

    public List<Item> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Item> drinks) {
        this.drinks = drinks;
    }

    public List<Item> getDeserts() {
        return deserts;
    }

    public void setDeserts(List<Item> deserts) {
        this.deserts = deserts;
    }

    ///Menu methods

    public void addMainCourse(Item item){
        mainCourse = this.getMainCourse();
        mainCourse.add(new Item(item));
    }
}

