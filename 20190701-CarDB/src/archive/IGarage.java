package archive;

import dto.Car;

public interface IGarage {
	
	void fill(int numCar);
	
	boolean add(Car car);
	boolean contains(Car car);
	boolean remove(Car car);
	Car remove(int id);
	
	Car getById(int id);
	Iterable<Car> allCars();
	Iterable<Car> allCarsByModel(String model); 
	Iterable<Car> allCarsByYearRange(int min, int max);
	Iterable<Car> allCarsByEngineRange(double min, double max);
	Iterable<Car> allCarsByAC(boolean ac);
	
	Iterable<Car> allCarsSortedByModel();
	Iterable<Car> allCarsSortedByYear();
	Iterable<Car> allCarsSortedByEngine();
}
