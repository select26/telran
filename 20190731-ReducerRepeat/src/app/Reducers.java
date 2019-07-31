package app;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Reducers {
	
	// immutable accumulators (wrapping classes and String)
	
	public static <R, T, U, A> R reduce(
			Iterable<T> source,
			Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiFunction<A,U,A> mergeWithAccumulatorFunction,
			Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get();
		for(T t : source) accumulator = mergeWithAccumulatorFunction.apply(accumulator,dataTransformFunction.apply(t));
		return finalProcessingFunction.apply(accumulator);
		
	}
	
	// mutable accumulators
	
	public static <R, T, U, A> R reduce(
			Iterable<T> source,
			Function<T,U> dataTransformFunction,
			Supplier<A> accumulatorFactory,
			BiConsumer<A,U> mergeWithAccumulatorFunction,
			Function<A,R> finalProcessingFunction
			) {
		
		A accumulator = accumulatorFactory.get();
		for(T t : source) mergeWithAccumulatorFunction.accept(accumulator,dataTransformFunction.apply(t));
		return finalProcessingFunction.apply(accumulator);
		
	}	
}
