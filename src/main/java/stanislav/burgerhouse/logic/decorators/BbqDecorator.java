package stanislav.burgerhouse.logic.decorators;

import stanislav.burgerhouse.logic.burgers.Burger;

public class BbqDecorator extends BurgerDecorator {
    public BbqDecorator(Burger burger) {
        super(burger);
    }

    public String addBbq(){
        return "with BBQ Sauce with ";
    }

    @Override
    public String getBurger() {
        return super.getBurger() + addBbq();
    }

    @Override
    public int price() {
        return super.price() + 150;
    }
}
