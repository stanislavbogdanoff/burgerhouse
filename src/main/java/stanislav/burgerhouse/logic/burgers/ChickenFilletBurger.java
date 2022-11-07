package stanislav.burgerhouse.logic.burgers;

public class ChickenFilletBurger implements Burger{
    @Override
    public String getBurger() {
        return "Chicken Fillet ";
    }

    @Override
    public int price() {
        return 500;
    }
}
