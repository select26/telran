package app;

import dto.Car;

public class FlatMap {

	public static void main(String[] args) {
		
		TreeMap<String, TreeSet<Car>> map = Car.createCarStream(numCars)
				.toMap();	
	}

}
