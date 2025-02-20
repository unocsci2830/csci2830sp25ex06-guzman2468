package pizza;

import java.util.ArrayList;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;

import pizza.MenuItem;

//potential error here
public class Pizza implements MenuItem{
    private PizzaCrust crust;
    private PizzaSauce sauce;
    private Integer numToppings;
    private ArrayList<PizzaTopping> toppings;
    private ArrayList<MenuItem> selectionList;

    //no arguemnt constructor to initialize, values with be set later

    public Pizza() {
        this.toppings = new ArrayList<PizzaTopping>();
        this.selectionList = new ArrayList<MenuItem>();
    }

    public Pizza(PizzaCrust crust, Integer numToppings, PizzaSauce sauce, ArrayList<PizzaTopping> toppings, ArrayList<MenuItem> selectionList) {
        this.crust = crust;
        this.numToppings = numToppings;
        this.sauce = sauce;
        this.toppings = new ArrayList<PizzaTopping>();
        this.selectionList = new ArrayList<MenuItem>();
    }

    public PizzaCrust getCrust() {
        return this.crust;
    }

    public PizzaSauce getSauce() {
        return this.sauce;
    }

    public Integer getNumToppings() {
        return this.numToppings;
    }

    public ArrayList<PizzaTopping> getToppings() {
        return this.toppings;
    }

    /*
     * addTopping appends a new toopping to the list
     * @param provide information about the parameter passed
     */
    public void addTopping(PizzaTopping topping) {
        toppings.add(topping);
        this.selectionList.add(topping);
    }

    public void setCrust(PizzaCrust crust) {
        this.crust = crust;
        this.selectionList.add(crust);
    }

    public void setSauce(PizzaSauce sauce) {
        this.sauce = sauce;
        this.selectionList.add(sauce);
    }

    public void setNumToppings(Integer numToppings) {
        this.numToppings = numToppings;
    }

    // @Override
    // public Double getPrice() {
    //     Double totalPrice = 0.0;
    //     totalPrice += this.crust.getPrice() + this.sauce.getPrice();
    //     for (PizzaTopping t: this.toppings) {
    //         totalPrice += t.getPrice();
    //     }
    //     return totalPrice;
    // }

    @Override
    public Double getPrice() {
        Double totalPrice = 0.0;
        for (MenuItem m : this.selectionList) {
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }
}
