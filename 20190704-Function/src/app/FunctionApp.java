package app;

import java.util.function.Function;

import dto.Car;
import model.Garage;

public class FunctionApp {

//	private static final double LITER_RATE = 1000;
//	private static final double AR_RATE = 0.2;

	public static void main(String[] args) {
		
//		Function<Car, Double> taxLaw = 
//				c -> (c.getEngine()*LITER_RATE) * (1. + (c.isAc() ? AR_RATE : 0.));
		
		Garage garage = new Garage();
		garage.fill(20);
		
//		System.out.println(totalTax (garage, taxLaw));
		System.out.println(totalTax (garage, new TaxLaw()));
	}
	
	public static double totalTax(Garage garage, Function<Car, Double> taxLaw) {
		double result = 0;
		for (Car car : garage.allCars()) result = result + taxLaw.apply(car);
		return result;
		
	}

}