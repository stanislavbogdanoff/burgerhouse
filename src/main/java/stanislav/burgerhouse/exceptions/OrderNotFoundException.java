package stanislav.burgerhouse.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Could not find an order with id " + id);
    }

}
