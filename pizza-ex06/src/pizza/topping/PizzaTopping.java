package pizza.topping;

import pizza.MenuItem;

public abstract class PizzaTopping implements MenuItem{
    public abstract String toString();

    public String toNiceString() {
        return "The topping you chose, " + toString() + ", is delicious";
    }

    @Override
    public Double getPrice() {
        return 1.50;
    }
}