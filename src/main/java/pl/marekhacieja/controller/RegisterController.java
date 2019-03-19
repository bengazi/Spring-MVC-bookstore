package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.marekhacieja.model.Client;
import pl.marekhacieja.repository.ClientRepository;

@Controller
public class RegisterController {

	private ClientRepository clientRepository;

	@Autowired
	public RegisterController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@PostMapping("/save")
	public String saveClient(@ModelAttribute Client client) {
		clientRepository.save(client);
		return "index";
	}
}