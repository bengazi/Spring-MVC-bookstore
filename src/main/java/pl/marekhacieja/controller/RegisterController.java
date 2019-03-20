package pl.marekhacieja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	   @GetMapping("/save")
	    public String home(Model model) {
	        Client client = new Client();
	        model.addAttribute(client);
	        return "register";
	    }
	

	@PostMapping("/save")
	public String saveClient(@Valid @ModelAttribute Client client, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(err -> System.out.println(err.getDefaultMessage()));
			return "register";
		}
			clientRepository.save(client);
			return "index";
		
		
	}
}
	
