package stanislav.burgerhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stanislav.burgerhouse.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
