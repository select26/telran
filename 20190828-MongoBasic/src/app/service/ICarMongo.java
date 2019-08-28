package app.service;

import java.time.LocalDate;
import java.util.List;

import app.entities.CarDoc;

public interface ICarMongo {

	boolean addCar(CarDoc car);
	int addCars(List<CarDoc> cars);
	List<CarDoc> findCarByModel(String model);
	List<CarDoc> findByEngineBeetween(double from, double to);
	List<CarDoc> findByEngineBeetweenInc(double from, double to);
	List<CarDoc> findByProductionDate(LocalDate date);

}