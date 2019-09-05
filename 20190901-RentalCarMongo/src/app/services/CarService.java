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
		List<RentRecordDoc> recs = recordRepo.findByDriver(id);		//все записи с этим водителем
		for(RentRecordDoc rec : recs) cars.add(carRepo.findById(rec.getCar()).orElse(null));
		System.err.println("[cars: ]" + cars);
		return cars;
	}


}
