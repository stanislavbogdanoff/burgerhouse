package stanislav.burgerhouse.logic.factories;

import stanislav.burgerhouse.logic.burgers.*;
import stanislav.burgerhouse.logic.decorators.*;
import stanislav.burgerhouse.logic.strategy.*;

public abstract class BurgerFactory {

    private final int cheeseburgerPattiePrice;
    private final int hamburgerPattiePrice;
    private final int chickenFilletBurgerPattiePrice;
    private final String restaurantName;
    public int totalSum = 0;
    public String burgerString = "burger string";

    protected BurgerFactory(int cheeseburgerPattiePrice, int hamburgerPattiePrice, int chickenFilletBurgerPattiePrice, String restaurantName) {
        this.cheeseburgerPattiePrice = cheeseburgerPattiePrice;
        this.hamburgerPattiePrice = hamburgerPattiePrice;
        this.chickenFilletBurgerPattiePrice = chickenFilletBurgerPattiePrice;
        this.restaurantName = restaurantName;
    }

    public int calculateSum(int pattiePrice, int pattiesChoice) {
        return pattiePrice * pattiesChoice;
    }

    public String pattiesString(int pattiesChoice) {
        String pattiesNumString;
        switch(pattiesChoice) {
            case 1 -> pattiesNumString = pattiesChoice + " pattie ";
            default -> pattiesNumString = pattiesChoice + " patties ";
        }
        return pattiesNumString;
    }

    public String generateBurgerString(String initialBurgerString, int pattiesChoice, int totalSum) {
        return initialBurgerString + pattiesString(pattiesChoice);
    }

    Strategy cheeseburgerStrategy = new CheeseburgerStrategy();
    Strategy hamburgerStrategy = new HamburgerStrategy();
    Strategy chickenFilletStrategy = new ChickenFilletStrategy();

    public String makeBurger(String customerName, int pattiesChoice, String burgerChoice, String sauceChoice) {
        String response = "";
        switch (burgerChoice) {
            case "cheeseburger" -> {
                response = cheeseburgerStrategy.applyBurgerChoice(pattiesChoice, sauceChoice, cheeseburgerPattiePrice);
                totalSum = cheeseburgerStrategy.returnTotalSum();
            }
            case "chicken" -> {
                response = chickenFilletStrategy.applyBurgerChoice(pattiesChoice, sauceChoice, chickenFilletBurgerPattiePrice);
                totalSum = chickenFilletStrategy.returnTotalSum();
            }
            case "hamburger" -> {
                response = hamburgerStrategy.applyBurgerChoice(pattiesChoice, sauceChoice, hamburgerPattiePrice);
                totalSum = hamburgerStrategy.returnTotalSum();
            }
        }
        return response + restaurantName;
    }

}
