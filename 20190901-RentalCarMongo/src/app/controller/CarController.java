package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.docs.CarDoc;
import app.docs.ModelDoc;
import app.docs.RentRecordDoc;
import app.services.*;
import dto.*;

@RequestMapping("/car")
@RestController
public class CarController {
	@Autowired	ModelService	modelService;
	@Autowired	CarService		carService;
	@Autowired	DriverService	driverService;
	
	@PostMapping("/add")
	public boolean addCar(@RequestBody Car car){
		return carService.addCar(car);
	}
	
	@PostMapping("/getByVin")
	public CarDoc getModelByName(@RequestParam String vin){
		return carService.getCarByVin(vin);
	}
	
	@PostMapping("/getAll")
	public List<CarDoc> getAllCars(){
		return carService.getAllCars();
	}
	
	@PostMapping("/getAllCarsByDriver")
	public List<CarDoc> getAllCarsByDriver(@RequestParam int id){
//		public List<CarDoc> getAllCarsByDriver(@RequestParam int id){
		List<CarDoc> cars = new ArrayList<CarDoc>();
		List<RentRecordDoc> recs = reco							//carService.getAllCarsByDriver(id);
		for(RentRecordDoc rec : recs) cars.add(carService.getCarByVin(rec.getCar()) ); 
		return cars;
	}
	
}
