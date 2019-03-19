package pl.marekhacieja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marekhacieja.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}