package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.IUniversity;

@RestController
//@RequestMapping("")
public class UniversityController {
	@Autowired
	IUniversity service;

	@GetMapping("/add")
	public boolean add(@RequestParam String name) {
//		return service.addCountry(countryName);
		System.out.println(name);
		return true;
	}

	@GetMapping("/addTeacher")
	public boolean add(@RequestParam String firstName, @RequestParam String lastName) {
//		System.out.println(firstName + " " + lastName);
		return service.addTeacher(firstName, lastName);
	}

}
