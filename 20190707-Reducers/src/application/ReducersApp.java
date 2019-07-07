package application;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import accumulators.DoubleAccumulator;
import accumulators.IntAccumulator;
import dto.Car;
import model.Garage;
import model.Reducers;

public class ReducersApp {

	public static void main(String[] args) {
		
		ArrayList<Integer> ali = new ArrayList<>();
		for (int i=10; i<16; i++)ali.add(i);

		Function<Integer,Integer> identity = x -> x;
		
		Supplier<Integer> integerSupplier = ()-> new Integer(1);
		BiFunction<Integer,Integer,Integer> mergeSum = (s,x)->s*x;
		
		System.out.println(Reducers.reduce(ali, identity, integerSupplier, mergeSum, identity));
		
		Supplier<IntAccumulator> accumulatorSupplier = () -> new IntAccumulator();
		BiConsumer<IntAccumulator, Integer> mergeAver = (a, x) -> {a.setSum(a.getSum() + x); a.setN(a.getN() + 1);};
		Function<IntAccumulator, Double> getAver = (a)-> ((double)a.getSum())/a.getN();
		
		System.out.println(Reducers.reduce(ali, identity, accumulatorSupplier, mergeAver, getAver));
		
		Garage garage = new Garage();
		garage.fill(20);
		for (Car c : garage.allCars()) System.out.println(c);
		
		Function<Car, Double> getEngine = c -> c.getEngine();
		Supplier<DoubleAccumulator> supplier = () -> new DoubleAccumulator(); 
		BiConsumer<DoubleAccumulator, Double> accumulator = 
				(a,d) -> { a.setSum(a.getSum()+d); a.setN(a.getN()+1); };
		Function<DoubleAccumulator, Double> getAverEngine = 
				a -> a.getSum() / a.getN();
				
		System.out.println(Reducers.reduce(garage.allCars(), 
				getEngine, 
				supplier, 
				accumulator, 
				getAverEngine));
	}

}

	
	