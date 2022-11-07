package stanislav.burgerhouse.logic.state;

public class LargeFriesState implements FriesState {
    @Override
    public String addFries() {
        return ", Large Fries";
    }
    @Override
    public int returnTotalSum(int totalSum) {
        int newTotalSum = totalSum + 500;
        return newTotalSum;
    }
}
