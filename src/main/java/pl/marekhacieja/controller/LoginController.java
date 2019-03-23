package pl.marekhacieja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.marekhacieja.model.User;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/")
	public String Login() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}

	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute(name = "user") User user, Model model) {
		return "register";
	}
}
