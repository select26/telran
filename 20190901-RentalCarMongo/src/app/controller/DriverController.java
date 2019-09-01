package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.docs.CarDoc;
import app.docs.DriverDoc;
import app.services.*;
import dto.*;

@RequestMapping("/driver")
@RestController
public class DriverController {
	@Autowired	ModelService	modelService;
	@Autowired	CarService		carService;
	@Autowired	DriverService	driverService;
	
	@PostMapping("/add")
	public boolean addDriver(@RequestBody Driver driver){
		return driverService.addDriver(driver);
	}
	
	@PostMapping("/getById")
	public DriverDoc getModelById(@RequestParam int tz){
		return driverService.getDriverById(tz);
	}
	
	@PostMapping("/getAll")
	public List<DriverDoc> getAllCars(){
		return driverService.getAllDrivers();
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@GetMapping("/getCarOwner")
//	public List<CarDto> getCarByOwner(@RequestParam int id){
//		return service.getOwnerCars(id);
//	}
//	
//	@GetMapping("/getAllCars")
//	public List<CarDto> getAllCars(){
//		return service.getAllCars();
//	}
//
//	@GetMapping("/getAllOwners")
//	public List<PersonDto> getAllOwnrs(){
//		return service.getAllOwners();
//	}

	
}
