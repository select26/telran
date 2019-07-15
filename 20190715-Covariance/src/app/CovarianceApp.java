package app;

import java.util.ArrayList;

import dto.Animal;
import dto.Dog;

public class CovarianceApp {
	public static void main(String[] args) {
		Animal[] animals = {
				new Animal("Polkan"),
				new Animal("Pashtet"),
				new Animal("Plushka"),
				new Animal("Potap"),
				new Animal("Pukan"),
		};
		
		display(animals);
		
		Dog[] dogs = {
				new Dog("Polkan",5),
				new Dog("Pashtet",6),
				new Dog("Plushka",3),
				new Dog("Potap",8),
				new Dog("Pukan",1)
		};
		
		display(dogs);
		
		ArrayList<Animal> ala = new ArrayList<>(); 
		for (Animal a : animals) ala.add(a);
		display(ala);

		ArrayList<Dog> ald = new ArrayList<>(); 
		for (Dog a : dogs) ald.add(a);
//		display(ald);
		
}
	
	public static void display(Animal[] animals) {
		for (Animal a : animals) System.out.println(a);
	}
	public static void display(ArrayList<Animal> animals) {
		for (Animal a : animals) System.out.println(a);
	}
}
