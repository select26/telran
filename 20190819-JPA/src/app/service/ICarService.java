package app.service;

import java.time.LocalDate;
import java.util.List;

import app.entities.CarEntity;

public interface ICarService {

	boolean addCar (CarEntity car);
	void addManyCars (List<CarEntity> listCar);
	CarEntity getCarById(int id);
	List<CarEntity> getAllCars();
	List<CarEntity> getCarsByModel(String model);
	List<CarEntity> getCarsByEngineRange(double from, double to);
	List<CarEntity> getCarsByQuery(int num);
	List<CarEntity> getCarsByModelAndEngineAndAc(String model, double engine, boolean ac, LocalDate date);
	List<CarEntity> getCarsByDate(LocalDate date);
	
}
