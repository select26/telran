package comparators;

import java.util.Comparator;

import car.Car;

public class ACCarComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		boolean ac1 = o1.isAc();
		boolean ac2 = o2.isAc();
		return ac1 == ac2 ? 0 : (ac1 ? 1 : 1);
	}

}
