package stanislav.burgerhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stanislav.burgerhouse.exceptions.OrderNotFoundException;
import stanislav.burgerhouse.logic.OrderGenerator;
import stanislav.burgerhouse.logic.order.OrderBuilderClass;
import stanislav.burgerhouse.models.Order;
import stanislav.burgerhouse.repository.OrderRepository;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order")
    Order newOrder(@RequestBody Order newOrder) {
        OrderBuilderClass orderDetails = new OrderGenerator().burgerConstructor(
                newOrder.getCustomerName(),
                newOrder.getBurgerType(),
                newOrder.getPattiesNumber(),
                newOrder.getSauce(),
                newOrder.getRestaurant(),
                newOrder.getFriesChoice(),
                newOrder.getDrinkChoice()
        );
        newOrder.setPrice(orderDetails.returnPrice());
        newOrder.setBurgerDescription(orderDetails.returnBurgerDescription());
        return orderRepository.save(newOrder);
    }

    @GetMapping("/orders")
    List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    Order getOrderById (@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PutMapping("/order/{id}")
    Order updateOrder(@RequestBody Order updatedOrder, @PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setBurgerType(updatedOrder.getBurgerType());
                    order.setPattiesNumber(updatedOrder.getPattiesNumber());
                    order.setSauce(updatedOrder.getSauce());
                    order.setRestaurant(updatedOrder.getRestaurant());
                    order.setPrice(updatedOrder.getPrice());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @DeleteMapping("/order/{id}")
    Long deleteOrder(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        } else {
            orderRepository.deleteById(id);
            return id;
        }
    }

}
