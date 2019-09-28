package pl.marekhacieja.service;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.marekhacieja.model.Order;
import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.BookRepository;
import pl.marekhacieja.repository.OrderRepository;
import pl.marekhacieja.repository.UserRepository;

import java.util.Optional;

@Service
public class AccountService {
    private OrderRepository orderRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public AccountService(OrderRepository orderRepository, BookRepository bookRepository, UserRepository userRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    public void addAttributeOrders(Model model) {
        model.addAttribute("orders",  orderRepository.findAllByUserId(getCurrentUserId()));
    }

    private Long getCurrentUserId() {
        userService.getLoggedUserName();
        User user = userRepository.findByUsername(userService.getLoggedUserName());
        Long userId = user.getId();
        return userId;
    }
}
