package app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entities.CarEntity;
import app.service.ICarService;
import dto.Car;

@RestController
public class CarController {

	@Autowired
	ICarService service;
	
	private List<Car> listToList(List<CarEntity> list ) {
		return list.stream().map(CarEntity::getCar).collect(Collectors.toList());
	}
	
	@GetMapping("/addOneRandomCar")
	public boolean addOneRandomCar(){
		return service.addCar(new CarEntity(Car.getRandomCar()));
	}

	@GetMapping("/addManyCars/{num}")
	public String addManyCars(@PathVariable int num){
		ArrayList<CarEntity> listCar = new ArrayList<>();
		for (int i = 0; i < num; i++)
			listCar.add(new CarEntity(Car.getRandomCar()));
		service.addManyCars(listCar);
		return "OK";
	}
	
	@GetMapping("/getCarById") 
	public ResponseEntity<Car> getCarById(@RequestParam int id){
		CarEntity result = service.getCarById(id);
		return result == null ?
								new ResponseEntity<Car>(HttpStatus.NO_CONTENT) :
								new ResponseEntity<Car>(result.getCar(), HttpStatus.OK);
	}

	@GetMapping("/getAllCars") 
	public List<Car> getAllCars(){
		return listToList(service.getAllCars());
	}

	@GetMapping("/getCarsByModel") 
	public List<Car> getCarsByModel(@RequestParam("model") String model){
//		return listToList(service.getCarsByModel(model));
		return listToList(service.getCarsByModel(model));		//With sorting by Engine
		
//		findByModelOrderByEngine
	}

	@GetMapping("/getCarsByEngineRange") 
	public List<Car> getCarsByModel(@RequestParam("from") double from, 
									@RequestParam("to") double to) {
		return listToList(service.getCarsByEngineRange(from, to));
	}

	@GetMapping("/getCarsByQuery") 
	public List<Car> getCarsByQuery(@RequestParam("num") int num) {
		return listToList(service.getCarsByQuery(num));
	}
	
	@GetMapping("/getCarsByParams") 
	public List<Car> getCarsByParams(@RequestParam("model") String model,
									@RequestParam("engine") double engine,
									@RequestParam("ac") boolean ac,
									@RequestParam("date") String date
									) {
		return listToList(service.getCarsByModelAndEngineAndAc(model, engine, ac, LocalDate.parse(date)));
	}
	
	@GetMapping("/getCarsByDate") 
	public List<Car> getCarsByDate(@RequestParam("date") String date) {
		return listToList(service.getCarsByDate(LocalDate.parse(date)));
	}

}
