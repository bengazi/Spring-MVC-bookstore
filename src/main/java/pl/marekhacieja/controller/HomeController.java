package pl.marekhacieja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.marekhacieja.model.Book;
import pl.marekhacieja.repository.BookRepository;

@Controller
public class HomeController {

	private BookRepository bookRepository;

	@Autowired
	public HomeController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("books", new Book());
		model.addAttribute("myBooks", new Book());
		return "home";
	}

	@GetMapping("/books")
	public String showBooks(Model model) {
		List<Book> allBooks = bookRepository.findAll();
		model.addAttribute("books", allBooks);
		return "books";
	}

}