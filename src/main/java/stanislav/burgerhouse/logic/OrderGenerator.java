package stanislav.burgerhouse.logic;

import stanislav.burgerhouse.logic.factories.*;
import stanislav.burgerhouse.logic.order.*;
import stanislav.burgerhouse.logic.state.Fries;
import stanislav.burgerhouse.logic.state.FriesState;
import stanislav.burgerhouse.logic.state.LargeFriesState;
import stanislav.burgerhouse.logic.state.SmallFriesState;

public class OrderGenerator {

    public static OrderBuilderClass burgerConstructor(
            String customerName,
            String burgerChoice,
            int pattiesChoice,
            String sauceChoice,
            String restaurantChoice,
            String friesChoice,
            String drinkChoice
    ) {

        String burgerDescription = "";
        BkBurgerFactory bkBurgerFactory = new BkBurgerFactory();
        MdBurgerFactory mdBurgerFactory = new MdBurgerFactory();
        int totalSum = 0;

        switch (restaurantChoice) {
            case "bk" -> {
                burgerDescription = bkBurgerFactory
                        .makeBurger(
                                customerName,
                                pattiesChoice,
                                burgerChoice,
                                sauceChoice
                        );
                totalSum = bkBurgerFactory.totalSum;
            }
            case "md" -> {
                burgerDescription = mdBurgerFactory
                        .makeBurger(
                                customerName,
                                pattiesChoice,
                                burgerChoice,
                                sauceChoice
                        );
                totalSum = mdBurgerFactory.totalSum;
            }
        }

        FriesState smallFriesState = new SmallFriesState();
        FriesState largeFriesState = new LargeFriesState();
        Fries fries = new Fries();

        switch (friesChoice) {
            case "large" -> {
                fries.setFriesState(largeFriesState);
                friesChoice = fries.addFries();
                totalSum = fries.returnTotalSum(totalSum);
            }
            case "small" -> {
                fries.setFriesState(smallFriesState);
                friesChoice = fries.addFries();
                totalSum = fries.returnTotalSum(totalSum);
            }
            default -> friesChoice = "";
        }

        switch (drinkChoice) {
            case "pepsi" -> {
                drinkChoice = ", Pepsi 1L";
                totalSum += 300;
            }
            case "cola" -> {
                drinkChoice = ", Coca-Cola 1L";
                totalSum += 320;
            }
            default -> drinkChoice = "";
        }

        OrderBuilderClass order = new OrderImpl()
                .setPrice(totalSum)
                .setBurger(burgerDescription)
                .setFries(friesChoice)
                .setDrink(drinkChoice)
                .build();

        return order;
    }

}
