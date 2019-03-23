package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.UserRepository;

@Controller
public class LoginController {

	private UserRepository userRepository;

	@Autowired
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return  "index";
	}

	@PostMapping("/")
	public String Login(@ModelAttribute(name = "user") User user, Model model) {
		String username = user.getUsername();
		String password = user.getPassword();

		if (userRepository.findByPasswordAndUsername(password, username) != null) {
			return "redirect:/home";
		} 
			model.addAttribute("invalidCredentials", true);
			return "index";
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
