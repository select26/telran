package app;

import java.util.stream.Stream;

public class AnyAllApp {
	public static void main(String[] args) {
		System.out.println(Stream.of(2,3,4)
			.anyMatch(x -> x%2==0) );
		
	}
}
