package stanislav.burgerhouse.logic.burgers;

public class DoubleCheeseburger implements Burger{
    @Override
    public String getBurger() {
        return "Cheeseburger ";
    }

    @Override
    public int price() {
        return 520;
    }
}
