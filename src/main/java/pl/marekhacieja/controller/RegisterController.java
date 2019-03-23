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

import pl.marekhacieja.model.User;
import pl.marekhacieja.repository.UserRepository;

@Controller
public class RegisterController {

	private UserRepository userRepository;

	@Autowired
	public RegisterController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/save")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(err -> System.out.println(err.getDefaultMessage()));
			return "register";
		}
		userRepository.save(user);
		return "index";

	}
}
