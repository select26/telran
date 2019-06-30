package predicates;

import java.util.function.Predicate;

import car.Car;

public class EngineRange implements Predicate<Car> {
	
	private double engineMin;
	private double engineMax;

	public EngineRange(double engineMin, double engineMax) {
		super();
		this.engineMin = engineMin;
		this.engineMax = engineMax;
	}

	@Override
	public boolean test(Car t) {
		double eng = t.getEngine();
		return (eng>=engineMin && eng<=engineMax);
	}

}
