package pizza.crust;
import pizza.MenuItem;

public abstract class PizzaCrust implements MenuItem{
    protected String crustIngredient;

    @Override
    public abstract String toString();

    public String toNiceString() {
        String description = toString();

        if (crustIngredient != null) {
            description += " made with " + crustIngredient + " costs: " + this.getPrice();
        } 
        return description;
    }

    public String getCrustIngredient() {
        return crustIngredient;
    }

    public void setCrustIngredient(String crustIngredient) {
        this.crustIngredient = crustIngredient;
    }

    /*  this is checking if the current instance of PizzaCrust
        is of ThickCrust type (a child of PizzaCrust), if so we must check to see if it is made
        of cauliflower, so that we can display the warning message
    */
    public String checkIntegrity() {
        // if the current PizzaCrust instance is of the ThickCrust type (child of PizzaCrust)
        // then check if it is made of cauliflower, if so display warning message
        if (this instanceof ThickCrust && "cauliflower".equalsIgnoreCase(crustIngredient)) {
            return "Handle carefully, the cauliflower crust may fall apart.";
        }
        return "";
    }

    @Override
    public Double getPrice() {
        return 3.0;
    }
}
