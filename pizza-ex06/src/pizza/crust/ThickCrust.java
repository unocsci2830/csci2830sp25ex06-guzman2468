package pizza.crust;
public class ThickCrust extends PizzaCrust {
    private Boolean isDeepDish = false; // default value

    @Override
    public String toString() {
        return "Thick Crust";
    }

    @Override
    public String toNiceString() {
        String description = toString();

        if (getCrustIngredient() != null) {
            description += " made with " + getCrustIngredient() + " costs: " + getPrice();
        } 

        if (isDeepDish) {
            description += " and is deep dish.";
        }
        return description;
    }

    public Boolean getIsDeepDish() {
        return isDeepDish;
    }

    public void setIsDeepDish(Boolean isDeepDish) {
        this.isDeepDish = isDeepDish;
    }
}
