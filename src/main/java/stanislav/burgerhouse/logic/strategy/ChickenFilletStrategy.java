package stanislav.burgerhouse.logic.strategy;

import stanislav.burgerhouse.logic.burgers.Burger;
import stanislav.burgerhouse.logic.burgers.ChickenFilletBurger;
import stanislav.burgerhouse.logic.decorators.BbqDecorator;
import stanislav.burgerhouse.logic.decorators.FrenchMustardDecorator;
import stanislav.burgerhouse.logic.decorators.RanchDecorator;

public class ChickenFilletStrategy implements Strategy {
    int totalSum = 0;
    String burgerString = "";
    @Override
    public int calculateSum(int pattiePrice, int pattiesChoice) {
        return pattiePrice * pattiesChoice;
    }

    @Override
    public String pattiesString(int pattiesChoice) {
        String pattiesNumString;
        switch(pattiesChoice) {
            case 1 -> pattiesNumString = pattiesChoice + " pattie ";
            default -> pattiesNumString = pattiesChoice + " patties ";
        }
        return pattiesNumString;
    }

    @Override
    public String generateBurgerString(String initialBurgerString, int pattiesChoice, int totalSum) {
        return initialBurgerString + pattiesString(pattiesChoice);
    }

    @Override
    public String applyBurgerChoice(int pattiesChoice, String sauceChoice, int chickenFilletBurgerPattiePrice) {

        int pattiesPrice = calculateSum(chickenFilletBurgerPattiePrice, pattiesChoice);

        switch (sauceChoice) {
            case "ranch" -> {
                Burger burger = new RanchDecorator(new ChickenFilletBurger());
                totalSum = pattiesPrice + burger.price();
                burgerString = generateBurgerString(burger.getBurger(), pattiesChoice, totalSum);
            }
            case "bbq" -> {
                Burger burger = new BbqDecorator(new ChickenFilletBurger());
                totalSum = pattiesPrice + burger.price();
                burgerString = generateBurgerString(burger.getBurger(), pattiesChoice, totalSum);
            }
            case "french" -> {
                Burger burger = new FrenchMustardDecorator(new ChickenFilletBurger());
                totalSum = pattiesPrice + burger.price();
                burgerString = generateBurgerString(burger.getBurger(), pattiesChoice, totalSum);
            }
        }

        return burgerString;
    }

    @Override
    public int returnTotalSum() {
        return totalSum;
    }

}
