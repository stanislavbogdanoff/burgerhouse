package stanislav.burgerhouse.logic.order;

public interface OrderBuilder {
    OrderBuilder setPrice(int price);
    OrderBuilder setBurger(String burger);
    OrderBuilder setFries(String fries);
    OrderBuilder setDrink(String drink);

    OrderBuilderClass build();
}
