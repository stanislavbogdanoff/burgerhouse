package stanislav.burgerhouse.logic.state;

public class SmallFriesState implements FriesState {
    @Override
    public String addFries() {
        return ", Small Fries";
    }
    @Override
    public int returnTotalSum(int totalSum) {
        int newTotalSum = totalSum + 300;
        return newTotalSum;
    }
}
