package pl.marekhacieja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.Order;
import pl.marekhacieja.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Book> findByUser(User user);
}