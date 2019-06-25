package appl;

import car.Car;

public class RandomCarApp {

	private static final int NUM_CARS = 10;

	public static void main(String[] args) {
		Car[] garage = new Car[NUM_CARS];
		for (int i = 0; i < garage.length; i++) {
			garage[i] = Car.randomCar();
		}

		for (int i = 0; i < garage.length; i++) {
			System.out.println(garage[i]);
		}
	}

}
