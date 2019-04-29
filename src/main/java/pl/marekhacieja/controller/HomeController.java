package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.marekhacieja.service.BookService;
import pl.marekhacieja.service.OrderService;

@Controller
public class HomeController {

    private BookService bookService;
    private OrderService orderService;

    @Autowired
    public HomeController(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home(Model model) {
        orderService.addAttributeOrder(model);
        orderService.addAttributeSum(model);
        return "home";
    }

    @GetMapping("/books")
    public String allBooks(Model model) {
        bookService.addAttributeBooks(model);
        return "books";
    }

    @PostMapping("/books/{id}")
    public String addBookToOrder(@PathVariable Long id, Model model) {
        orderService.addBookToOrder(id, model);
        return "message";
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