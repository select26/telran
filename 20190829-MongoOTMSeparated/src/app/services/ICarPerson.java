package app.services;

import java.time.LocalDate;
import java.util.List;

import app.documents.*;
import dto.*;

public interface ICarPerson {

	boolean addOwner(PersonDto person);
	boolean addCar(CarDto car);
	List<CarDto> getOwnerCars(int id);
//	int addCars(List<CarDoc> cars);
//	List<CarDoc> findCarByModel(String model);
//	List<CarDoc> findByEngineBeetween(double from, double to);
//	List<CarDoc> findByEngineBeetweenInc(double from, double to);
//	List<CarDoc> findByProductionDate(LocalDate date);

}