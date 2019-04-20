package pl.marekhacieja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.BookRepository;
import pl.marekhacieja.repository.OrderRepository;
import pl.marekhacieja.repository.UserRepository;

import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void addBookToOrder(Long id, String username){
        //TODO
//        Optional<Book> book = bookRepository.findById(id);
//        Optional<User> user = userRepository.findByUsername(username);
    }


}
