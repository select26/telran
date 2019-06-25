package predicate;

import java.util.function.Predicate;

import car.Car;

public class YearsRange implements Predicate<Car> {
	
	private int yearMin;
	private int yearMax;
	
	public YearsRange(int yearMin, int yearMax) {
		super();
		this.yearMin = yearMin;
		this.yearMax = yearMax;
	}

	@Override
	public boolean test(Car t) {
		return ( t.getYear()>=yearMin && t.getYear()<=yearMax );
	}

}
