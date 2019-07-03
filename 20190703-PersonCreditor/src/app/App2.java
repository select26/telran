package app;

import java.util.Random;
import java.util.TreeSet;

public class App2 {
	private static final int NUM_NUM = 1;
	static Random rnd = new Random();
	static String[] personName = {"Vasily", "Vladimir", "Vitaly", "Viktor", "Voldemar", "Vikenty",
			   "Vasily1", "Vladimir1", "Vitaly1", "Viktor1", "Voldemar1", "Vikenty1",
			   "Vasily2", "Vladimir2", "Vitaly2", "Viktor2", "Voldemar2", "Vikenty2",
			   "Vasily3", "Vladimir3", "Vitaly3", "Viktor3", "Voldemar3", "Vikenty3",
			   "Vasily4", "Vladimir4", "Vitaly4", "Viktor4", "Voldemar4", "Vikenty4",
				};
	
	public static void main(String[] args) {
		TreeSet<Person> mainTS = new TreeSet<>();
		for (int i = 0; i < NUM_NUM; i++) {
//			mainTS.add(new Person(personName[rnd.nextInt(NUM_NUM)], null)); 
			mainTS.add(new Person("dfsef", null));
		}
		
	}

}
