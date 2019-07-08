package app;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dto.*;
import dto.Car;
import dto.CarComparators;

@SuppressWarnings("unused")
public class Stream2App {
	
	public static void main(String[] args) throws EmptyStreamException {
		
// 		Generate random Car list
//		Stream.generate(() -> Car.randomCar())
//			.limit(2000)
//			.forEach(System.out :: println);
		Car.createCarStream(10)
//			.map(c -> c.getModel() + ", " + c.getId() + ", " + c.getYear())
//			.filter(s -> s.startsWith("M") || s.startsWith("T"))
//			.distinct()
		
//			.peek((c) -> System.out.println(c))
		
			.map((car) -> new CarForPrint(car))
			.peek((c) -> System.out.println(c));
		
//		long count = Car.createCarStream(15)
//					.count();
//		System.out.println(count);
//		
//		Car car = Car.createCarStream(5)
//				.peek((c) -> System.out.println(c))
//				.min(CarComparators.engineCarComparator)
////				.orElseGet(() -> new Car(123456789, "AMG", 2005, 6.2, true));
//				.orElseThrow(() -> new EmptyStreamException("Empty car stream!"));
//		System.out.println();
//		System.out.println(car);
		
		LinkedHashSet<String> hsc = Car.createCarStream(20)
					.map(Car :: getModel)									// c -> c.getModel
					.sorted()
					.collect(Collectors.toCollection(LinkedHashSet :: new));
		for (String c : hsc) System.out.println(c);
		
	}

}
