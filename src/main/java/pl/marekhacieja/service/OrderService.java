package pl.marekhacieja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.marekhacieja.common.Message;
import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.Order;
import pl.marekhacieja.repository.BookRepository;
import pl.marekhacieja.repository.OrderRepository;
import pl.marekhacieja.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private ClientOrder clientOrder;

    @Autowired
    public OrderService(OrderRepository orderRepository, BookRepository bookRepository, UserRepository userRepository, ClientOrder clientOrder) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.clientOrder = clientOrder;
    }

    public void addBookToOrder(Long id, Model model) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(clientOrder::add);
        if (book.isPresent()) {
            model.addAttribute("message", new Message("Success", book.get().getTitle() + " was added to the order"));
        } else {
            model.addAttribute("message", new Message("failed", book.get().getTitle() + " was not added to the order"));
        }
    }

    public void addOrder(String username) {
        if (!clientOrder.getOrder().getBooks().isEmpty()) {
            Order order = clientOrder.getOrder();
            order.setUser(userRepository.findByUsername(username));
            order.setDateIssued(getTime());
            orderRepository.save(order);
            clientOrder.clear();
        }
    }

    private String getTime() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }


    public void deleteBookFromOrder(Long id, Model model) {
        //TODO fix
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(clientOrder::delete);
        if (book.isPresent()) {
            model.addAttribute("message", new Message("Done", book.get().getTitle() + " was deleted from order"));
        } else {
            model.addAttribute("message", new Message("Failed", book.get().getTitle() + " was not deleted from order"));
        }
    }

    public void addAttributeSum(Model model) {
        model.addAttribute("sum", clientOrder
                .getOrder()
                .getBooks().stream()
                .mapToDouble(Book::getPrice)
                .sum());
    }

    public void addAttributeOrder(Model model) {
        model.addAttribute("order", clientOrder.getOrder());
    }
}
