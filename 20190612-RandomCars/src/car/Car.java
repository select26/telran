package car;

import randomlib.RandomLib;

public class Car implements Comparable<Car>{

	private static final String[] CAR_MODELS = {"TOYOTA", "VOLGA", "FORD",
						"MERCEDES", "MAZDA", "NISSAN", "LEXUS", "YAMAHA", "TESLA"};
	private static final int MIN_YEAR = 1980;
	private static final int MAX_YEAR = 2019;
	private static final double MIN_ENGINE = 1.0;
	private static final double MAX_ENGINE = 4.7;
	private static final int MIN_AC_YEAR = 2000;
	private static final double AC_PROBABILITY = 0.3;
	private String model;
	private int year;
	private double engine;
	private boolean ac;
	
	
	public Car(String model, int year, double engine, boolean ac) {
		super();
		this.model = model;
		this.year = year;
		this.engine = engine;
		this.ac = ac;
	}
	
	public Car() {
		super();
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getEngine() {
		return engine;
	}
	public void setEngine(double engine) {
		this.engine = engine;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	@Override
	public String toString() {
//		return "Car [model=" + model + ", year=" + year + ", engine=" + engine + ", ac=" + ac + "]";
		return "Car [model: " + model + ", year: " + year + ", engine: " 
							 + String.format("%.1f", engine) 
							 + ", AC: " + (ac? "yes" : "no") + "]"; 
	}
	
	public static Car randomCar() {
		String randomModel  = RandomLib.nextStringFromSet(CAR_MODELS);
		int randomYear      = RandomLib.nextIntRange(MIN_YEAR, MAX_YEAR);
		double randomEngine = RandomLib.nextDoubleRange(MIN_ENGINE, MAX_ENGINE);
		boolean randomAC	= randomYear < MIN_AC_YEAR ? 
							  false: RandomLib.nextRandomBoolean(AC_PROBABILITY);
		return new Car(randomModel, randomYear, randomEngine, randomAC);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ac ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(engine);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (ac != other.ac)
			return false;
		if (Double.doubleToLongBits(engine) != Double.doubleToLongBits(other.engine))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public int compareTo(Car other) {
		int modelComp = model.compareTo(other.model);
		return modelComp != 0 ? modelComp : (year - other.year); 
	}
	
	public static Car[] getRandomGarageArray(int n) {
		if (n < 0) n=0;
		Car[] result = new Car[n];
		for (int i = 0; i < n; i++) result[i] = randomCar();
		return result;
	}
}
