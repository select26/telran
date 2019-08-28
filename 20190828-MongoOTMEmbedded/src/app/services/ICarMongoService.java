package app.services;

import java.time.LocalDate;
import java.util.List;

import app.entities.CarDoc;

public interface ICarMongoService {

	boolean addCar(CarDoc car);
	List<CarDoc> findCarByOwnerId(int id);
//	int addCars(List<CarDoc> cars);
//	List<CarDoc> findCarByModel(String model);
//	List<CarDoc> findByEngineBeetween(double from, double to);
//	List<CarDoc> findByEngineBeetweenInc(double from, double to);
//	List<CarDoc> findByProductionDate(LocalDate date);

}