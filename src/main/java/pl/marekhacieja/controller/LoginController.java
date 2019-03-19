package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.marekhacieja.model.Client;
import pl.marekhacieja.repository.ClientRepository;

@Controller
public class LoginController {

	private ClientRepository clientRepository;

	@Autowired
	public LoginController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("client", new Client());
		return "index";
	}

	@PostMapping("/")
	public String Login(@ModelAttribute(name = "client") Client client, Model model) {
		String username = client.getUsername();
		String password = client.getPassword();

		if (clientRepository.findByPasswordAndUsername(password, username) != null) {
			return "redirect:/home";
		} else
			return "index";
	}

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}

	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute(name = "client") Client client, Model model) {
		return "register";
	}
}
