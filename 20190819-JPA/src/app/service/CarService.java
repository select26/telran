package app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import app.entities.CarEntity;
import app.repo.CarJpaRepo;

@Service
public class CarService implements ICarService{

	@Autowired										// всесто new ... 
	CarJpaRepo carRepo;
	
	@PostConstruct									// запуск после коструктора
	private void postConstruct() {					// демонстрация запуска метода с аннотаций
		System.err.println("@@@@ PostConsrtuct");	// @PostConstruct
	}
	
	@PreDestroy
	private void preDestroy() {
		System.err.println("@@@@ PreDestroy");		// @PreDestroy
	}
	
	public boolean addCar(CarEntity car) {
		if (carRepo.existsById(car.getId())) return false;
		carRepo.save(car);
		return true;
	}

	@Override
	public void addManyCars(List<CarEntity> listCar) {
		carRepo.saveAll(listCar);
	}

	@Override
	public CarEntity getCarById(int id) {
		return carRepo.findById(id).orElse(null);
	}

	@Override
	public List<CarEntity> getAllCars() {
//		List<CarEntity> res = new ArrayList<>();
//		for(CarEntity ce : carRepo.findAll()) res.add(ce);
//		return res;
		return carRepo.findAll();
	}

	@Override
	public List<CarEntity> getCarsByModel(String model) {
//		return carRepo.findByModel(model);
		return carRepo.findByModelOrderByEngine(model);
	}

	@Override
	public List<CarEntity> getCarsByEngineRange(double from, double to) {
		return carRepo.findByEngineBetween(from, to);
	}

	public List<CarEntity> getCarsByQuery(int num) {
		return carRepo.findByQuery(num);
	}

	@Override
	public List<CarEntity> getCarsByModelAndEngineAndAc(String model, double engine, boolean ac, LocalDate date) {
		return carRepo.findByModelAndEngineAndAcAndProductionDate(model, engine, ac, date);
	}

	@Override
	public List<CarEntity> getCarsByDate(LocalDate date) {
		return carRepo.findByProductionDate(date);
	}
}
