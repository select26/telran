package comparators;

import java.util.Comparator;

import dto.Car;

public class NaturalCarComparator implements Comparator<Car>{

	public static Comparator<Car> naturalComparator = 
			(new ModelCarComparator())
			.thenComparing(new YearCarComparator())
			.thenComparing(new EngineCarComparator())
			.thenComparing(new IdCarComparator());		

	@Override
	public int compare(Car c1, Car c2) {
		return naturalComparator.compare(c1, c2);
	}

}
