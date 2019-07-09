package app;

import java.util.stream.Collector;

import accumulators.DoubleAccumulator;
import dto.Car;

public class CustomCollectorApp {

	private static final int numCars = 20;

	public static void main(String[] args) {

		Collector<Car, DoubleAccumulator, Double> averageEngine =
					Collector.of(
							() -> new DoubleAccumulator(),						// new accumulator
							(DoubleAccumulator a, Car c) -> {					// func add result to accum
								a.setSum(a.getSum() + c.getEngine());
								a.setN(a.getN() + 1);
							},
							(DoubleAccumulator a1, DoubleAccumulator a2) -> {	// func addition of accum
								DoubleAccumulator a3 = new DoubleAccumulator();	// if multitread
								a3.setSum(a1.getSum() + a2.getSum());
								a3.setN(a1.getN() + a2.getN());
								return a3;
							},
							(DoubleAccumulator a) -> a.getSum() / a.getN()		// func return result
							);
		double averageE = Car.createCarStream(numCars)
							.collect(averageEngine);
		System.out.println(averageE);
		
//		Collector<Boolean, CarForPrint> 
	}

}
