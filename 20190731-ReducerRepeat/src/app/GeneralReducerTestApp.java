package app;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

import accumulator.DoubleAverageAccumulator;
import car.Car;
import randomlib.RandomLib;

public class GeneralReducerTestApp {
	private static final int NUM_CAR = 10;

	public static void main(String[] args) {
/*
  		ArrayList<Car> garage = new ArrayList<>();
		for (int i = 0; i < NUM_CAR; i++) garage.add(Car.randomCar());
		for(Car c :garage) System.out.println(c);
		
		double averageEngine = Reducers.reduce(
				garage,
				(car) -> car.getEngine(),
				() -> new DoubleAverageAccumulator(),
				(accum, engine) -> {
					accum.setSum(accum.getSum() + engine);
					accum.setCounter(accum.getCounter() + 1);
				},
				(accum) -> accum.getSum() / accum.getCounter()
				);
		
		System.out.println(averageEngine);
*/
		// Another sample
/*		
		final int NUM = 20;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < NUM; i++) arr.add(RandomLib.nextIntRange(1, 100));
		System.out.println(arr);
		
		int simpleCount = Reducers.reduce(
				arr, 
				Function.identity(), 						//x -> x, 
				() -> new Integer(0), 
				(acc, num) -> {
					if (isPrime(num)) acc++;
					return acc;
				}, 
				Function.identity());
		
		System.out.println();
		System.out.println(simpleCount);
	}

	private static boolean isPrime(Integer number) {
		boolean res = true;
		int num = number;
		if (num == 1)
			res = false;
		else if (num <= 3)
			res = true;
		else if (num % 2 == 0)
			res = false;
		else {
			for (int i = 3; i * i > 0 && i * i <= num; i = i+2) {
				if (num % i == 0) {
					res = false;
				}
			}
		}
		if (res == true) System.out.print(" " + num);				// debug
		return res;
*/	
		DoubleAverageAccumulator da = Stream.generate( () -> Car.randomCar() )
						.limit(NUM_CAR)
						.map(car -> new DoubleAverageAccumulator(car.getEngine(), 1))
						.reduce( (acc,item) -> {
								acc.setSum(acc.getSum()+item.getSum());
								acc.setCounter(acc.getCounter() + item.getCounter());
								return acc;
								} )
						.get();
		System.out.println(da.getSum()/da.getCounter());
	
	}

	
}
