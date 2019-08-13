package app;

import dto.Car;

public class LombokTestApp {

	public static void main(String[] args) {
		Car car = new Car("VOLGA", 1975, 1.8, false);
		System.out.println(car);
	}

}
