package app;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import dto.Car;

public class FlatMap {

	private static final int numCars = 20;

	public static void main(String[] args) {
		
//		TreeMap<String, TreeSet<Car>> map = Car.createCarStream(numCars)
//				.collect(Collectors.toMap(
//					(car) -> car.getModel(),
//					(car) -> {
//						TreeSet tsc = new TreeSet<>();
//						tsc.add(car);
//						return tsc;
//					},
//					(tree1, tree2) -> {
//						tree1.addAll(tree2);
//						return tree1;
//					},
////					() -> new TreeMap<String, TreeSet<Car>>()
//					TreeMap :: new
//						));	
//		System.out.println(map);
////		
////		map.values().stream()
////					.flatMap(ts -> ts.stream())
////					.forEach(c -> System.out.println(c));
//
//		Stream<Car> stm = map.values().stream()
//		.flatMap(ts -> ts.stream());
//
//		long count = stm.peek(System.out :: println)
//		.count();
//		
//		System.out.println(count);
		
		Stream.iterate(15, n -> (n+1))
				.limit(5)
				.peek((x) -> System.out.print("Number " + x + ": "))
				.flatMap(n -> deviderStream(n))
				.forEach((x) -> System.out.print(x + "  "));
		
		System.out.println();
//		long t1 = System.currentTimeMillis();
//		int pr = Integer.MAX_VALUE/2;
//		long t2 = System.currentTimeMillis();
//		if (isPrimeSimple(pr)) System.out.println(pr + " - это простое число");
//		else System.out.println(pr + " - это непростое число");
//		System.out.println("Time: " + (t2- t1));
		
		boolean status = true;
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < Integer.MAX_VALUE/1000000; i++) {
			status = isPrime(i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Time: " + (t2- t1) + "\t" + status);
		
		t1 = System.currentTimeMillis();
		
		for (int i = 0; i < Integer.MAX_VALUE/10000; i++) {
			status = isPrimeSimple(i);
		}
		t2 = System.currentTimeMillis();
		System.out.println("Time2: " + (t2- t1) + "\t" + status);
	}
	
	public static Stream<Integer> deviderStream(int num) {
		Builder<Integer> stm = Stream.builder();
		if (num < 4) return stm.build();							// net deliteley krome 1 & 4isla
		for (int i = 2; i < num -1; i++) {
			if (num % i == 0) {
				stm.accept(i);
//				stm.accept(num/i);
			}
		}
		return stm.build();
	}
	
	public static boolean isPrime(int num) {
		
		if (num < 4) return true;
		int i = 0;
		for (i = 2; i*i < num && i*i > 0; i++) {
			if (num % i == 0) return false;
		}
		return true;
		
	}
	
	public static boolean isPrimeSimple(int num) {
		
		if (num < 2) return false; 
		if (num < 4) return true;
		int i = 0;
		for (i = 2; i < num-1; i++) {
			if (num % i == 0) return false;
		}
		return true;
		
	}
}
