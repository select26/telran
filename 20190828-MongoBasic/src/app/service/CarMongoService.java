package app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.CarDoc;
import app.repo.CarMongoRepo;

@Service
public class CarMongoService implements ICarMongo {
	
	@Autowired
	CarMongoRepo carRepo;
	
	@Override
	public boolean addCar(CarDoc car){
		if (carRepo.existsById(car.getVIN())) return false;
		carRepo.save(car);
		return true;
	}
	
	public int addCars(List<CarDoc> cars) {
		List<CarDoc> uniqCars = cars.stream()			//Delete existing records
								.filter(car -> !carRepo.existsById(car.getVIN()))
								.collect(Collectors.toList());
		carRepo.saveAll(uniqCars);
		return uniqCars.size();
	}
	
	public List<CarDoc> findCarByModel(String model){
		return carRepo.findByModel(model);
	}

	@Override
	public List<CarDoc> findByEngineBeetween(double from, double to) {
		return carRepo.findByEngineBetween(from, to);
	}

	@Override
	public List<CarDoc> findByEngineBeetweenInc(double from, double to) {
		return carRepo.findByEngineBetweenInc(from, to);
	}

	@Override
	public List<CarDoc> findByProductionDate(LocalDate date) {
		return carRepo.findByProductionDate(date);
	}
}
