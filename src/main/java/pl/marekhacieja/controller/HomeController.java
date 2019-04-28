package pl.marekhacieja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.marekhacieja.model.Book;
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
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/addBooks/{id}")
    public String addBookToOrder(@PathVariable Long id, Model model) {
        orderService.addBookToOrder(id, model);
        return "message";
    }

    @PostMapping("/addOrder")
    public String addOrder() {
        orderService.addOrder(getLoggedUserName());
        return "redirect:/";
    }

    @PostMapping("/deleteBook/{id}")
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