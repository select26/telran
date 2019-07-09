package app;

import java.util.stream.Stream;

import accumulators.IntAccumulator;

public class ReduceApp {

	public static void main(String[] args) {
//		int res = Stream.of(-3,-5,-8,-2,-6)
//			.forEach(x -> System.out.println(x));
//				.reduce(10, (s,i) -> s+i);
//				.reduce(-10, (s,i) -> (s<i)? i : s);
//				.get();
				
		IntAccumulator acc =  Stream.of(-3,-5,-8,-2,-6)
				.reduce(new IntAccumulator(), 
						(a,i) -> {a.setSum(a.getSum() + i); a.setN(a.getN() + 1); return a;},
						(a1, a2) -> {IntAccumulator a3 = new IntAccumulator();
									a3.setSum(a1.getSum() + a2.getSum());
									a3.setN(a1.getN() + a2.getN());
									return a3;
									}
						);
				
		System.out.println((double)acc.getSum()/acc.getN());
	}

}
