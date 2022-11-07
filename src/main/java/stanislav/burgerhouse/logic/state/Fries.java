package stanislav.burgerhouse.logic.state;

public class Fries {
    FriesState friesState;

    public void setFriesState(FriesState friesState) {
        this.friesState = friesState;
    }

    public void changeFriesState() {
        if (friesState instanceof LargeFriesState) {
            setFriesState(new LargeFriesState());
        } else if (friesState instanceof  SmallFriesState) {
            setFriesState(new SmallFriesState());
        }
    }

    public String addFries() {
        return friesState.addFries();
    }

    public int returnTotalSum(int totalSum) {
        return friesState.returnTotalSum(totalSum);
    }
}
