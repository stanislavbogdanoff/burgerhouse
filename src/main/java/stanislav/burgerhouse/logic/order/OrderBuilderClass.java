package stanislav.burgerhouse.logic.order;

public class OrderBuilderClass {

    int price = 0;
    String burger = "";
    String fries = "";
    String drink = "";

    public String returnOrder() {
        return burger + fries + drink + " for " + price + " KZT";
    }

    public int returnPrice() {
        return price;
    }
    public String returnBurgerDescription() {
        return burger;
    }

}
