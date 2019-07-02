package comparators;

import java.util.Comparator;

import dto.Car;

public class EngineCarComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		return Double.compare(o1.getEngine(), o2.getEngine());
	}

}
