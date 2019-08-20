package app.controller;

import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import dto.Person;

@RestController
@RequestMapping ("/greet")						//будет обрабатывать завпросы, начинающиеся на /greet 
public class GreetingController {
	
	@GetMapping ("/sasha")						//ловим GET-запрос /greet/sasha
	public String sasha(){	
		return "Go to hell!!";
	}
	
	@GetMapping ("/masha")						//ловим GET-запрос
	public String masha() {
		return "You are welcome!";
	}
	
	@PostMapping ("/goodMorning")				//ловим POST-запрос
	public String goodMorning(@RequestBody Person person) {
		return "Good morning, " + person.getFirstName() + " " + person.getLastName() + " !";
	}
	
	@GetMapping ("/hello")						//извлекаем параметры из GET-запроса
	public String testParam (@RequestParam ("name") String name) {
		return "Good morning, " + name + "!";
	}
	
	@GetMapping ("/auth")						//извлекаем параметры из http-заголовков
	public String getAuth(@RequestHeader("Authorization") String auth) {
//		System.out.println(auth);
		String result =  new String(Base64.getDecoder()
							.decode(auth.substring(auth.indexOf(" ")+1)
//							.getBytes()
							));
//		System.out.println(result);
		return result;
	}
	
	@GetMapping("/name/{id}")					//извлекаем параметры из пути http-запроса
	public String getName(@PathVariable("id") int id){
		String[] names = {"Sasha","Masha","Dasha"};
		return id>=0 && id <3 ? names[id] : "wrong id!";
	}
	
}
