package app;

import java.util.Arrays;
import java.util.TreeMap;

import enumerations.MyDayOfWeek;

public class EnumsApp {

	public static void main(String[] args) {
		
		MyDayOfWeek[] dows = {	MyDayOfWeek.Saturday,							//new DayOfWeek 
								MyDayOfWeek.Sunday,
								MyDayOfWeek.Friday
		};
		
		System.out.println(Arrays.toString(dows));
		Arrays.sort(dows);
		System.out.println(Arrays.toString(dows));
		System.out.println(MyDayOfWeek.Monday.ordinal());
		System.out.println(MyDayOfWeek.values()[6]);
		
		TreeMap<MyDayOfWeek, Integer> dowMap = 
				new TreeMap<>();
		for( MyDayOfWeek day : MyDayOfWeek.values() ) 
			dowMap.put(day, day.ordinal());

		System.out.println(dowMap);
		System.out.println();

		RightNames[] arr = RightNames.values();
		System.out.println(arr[0].value);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, (a,b) -> a.getValue().compareTo(b.getValue()));
		System.out.println(Arrays.toString(arr));
//		for (RightNames rn : arr) System.out.print(rn.getValue() + " ");
		
		for (MyWriter w : MyWriter.values()) 
			System.out.println(w + ": " + w.getFirstName() + " " + w.getLastName());
	}

}
