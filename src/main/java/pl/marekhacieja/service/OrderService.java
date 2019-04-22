package pl.marekhacieja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.Order;
import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.BookRepository;
import pl.marekhacieja.repository.OrderRepository;
import pl.marekhacieja.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        Order order = new Order();
        List<Book> books = new ArrayList<>();
        String date = getTime();
        order.setDateIssued(date);
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(books::add);
        order.getBooks().addAll(books);
        User user = userRepository.findByUsername(username);
        order.setUser(user);
        //TODO every added book = new order, change it to 1 order-many books
        orderRepository.save(order);
    }

    private String getTime() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }


    public void deleteBookFromOrder(Long id, String loggedUserName) {
        //TODO
    }

    public List<Book> getBooksFromOrder(String username) {
        List<Book> myBooks = new ArrayList<>();
        //TODO
        return myBooks;
    }
}
