package pl.marekhacieja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.marekhacieja.model.Book;
import pl.marekhacieja.repository.BookRepository;

@Controller
public class HomeController {

	private BookRepository bookRepository;

	@Autowired
	public HomeController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@GetMapping("/books")
	public String showBooks(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	@PostMapping("/addBooks")
	public String addBooks() {
		//TODO: ADDING TO ORDER LOGIC
		return "home";
	}

}