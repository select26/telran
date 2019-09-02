package app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.docs.ModelDoc;
import app.docs.RentRecordDoc;
import app.services.*;
import dto.*;

@RequestMapping("/record")
@RestController
public class RentalRecordController {
	@Autowired
//	ICarPerson service;
	RentalRecordService service;
	
	@PostMapping("/add")
	public boolean addRecord(@RequestParam String	car,
							@RequestParam int		driver,
							@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate rentDate,
//							@RequestParam LocalDate returnDate,
							@RequestParam int 		rentDays
//							@RequestParam int		tankPersent,
//							@RequestParam double	totalPrice
							){
		return service.addRecord(new RentRecordDoc(car,	driver, rentDate, null, rentDays,
													0,					//tankPersent,
													0					//totalPrice
													) );
	}
	
	@PostMapping("/getByCar")
	public RentRecordDoc getRecordByCar(@RequestParam String car){
		return service.getRecordByCar(car);
	}
	
	@PostMapping("/getAll")
	public List<RentRecordDoc> getAllRecords(){
		return service.getAllRecords();
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
