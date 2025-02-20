package pizza.sauce;


import pizza.MenuItem;

public abstract class PizzaSauce implements MenuItem {
    @Override
    public abstract String toString();

    public String toNiceString() {
        return "The sauce you chose, " + toString() + ", is delicious";
    }
    //genarlized case, go into each sauce and do it
    @Override
    public Double getPrice() {
        return 0.25;
    }
}
