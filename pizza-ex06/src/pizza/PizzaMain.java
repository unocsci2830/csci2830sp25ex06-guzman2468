package pizza;
import java.util.Scanner;
import pizza.crust.ThickCrust;
import pizza.crust.ThinCrust;
import pizza.sauce.AlfredoSauce;
import pizza.sauce.TomatoSauce;
import pizza.topping.BaconTopping;
import pizza.topping.CarrotTopping;
import pizza.topping.CheddarTopping;
import pizza.topping.GoudaTopping;
import pizza.topping.HamTopping;
import pizza.topping.LettuceTopping;
import pizza.topping.OliveTopping;
import pizza.topping.ParmesanTopping;
import pizza.topping.PeperoniTopping;
import pizza.topping.PizzaTopping;
import pizza.topping.SausageTopping;
import pizza.topping.SpinachTopping;
import pizza.topping.SwissTopping;






/* NOTE: CODE FROM EXERCISE3 WAS MODIFIED TO ADD 
 * ERROR CHECKING AS WELL AS THE EXTENDED FUNCTIONALITY ASKED
 * IN THE ASSIGNMENT
 */
public class PizzaMain {

    public static void displayInfo(Pizza pizza) {
        if (pizza.getCrust() != null) {
            System.out.println("Your crust: " + pizza.getCrust().toNiceString());
        }

        if (pizza.getSauce() != null) {
            System.out.println("Your sauce: " + pizza.getSauce().toString() + " costs: " + pizza.getSauce().getPrice());
        } 

        System.out.println("Your Toppings: ");
        if (pizza.getToppings().isEmpty()) {
            System.out.println("None, your pizza is plain.");
        } else {
            for (PizzaTopping s : pizza.getToppings()) {
                System.out.println(s.toString() + " costs: " + s.getPrice());
            }
        }

        System.out.println(pizza.getCrust().checkIntegrity());
        System.out.println("Total cost: " + pizza.getPrice());
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();

        System.out.println("What kind of crust would you like:");
        System.out.println("1. Thin crust");
        System.out.println("2. Thick crust");

        System.out.println("Your choice: ");
        Scanner in = new Scanner(System.in);

        while (true) { 
            String scanned = in.nextLine();

            if (scanned.equals("1")) {
                pizza.setCrust(new ThinCrust());
                break;
            } else if (scanned.equals("2")) {
                pizza.setCrust(new ThickCrust());

                System.out.println("Would you like your crust to be deep dish (y/n): ");

                while (true) {
                    String read = in.nextLine();

                    if ("y".equals(read.toLowerCase())) {
                        //in this case, we already know for sure that the crust is ThickCrust, so I will just cast the crust as ThickCrust to access the method inside the ThinkCrust class
                        ((ThickCrust) pizza.getCrust()).setIsDeepDish(true);
                        break;
                    }
                    else if ("n".equals(read.toLowerCase())) {
                        ((ThickCrust) pizza.getCrust()).setIsDeepDish(false);
                        break;
                    }
                    else {
                        System.out.println("Invalid choice, please enter Y for yes or N for no.");
                        continue;
                    }
                    //no need for else just continue on
                    }
                    break;
            }
                else {
                    System.out.println("Invalid choice, please choose 1 for Thin Crust or 2 for Thick Crust");
                }
            }
    


        System.out.println("What ingredient would you like your crust to be made out of: ");
        System.out.println("1. Flour");
        System.out.println("2. Cauliflower");

        String crustIngredient;
        while (true) {
            crustIngredient = in.nextLine();
            if ("1".equals(crustIngredient)) {
                pizza.getCrust().setCrustIngredient("Flour");
                break;
            } else if ("2".equals(crustIngredient)) {
                pizza.getCrust().setCrustIngredient("Cauliflower");
                break;
            } else {
                System.out.println("Invalid input, please choose 1 for Flour or 2 for Cauliflower.");
            }
        }

        System.out.println("What kind of sauce would you like:");
        System.out.println("1. Tomato Sauce");
        System.out.println("2. Alfredo Sauce");

        String sauceChosen;
        while (true) {
            sauceChosen = in.nextLine();
            if (sauceChosen.equals("1")) {
                pizza.setSauce(new TomatoSauce());
                break;
            } else if (sauceChosen.equals("2")) {
                pizza.setSauce(new AlfredoSauce());
                break;
            } else {
                System.out.println("Invalid input, please choose 1 for Tomato Sauce or 2 for Alfredo Sauce.");
            }
        }

        System.out.println("How many toppings: ");
        Integer numToppings;
        while (true) {
            if (in.hasNextInt()) {
                numToppings = in.nextInt();
                if (numToppings >= 0) {
                    pizza.setNumToppings(numToppings);
                    break;
                } else {
                    System.out.println("Please enter a number greater than or equal to 0.");
                }
            } else {
                System.out.println("Invalid input, please enter a valid number.");
                in.next(); // consume the invalid input
            }
        }

        System.out.println("1. Sausage");
        System.out.println("2. Peperoni");
        System.out.println("3. Ham");
        System.out.println("4. Bacon");
        System.out.println("5. Cheddar cheese");
        System.out.println("6. Gouda cheese");
        System.out.println("7. Parmesan cheese");
        System.out.println("8. Swiss cheese");
        System.out.println("9. Olives");
        System.out.println("10. Carrots");
        System.out.println("11. Spinach");
        System.out.println("12. Lettuce");

        Integer tracker = 0;
        while (tracker < pizza.getNumToppings()) {

            System.out.println("Your topping of choice: ");
            Integer toppingToAdd = in.nextInt();

            switch (toppingToAdd) {
                case 1:
                    SausageTopping sausage = new SausageTopping();
                    pizza.addTopping(sausage);
                    break;
                case 2:
                    PeperoniTopping peperoni = new PeperoniTopping();
                    pizza.addTopping(peperoni);
                    break;
                case 3:
                    HamTopping ham = new HamTopping();
                    pizza.addTopping(ham);
                    break;
                case 4:
                    BaconTopping bacon = new BaconTopping();
                    pizza.addTopping(bacon);
                    break;
                case 5:
                    CheddarTopping cheddar = new CheddarTopping();
                    pizza.addTopping(cheddar);
                    break;
                case 6:
                    GoudaTopping gouda = new GoudaTopping();
                    pizza.addTopping(gouda);
                    break;
                case 7:
                    ParmesanTopping parmesan = new ParmesanTopping();
                    pizza.addTopping(parmesan);
                    break;
                case 8:
                    SwissTopping swiss = new SwissTopping();
                    pizza.addTopping(swiss);
                    break;
                case 9:
                    OliveTopping olives = new OliveTopping();
                    pizza.addTopping(olives);
                    break;
                case 10:
                    CarrotTopping carrots = new CarrotTopping();
                    pizza.addTopping(carrots);
                    break;
                case 11:
                    SpinachTopping spinach = new SpinachTopping();
                    pizza.addTopping(spinach);
                    break;
                case 12:
                    LettuceTopping lettuce = new LettuceTopping();
                    pizza.addTopping(lettuce);
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a number between 1 and 12.");
                    continue;
            }

            tracker++;
        }

        //get us out of the menu displaying loop
        //no more code after this point to add toppings

        //back to main
        in.close();

        displayInfo(pizza);

    }


}
