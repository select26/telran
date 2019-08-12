package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

import dto.Car;
import dto.Driver;
import dto.Model;

public interface IRentCompanyService {
	
	boolean addModel(String modelName, int tank, double dayPrice) throws SQLException;
	Model getModel(String modelName) throws SQLException;
	Set<Model> getAllModels() throws SQLException;
	
	boolean addDriver(int id, String name) throws SQLException;
	Driver getDriver(int id) throws SQLException;
	Set<Driver> getAllDrivers() throws SQLException;
	
	boolean addCar (String regNumber, Model model) throws SQLException;
	Car getCar(String regNumber) throws SQLException;
	Set<Car> getAllCars() throws SQLException;
	Set<Car> getAllCarsNotInUse();
	

	int rentRecord(Car car, Driver driver, LocalDate rentDate, int rentDays);
	int returnRecord(Car car, LocalDate returnDate, int tankPersent);
}
