package app;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import dto.Car;

public class GroupingByApp2 {

	public static void main(String[] args) {

		Map<String, List<CarForPrint>> map = Car.createCarStream(20)
				.map(c -> new CarForPrint(c))
				.collect(Collectors.groupingBy(car -> classifier(car)));
		
		for (String s : map.keySet()) {
			System.out.println(s);
			for (CarForPrint c : map.get(s)) System.out.println("\t" + c);
		}
		System.out.println();

		
		
		Map<String, Long> map1 = Car.createCarStream(20)
				.map(c -> new CarForPrint(c))
				.collect(Collectors.groupingBy(car -> classifier(car), 
													TreeMap :: new,
													Collectors.counting()
						));

		System.out.println();
		for (String s : map1.keySet()) System.out.println(s+ ": " + map1.get(s)); 
			
	}

	public static String classifier(CarForPrint c) {
		if (c.getYear() < 1995) return "3. Old";
		if (c.getYear() < 2010) return "2. Medium";
		return "1. New";
	}
}
