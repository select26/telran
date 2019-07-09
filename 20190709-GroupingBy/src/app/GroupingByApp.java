package app;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dto.Car;

public class GroupingByApp {

	public static void main(String[] args) {

		Map<String, List<CarForPrint>> map = Car.createCarStream(20)
				.map(c -> new CarForPrint(c))
				.collect(Collectors.groupingBy(car -> classifier(car)));
		
//		System.out.println(map);
		for (String s : map.keySet()) {
			System.out.println(s);
			for (CarForPrint c : map.get(s)) System.out.println("\t" + c);
		}
		System.out.println();
	}

	public static String classifier(CarForPrint c) {
		if (c.getYear() < 1995) return "Old";
		if (c.getYear() < 2010) return "Medium";
		return "New";
	}
}
