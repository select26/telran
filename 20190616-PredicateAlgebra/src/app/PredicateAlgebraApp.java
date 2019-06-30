package app;

import java.util.function.Predicate;

import car.Car;
import predicates.*;

public class PredicateAlgebraApp {

	private static final int NUM_CARS = 50;

	public static void main(String[] args) {
		
		Car[] garage = new Car[NUM_CARS];
		for (int i = 0; i < garage.length; i++) {
			garage[i] = Car.randomCar();
		}

		for (int i = 0; i < garage.length; i++) System.out.println(garage[i]);
		System.out.println("****************************************************");
		
		Predicate<Car> ac 	  = 	new Ac();
		Predicate<Car> model  = 	new Model("TESLA");
		Predicate<Car> yearRange = 	new YearsRange(1990,2010);
		Predicate<Car> engRange = 	new EngineRange(2.5, 4.5);
//		Predicate<Car> combinePredicate = yearRange.negate().and(ac.negate());
		Predicate<Car> combinePredicate = Predicate.isEqual(garage[49]); 
				
		//		Car[] filtered = filterCar(garage, new Ac());
//		Car[] filtered = filterCar(garage, new Model("TESLA"));
//		Car[] filtered = filterCar(garage, new YearsRange(1990,1995));
//		Car[] filtered = filterCar(garage, new EngineRange(3.5, 9.0));
		Car[] filtered = filterCar(garage, combinePredicate); 
		for (int i = 0; i < filtered.length; i++) System.out.println(filtered[i]);
		System.out.println("****************************************************");
	
	}
	
	public static Car[] filterCar(Car[] arr, Predicate<Car> predicate) {
		Car[] buffer = new Car[arr.length];
		int counter= 0;
		for (int i = 0; i < arr.length; i++) {
			if (predicate.test(arr[i])) {
				buffer[counter++] = arr[i];
			}
		}
		Car[] result = new Car[counter];
		for (int i = 0; i < counter; i++) {
			result[i] = buffer[i];
		}
		return result;
	}
}
