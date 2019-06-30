package app;

import java.util.Arrays;

public class SplitJoinApp {

	public static void main(String[] args) {
		String data = "Sasha\t;62  ;176.5;true";
		
		String[] elements = data.trim().split(";");
		System.out.println(Arrays.toString(elements));
		
		for (int i = 0; i < elements.length; i++) {
			elements[i] = elements[i].trim();
		}
		
		System.out.println(Arrays.toString(elements));
		
		System.out.println(String.join(",", elements));

		
		System.out.println("exiting...");

	}

}
