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
import org.springframework.web.bind.annotation.RequestMapping;

import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.BookRepository;
import pl.marekhacieja.repository.OrderRepository;
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
        //TODO change list src
        List<Book> myBooks = bookService.getAllBooks();
        model.addAttribute("myBooks", myBooks);
        return "home";
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/addBooks/{id}")
    public String addBooks(@PathVariable Long id, Model model) {
        // TODO: ADD TO ORDER LOGIC
//        System.out.println(id);
//        System.out.println(getLoggedUserName());
        return "redirect:/";
    }

    @PostMapping("/deleteBook/{id}")
    public String removeBook(@PathVariable Long id, Model model) {
        // TODO: DELETE FROM ORDER LOGIC
        return "redirect:/";
    }

    private String getLoggedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }
}