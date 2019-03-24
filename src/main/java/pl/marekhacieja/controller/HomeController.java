package pl.marekhacieja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.BookRepository;

@Controller
public class HomeController {

	private BookRepository bookRepository;

	@Autowired
	public HomeController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/books")
	public String showBooks(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "books";
	}

	@GetMapping("/home")
	public String showHome(Model model) {
		// TODO
		List<Book> myBooks = null;
		model.addAttribute("myBooks", myBooks);
		return "home";
	}

	@PostMapping("/addBooks")
	public String addBooks() {
		// TODO: ADD TO ORDER LOGIC
		return "redirect:home";
	}

}