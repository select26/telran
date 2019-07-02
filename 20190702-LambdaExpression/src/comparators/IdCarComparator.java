package comparators;

import java.util.Comparator;

import dto.Car;

public class IdCarComparator implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return Integer.compare(c1.getId(), c2.getId());
	}

}
