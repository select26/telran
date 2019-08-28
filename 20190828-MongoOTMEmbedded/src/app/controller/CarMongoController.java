package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entities.CarDoc;
import app.services.ICarMongoService;

@RestController
public class CarMongoController {
	@Autowired
	ICarMongoService service;
	
	@PostMapping("/addcar")
	public boolean addCar(@RequestBody CarDoc car) {
		return service.addCar(car);
	}
	
	@GetMapping("/getcarsbyownerid")
	public List<CarDoc> getCarsByOwnerId(@RequestParam int id) {
		return service.findCarByOwnerId(id);
	}
//	@PostMapping("/addcars")
//	public int addCars(@RequestBody List<CarDoc> cars) {
//		
//		return service.addCars(cars);
//	}
//
//	@GetMapping("/getcarsbymodel")
//	public List<CarDoc> getCarsByModel(@RequestParam String model) {
//		return service.findCarByModel(model);
//	}
//	
//	@GetMapping("/getcarsbyenginerange")
//	public List<CarDoc> getCarsByEngineRange(@RequestParam double from, @RequestParam double to) {
//		return service.findByEngineBeetween(from, to);
//	}
//	
//	@GetMapping("/getcarsbyenginerangeinc")
//	public List<CarDoc> getCarsByEngineRangeInc(@RequestParam double from, @RequestParam double to) {
//		return service.findByEngineBeetweenInc(from, to);
//	}
//	
//	@GetMapping("/getcarsbyyear")
//	public List<CarDoc> getCarsByYear(@RequestParam 
//									  @DateTimeFormat(pattern="yyyy-MM-dd") 
//									  LocalDate date) {
//		return service.findByProductionDate(date);
//	}
}
