package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.marekhacieja.service.BookService;
import pl.marekhacieja.service.OrderService;
import pl.marekhacieja.service.UserService;

@Controller
public class HomeController {

    private BookService bookService;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public HomeController(BookService bookService, OrderService orderService, UserService userService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String referToHome(Model model) {
        bookService.addAttributeBooks(model);
        orderService.addAttributeSum(model);
        return "home";
    }

    @PostMapping("/books/{id}")
    public String addBookToOrder(@PathVariable Long id, Model model) {
        orderService.addBookToOrder(id, model);
        orderService.addAttributeSum(model);
        return "message";
    }

    @GetMapping("/books/{id}")
    public String referToBookDetail() {

        //###todo: detail book page###

        return "";
    }

}