package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.IIdClass;

@RestController
public class ClassIdController {

	@Autowired
	IIdClass	service;
	
	@GetMapping("/addCompany")
	public String addCompany(@RequestParam String companyName) {
		service.addCompany(companyName);
		return "OK";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(@RequestParam String firstName,
								@RequestParam String lastName,
								@RequestParam int age ) {
		service.addEmployee(firstName, lastName, age);
		return "OK";
	}
}
