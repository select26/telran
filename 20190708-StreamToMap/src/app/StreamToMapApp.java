package app;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import dto.Car;
import printcar.CarForPrint;

public class StreamToMapApp {

	public static void main(String[] args) {
//		Map<Integer, CarForPrint> map = Car.createCarStream(20)
//										.collect(Collectors.toMap(
//																Car :: getId, 
//																c -> new CarForPrint(c)	));
//		for (Integer i : map.keySet()) 	System.out.println(i + "; " + map.get(i));
		
		
		Map<String, ArrayList<CarForPrint>> map = Car.createCarStream(20)
				.collect(Collectors.toMap(											// transform to Map
							car -> car.getModel(), 									// model = primary key
							car -> { ArrayList<CarForPrint> al = new ArrayList<>();	// value = ArrayList
								al.add(new CarForPrint(car));
								return al;
							},
							(a, b) ->  {a.addAll(b); return a;}						// merge all ArrayLists 
							));														// with same PrimaryKey
		for (String i : map.keySet()) System.out.println(i + ": " + map.get(i));
	
	}

}
