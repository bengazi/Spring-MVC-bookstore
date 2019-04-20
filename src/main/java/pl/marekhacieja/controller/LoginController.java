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

	@GetMapping("/login")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String showHomeAfterLogin() {
		return "redirect:/";
	}

	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute(name = "user") User user, Model model) {
		return "register";
	}
}
