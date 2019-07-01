package app;

import java.time.Clock;
import java.time.Instant;

import dto.Car;
import model.Garage;

public class CarDBApp {

	public static void main(String[] args) {
		
		Garage garage = new Garage();
		garage.fill(20);
		garage.add(new Car(123456789,"ALFAROMEO", 2008, 3.2, true));
//		for(Car c : garage.allCarsByModel("TOYOTA")) System.out.println(c);
//		for(Car c : garage.allCarsByAC(true)) System.out.println(c);
//		garage.remove(123456789);
		for(Car c : garage.allCarsSortedByEngine()) System.out.println(c);
		System.out.println("*************************");
		for(Car c : garage.allCarsByEngineRange(1.5, 1.8)) System.out.println(c);
	}

}
