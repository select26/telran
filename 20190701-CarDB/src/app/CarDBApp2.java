package app;

import java.util.ArrayList;

import dto.Car;
import dto.CarComparators;
import randomlib.RandomLib;

public class CarDBApp2 {

	private static final int NUM_NUM = 15;

	public static void main(String[] args) {

		ArrayList<Car> alc = new ArrayList<>();
		for (int i = 0; i < NUM_NUM; i++) alc.add(Car.randomCar());
		for (Car c : alc) System.out.println(c); System.out.println("===========================================");
		alc.sort(CarComparators.modelCarComparator);
		for (Car c : alc) System.out.println(c); System.out.println("===========================================");
		
	}

}
