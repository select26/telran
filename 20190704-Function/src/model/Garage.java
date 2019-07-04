package model;

import java.util.HashMap;
import java.util.TreeSet;

import dto.Car;
import maplist.TreeListMap;

public class Garage implements IGarage {
	
	private HashMap<Integer, Car> idHM = new HashMap<>();
	private TreeListMap<String, Car> modelTM = new TreeListMap<>();
	private TreeListMap<Integer, Car> yearTM = new TreeListMap<>();
	private TreeListMap<Double, Car> engineTM = new TreeListMap<>();
	
//	private static Map<String, Tree>
	
	@Override
	public void fill(int numCar) {
		for (int i = 0; i < numCar; i++) add(Car.randomCar());
	}

	@Override
	public boolean add(Car car) {
		int id = car.getId();
		if (idHM.containsKey(id)) return false;
		idHM.put(id, car);
		
		modelTM.add(car.getModel(), car);
		yearTM.add(car.getYear(), car);
		engineTM.add(car.getEngine(), car);
		
//		String model = car.getModel();						// CarsByModel
//		TreeSet<Car> modelTS = modelTM.get(model);			//
//		if(modelTS == null) modelTS = new TreeSet<Car>();	//
//		modelTS.add(car);									//
//		modelTM.put(model, modelTS);						//
//		
//		int year = car.getYear();							// CarsByYear
//		TreeSet<Car> yearTS = yearTM.get(year);				//
//		if (yearTS==null) yearTS = new TreeSet<Car>();		//
//		yearTS.add(car);									//
//		yearTM.put(year, yearTS);							//
//		
//		Double engine = car.getEngine();					// CarsByYear
//		TreeSet<Car> engineTS = engineTM.get(engine);		//
//		if (engineTS==null) engineTS = new TreeSet<Car>();	//
//		engineTS.add(car);									//
//		engineTM.put(engine, engineTS);						//
		
		return true;
	}

	@Override
	public boolean contains(Car car) {
		return idHM.containsKey(car.getId());
	}

	@Override
	public boolean remove(Car car) {
		if (car == null) return false;
		boolean result = ( idHM.remove(car.getId()) != null );
		if (result) { 
			result = modelTM.remove(car.getModel(), car) && result;
			result = yearTM.remove(car.getYear(), car) && result;
			result = engineTM.remove(car.getEngine(), car) && result;
		}
		return result;
	}

	@Override
	public Car remove(int id) {
		Car result = idHM.get(id);
		remove(result);
		return result;
	}

	@Override
	public Car getById(int id) {
		return idHM.get(id);
	}

	@Override
	public Iterable<Car> allCars() {
		return new TreeSet<Car>(idHM.values());
	}

	@Override
	public Iterable<Car> allCarsByModel(String model) {
		TreeSet<Car> result = modelTM.get(model);
//		return result == null ? new TreeSet<Car>() : result;
		return modelTM.get(model);
	}

	@Override
	public Iterable<Car> allCarsByYearRange(int min, int max) {
		return yearTM.getInRange(min, max);
	}

	@Override
	public Iterable<Car> allCarsByEngineRange(double min, double max) {
		return engineTM.getInRange(min, max);	
	}

	@Override
	public Iterable<Car> allCarsByAC(boolean ac) {
		TreeSet<Car> result = new TreeSet<>();
		for (Car c : idHM.values()){
			if (c.isAc() == ac) result.add(c);
		}
		return result;
	}

	@Override
	public Iterable<Car> allCarsSortedByModel() {
		return modelTM.getAll();
	}

	@Override
	public Iterable<Car> allCarsSortedByYear() {
		return yearTM.getAll();
	}

	@Override
	public Iterable<Car> allCarsSortedByEngine() {
		return engineTM.getAll();
	}

}
