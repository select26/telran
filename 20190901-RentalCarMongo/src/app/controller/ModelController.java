package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.docs.ModelDoc;
import app.services.*;
import dto.*;

@RequestMapping("/model")
@RestController
public class ModelController {
	@Autowired
//	ICarPerson service;
	ModelService service;
	
	@PostMapping("/add")
	public boolean addModel(@RequestBody Model model){
		return service.addModel(model);
	}
	
	@PostMapping("/getByName")
	public ModelDoc getModelByName(@RequestParam String model){
		return service.getModelByName(model);
	}
	
	@PostMapping("/getAll")
	public List<ModelDoc> getAllModels(){
		return service.getAllModels();
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
