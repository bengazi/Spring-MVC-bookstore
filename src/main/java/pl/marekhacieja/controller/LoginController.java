package pl.marekhacieja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.marekhacieja.model.Book;
import pl.marekhacieja.model.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String showHome() {
		return "home";
	}

	@GetMapping("/home")
	public String showHome2(Model model) {
		model.addAttribute("myBooks", new Book());
		//model.addAttribute("books", new Book());
		return "home";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute(name = "user") User user, Model model) {
		return "register";
	}
}
