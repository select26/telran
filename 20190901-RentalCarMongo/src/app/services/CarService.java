package app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.docs.*;
import app.repo.*;
import dto.*;

@Service
public class CarService {							//implements ICarPerson {
	
	@Autowired	CarMongoRepo	carRepo;
	@Autowired	DriverMongoRepo driverRepo;
	@Autowired	ModelMongoRepo	modelRepo;
	@Autowired	RentalRecordMongoRepo recordRepo;
	
	public boolean addCar(Car car) {
//		System.err.println("[addCar] name: " + car);
		if(!modelRepo.existsById(car.getModel().getName()))
			modelRepo.save(new ModelDoc(car.getModel()));
		if(carRepo.existsById(car.getVin())) return false;
		carRepo.save(new CarDoc(car));
		return true;
	}
	
	public CarDoc getCarByVin(String vin){
//		System.err.println("[getModelByName] name: " + name);
		CarDoc res = carRepo.findById(vin).orElse(null);
//		System.err.println("[getModelByName] ModelDoc response: " + res);
		return res;
	}
	public List<CarDoc> getAllCars(){
		return carRepo.findAll();
	}
	
	public List<CarDoc> getAllCarsByDriver(int id) {		
		System.err.println(recordRepo.findByDriver(id));
		List<CarDoc> cars = new ArrayList<CarDoc>();
		List<RentRecordDoc> recs = carService.getAllCarsByDriver(id);
		for(RentRecordDoc rec : recs) cars.add(carService.getCarByVin(rec.getCar()) ); 
		return cars;
	}

//	@Override
//	public boolean addCar(CarDto car) {
//		if(carRepo.existsById(car.getVIN())) return false;
//		if(!personRepo.existsById(car.getOwner().getId()))			//If owner not exists
//			personRepo.save(new PersonDoc(car.getOwner()));			//create new owner
//		carRepo.save(new CarDoc(car));
//		return true;
//	}
//
//	@Override
//	public List<CarDto> getOwnerCars(int id) {
//		PersonDoc found = personRepo.findById(id).orElse(null);
//		return found==null ?
//				new ArrayList<CarDto>() :
//				carRepo.findByOwnerId(id).stream()
//									.map(car -> car.getCarDto(found))
//									.collect(Collectors.toList() );
//	}
//
//	public List<PersonDto> getAllOwners(){
//		return personRepo.findAll().stream()
//				.map(owner -> owner.getPersonDto())
//				.collect(Collectors.toList() );
//	}
//	
//
//	public List<CarDto> getAllCars(){
//		return carRepo.findAll().stream()
//				.map(car -> car.getCarDto(personRepo.findById(car.getOwnerId()).get()))
//				.collect(Collectors.toList() );
//	}
}
