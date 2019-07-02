package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

import comparators.YearCarComparator;
import dto.Car;
import randomlib.RandomLib;

public class LambdaExpressionApp {

	private static final int NUM_NUM = 20;

	public static void main(String[] args) {
		ArrayList<Car> alc = new ArrayList<>();
		for (int i = 0; i < NUM_NUM; i++) alc.add(Car.randomCar());
		for (Car c : alc) System.out.println(c);
		System.out.println("==============================================================");
		
//		Collections.sort(alc, new YearCarComparator());

//		Анонимный класс:
//		Collections.sort(alc, new Comparator<Car>(){
//
//			@Override
//			public int compare(Car c1, Car c2) {
////				return c1.getYear() - c2.getYear();
//				return Double.compare(c1.getEngine(), c2.getEngine());
//			}
//		}); 
		
//		Lambda expression!
//		Comparator<Car> yearC = (Car c1,  Car c2) -> {return Double.compare(c1.getEngine(), c2.getEngine()); }; 
//		Comparator<Car> yearC = (c1, c2) -> {return Double.compare(c1.getEngine(), c2.getEngine()); }; 
		Comparator<Car> yearC = (c1, c2) -> Double.compare(c1.getEngine(), c2.getEngine());  
		Collections.sort(alc, 
//				(Car c1,  Car c2) -> {return c1.getYear() - c2.getYear(); }
//				(Car c1,  Car c2) -> {return Double.compare(c1.getEngine(), c2.getEngine()); }
				yearC
				);
		
		for (Car c : alc) System.out.println(c);
		System.out.println("==============================================================");
		
		String model = "TOYOTA";
//		Predicate<Car> nameFilter = (Car c) -> {return (c.getModel().equals(model) ) ;};
//		Predicate<Car> nameFilter = c -> {return (c.getModel().equals(model) ) ;};
		Predicate<Car> nameFilter = c -> c.getModel().equals(model);
		alc.removeIf(nameFilter.negate());
		for (Car c : alc) System.out.println(c);
		System.out.println("==============================================================");
		
	}

}
