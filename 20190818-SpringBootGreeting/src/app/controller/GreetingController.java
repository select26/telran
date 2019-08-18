package app.controller;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Person;

@RestController
@RequestMapping ("/greet")						//будет обрабатывать завпросы, начинающиеся на /greet 
public class GreetingController {
	
	@GetMapping ("/sasha")
	public String sasha(){	
		return "Go to hell!!";
	}
	
	@GetMapping ("/masha")
	public String masha() {
		return "You are welcome!";
	}
	
	@PostMapping("/goodMorning")
	public String goodMorning(@RequestBody Person person) {
		return "Good morning, " + person.getFirstName() + " " + person.getLastName() + " !";
	}
	
}
