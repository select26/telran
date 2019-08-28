package app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entities.CarDoc;
import app.service.ICarMongo;

@RestController
public class CarMongoController {
	@Autowired
	ICarMongo service;
	
	@PostMapping("/addcar")
	public boolean addCar(@RequestBody CarDoc car) {
		return service.addCar(car);
	}

	@PostMapping("/addcars")
	public int addCars(@RequestBody List<CarDoc> cars) {
		
		return service.addCars(cars);
	}

	@GetMapping("/getcarsbymodel")
	public List<CarDoc> getCarsByModel(@RequestParam String model) {
		return service.findCarByModel(model);
	}
	
	@GetMapping("/getcarsbyenginerange")
	public List<CarDoc> getCarsByEngineRange(@RequestParam double from, @RequestParam double to) {
		return service.findByEngineBeetween(from, to);
	}
	
	@GetMapping("/getcarsbyenginerangeinc")
	public List<CarDoc> getCarsByEngineRangeInc(@RequestParam double from, @RequestParam double to) {
		return service.findByEngineBeetweenInc(from, to);
	}
	
	@GetMapping("/getcarsbyyear")
	public List<CarDoc> getCarsByYear(@RequestParam 
									  @DateTimeFormat(pattern="yyyy-MM-dd") 
									  LocalDate date) {
		return service.findByProductionDate(date);
	}
}
