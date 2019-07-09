package app;

import dto.Car;

public class CarForPrint {
	private String model;
	private double engine;
	private int year;
	
	public CarForPrint(Car car) {
		model 	= car.getModel();
		engine 	= car.getEngine();
		year 	= car.getYear();
	}

	@Override
	public String toString() {
		return model + ", " + engine + ", " + year;
	}
}
