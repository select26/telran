package app;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import dto.Car;
import printcar.CarForPrint;

public class StreamToMapApp2 {

	public static void main(String[] args) {
		
		Map<String, ArrayList<CarForPrint>> map = Car.createCarStream(20)
				.collect(Collectors.toMap(											// transform to Map
							car -> car.getModel(), 									// model = primary key
							car -> { ArrayList<CarForPrint> al = new ArrayList<>();	// value = ArrayList
								al.add(new CarForPrint(car));
								return al;
							},
							(a, b) ->  {a.addAll(b); return a;},					// merge all ArrayLists with same PrimaryKey
							TreeMap :: new											// type of result
							));				

		for (String i : map.keySet()) System.out.println(i + ": " + map.get(i));
	
	}

}
