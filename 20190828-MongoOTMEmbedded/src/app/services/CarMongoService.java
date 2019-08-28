package app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.CarDoc;
import app.repo.CarMongoRepo;

@Service
public class CarMongoService implements ICarMongoService {
	
	@Autowired
	CarMongoRepo carRepo;

	@Override
	public boolean addCar(CarDoc car) {
		if(carRepo.existsById(car.getVIN())) return false;
		carRepo.save(car);
		return true;
	}

	@Override
	public List<CarDoc> findCarByOwnerId(int id) {
		return carRepo.findByOwnerId(id);
//		return null;
	}
	

}
