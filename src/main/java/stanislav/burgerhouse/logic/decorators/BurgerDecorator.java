package stanislav.burgerhouse.logic.decorators;

import stanislav.burgerhouse.logic.burgers.Burger;

public class BurgerDecorator implements Burger{
    Burger burger;

    public BurgerDecorator(Burger burger){
        this.burger = burger;
    }
    @Override
    public String getBurger() {
        return burger.getBurger();
    }

    @Override
    public int price() {
        return burger.price();
    }
}
