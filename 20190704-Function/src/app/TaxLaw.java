package app;

import java.util.function.Function;

import dto.Car;

public class TaxLaw implements Function<Car, Double>{

	private static final double LITER_RATE = 1000;
	private static final double AR_RATE = 0.2;

	@Override
	public Double apply(Car c) {
		
		return (c.getEngine()*LITER_RATE) * (1. + (c.isAc() ? AR_RATE : 0.));

	}

}
