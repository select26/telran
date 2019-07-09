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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
