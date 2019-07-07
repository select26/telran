package app;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import dto.Car;
import dto.CarComparators;
import model.Garage;

public class Streams1App {

	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.fill(100);
		Builder<Car> garageBuilder = Stream.builder();
		for (Car c: garage.allCars()) garageBuilder.accept(c);
//		garageBuilder.build()
//					.filter(c -> c.getModel().equals("TOYOTA"))
//					.sorted(CarComparators.yearCarComparator.reversed())
//					.sorted(CarComparators.engineCarComparator)
//					.forEach((c) -> System.out.println(c));
		
//		List<Car> listCar = garageBuilder.build()
//					.filter(c -> c.getModel().equals("TOYOTA"))
//					.sorted(CarComparators.yearCarComparator.reversed())
//					.sorted(CarComparators.engineCarComparator)
//					.collect(Collectors.toList());
		
		ArrayList<Car> listCar = garageBuilder.build()
				.filter(c -> c.getModel().equals("TOYOTA"))
				.sorted(CarComparators.yearCarComparator.reversed())
				.sorted(CarComparators.engineCarComparator)
				.collect(Collectors.toCollection(ArrayList<Car> :: new));
		for (Car c : listCar) System.out.println(c);
	}
}