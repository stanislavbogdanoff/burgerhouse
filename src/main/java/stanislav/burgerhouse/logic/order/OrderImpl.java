package stanislav.burgerhouse.logic.order;

public class OrderImpl implements OrderBuilder {
    OrderBuilderClass order = new OrderBuilderClass();

    @Override
    public OrderBuilder setPrice(int price) {
        order.price = price;
        return this;
    }

    @Override
    public OrderBuilder setBurger(String burger) {
        order.burger = burger;
        return this;
    }

    @Override
    public OrderBuilder setFries(String fries) {
        order.fries = fries;
        return this;
    }

    @Override
    public OrderBuilder setDrink(String drink) {
        order.drink = drink;
        return this;
    }

    @Override
    public OrderBuilderClass build() {
        return order;
    }

}
