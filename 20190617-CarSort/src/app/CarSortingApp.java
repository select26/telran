package app;

import java.util.Arrays;
import java.util.Comparator;

import car.Car;
import comparators.ACCarComparator;
import comparators.EngineCarComparator;
import comparators.ModelCarComparator;
import comparators.YearCarComparator;

public class CarSortingApp {

	private static final int NUM_CARS = 20;

	public static void main(String[] args) {
//		Car[] garage = new Car[NUM_CARS];
//		for (int i = 0; i < garage.length; i++) garage[i] = Car.randomCar();
		Car[] garage = Car.getRandomGarageArray(NUM_CARS);
		for (int i = 0; i < garage.length; i++) System.out.println(garage[i]);
		System.out.println("****************************************************");
		
//		Arrays.sort(garage, new YearCarComparator());
//		Arrays.sort(garage, new EngineCarComparator());
		
		Comparator<Car> modelComp  = new ModelCarComparator();
		Comparator<Car> yearComp   = new YearCarComparator();
		Comparator<Car> engineComp = new EngineCarComparator();
		Comparator<Car> acComp 	   = new ACCarComparator();
		
//		Arrays.sort(garage, modelComp
//							.thenComparing(acComp.reversed()));
		Arrays.sort(garage, engineComp);
	
		
		for (int i = 0; i < garage.length; i++) System.out.println(garage[i]);
		System.out.println("****************************************************");
	}

}
