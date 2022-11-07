package stanislav.burgerhouse.logic.burgers;

public class Hamburger implements Burger{
    @Override
    public String getBurger() {
        return "Hamburger ";
    }

    @Override
    public int price() {
        return 480;
    }
}
