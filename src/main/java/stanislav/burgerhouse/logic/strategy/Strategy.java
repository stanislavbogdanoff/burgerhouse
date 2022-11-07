package stanislav.burgerhouse.logic.strategy;

public interface Strategy {
    public int calculateSum(int pattiePrice, int pattiesChoice);

    public String pattiesString(int pattiesChoice);

    public String generateBurgerString(String initialBurgerString, int pattiesChoice, int totalSum);

    public String applyBurgerChoice(int pattiesChoice, String sauceChoice, int cheeseburgerPattiePrice);

    public int returnTotalSum();
}
