package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.BeanLifecycleService;

@RestController
public class BeanLifecycleController {
	@Autowired BeanLifecycleService	service;
	
	@GetMapping("/check")
	public String check(@RequestParam String login,
						@RequestParam String psw){
		return service.check(login, psw);
	}
}
