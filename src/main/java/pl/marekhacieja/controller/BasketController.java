package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marekhacieja.service.BookService;
import pl.marekhacieja.service.OrderService;
import pl.marekhacieja.service.UserService;

@Controller
public class BasketController {
    private BookService bookService;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public BasketController(BookService bookService, OrderService orderService, UserService userService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/orders")
    public String addOrder() {
        orderService.addOrder(getLoggedUserName());
        return "redirect:/";
    }

    @GetMapping("/orders/{id}")
    public String removeBook(@PathVariable Long id, Model model) {
        orderService.deleteBookFromOrder(id, model);
        return "message";
    }

    private String getLoggedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }
}
