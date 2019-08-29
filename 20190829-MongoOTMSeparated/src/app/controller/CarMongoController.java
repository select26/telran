package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.services.CarPersonService;
import app.services.ICarPerson;
import dto.*;


@RestController
public class CarMongoController {
	@Autowired
//	ICarPerson service;
	CarPersonService service;
	
	@PostMapping("/addOwner")
	public boolean addOwner(@RequestBody PersonDto person){
		return service.addOwner(person);
	}
	
	@PostMapping("/addCar")
	public boolean addCar(@RequestBody CarDto car){
		return service.addCar(car);
	}
	
	@GetMapping("/getCarOwner")
	public List<CarDto> getCarByOwner(@RequestParam int id){
		return service.getOwnerCars(id);
	}
	
	@GetMapping("/getAllCars")
	public List<CarDto> getAllCars(){
		return service.getAllCars();
	}

	@GetMapping("/getAllOwners")
	public List<PersonDto> getAllOwnrs(){
		return service.getAllOwners();
	}

	
}
