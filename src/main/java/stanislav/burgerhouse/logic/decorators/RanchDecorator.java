package stanislav.burgerhouse.logic.decorators;

import stanislav.burgerhouse.logic.burgers.Burger;

public class RanchDecorator extends BurgerDecorator {
    public RanchDecorator(Burger burger) {
        super(burger);
    }

    public String addRanch(){
        return "with Ranch Sauce with ";
    }

    @Override
    public String getBurger() {
        return super.getBurger() + addRanch();
    }

    @Override
    public int price() {
        return super.price() + 250;
    }
}