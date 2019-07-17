package app;

import java.util.ArrayList;
import java.util.stream.Collectors;

import dto.Man;

public class BoundedGenericApp {

	public static void main(String[] args) {
		ArrayList<Man> people = new ArrayList<>();
		people.add(new Man(20.));
		people.add(new Man(15.));
		people.add(new Man(25.));
		people.add(new Man(30.));
		
		System.out.println(sortObjects(people));
	}

	public static <T extends Comparable<T>> ArrayList<T> sortObjects(ArrayList<T> orig) {
		return orig.stream()
					.sorted()
					.collect(Collectors.toCollection(ArrayList<T>::new));
	}
}
