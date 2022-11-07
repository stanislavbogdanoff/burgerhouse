package stanislav.burgerhouse.logic.decorators;

import stanislav.burgerhouse.logic.burgers.Burger;

public class FrenchMustardDecorator extends BurgerDecorator {
    public FrenchMustardDecorator(Burger burger) {
        super(burger);
    }

    public String addBBQ(){
        return "with French Mustard Sauce with ";
    }

    @Override
    public String getBurger() {
        return super.getBurger() + addBBQ();
    }

    @Override
    public int price() {
        return super.price() + 150;
    }
}
