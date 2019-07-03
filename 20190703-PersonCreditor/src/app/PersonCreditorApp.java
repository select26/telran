package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class PersonCreditorApp {
	private static final int NUM_NUM = 20;
	static Random rnd = new Random();
	static ArrayList<Person> alp = new ArrayList<Person>();
	
	public static void main(String[] args) {
		alp = randomPersons(NUM_NUM);
		
//		System.out.println("alp size: "+alp.size());
		for (int i = 0; i < alp.size(); i++) {
			Person creditor = alp.get(rnd.nextInt(NUM_NUM));
			if (creditor == alp.get(i)) {
				System.err.println("Crossrefference!!");
				while (creditor == alp.get(i)) creditor = alp.get(rnd.nextInt(NUM_NUM));
			}
//			System.out.println(i + " Person: " + alp.get(i).getName() + ", creditor: "+ creditor.getName());
			alp.get(i).setCreditor(creditor);
		}
		
//		for (Person p : alp)
		for (int i = 0; i < NUM_NUM; i++) {
			System.out.println(i + "\t" + alp.get(i).getName() + "\t"+ alp.get(i).getCreditor().getName());
		}
		
		foundMaxCreditor();
	}
	
	private static void foundMaxCreditor () {
		ArrayList<Person> myTS = new ArrayList<>();
		// Заполним массив
//		for (Person pers : alp) {
		for (int i = 0; i < alp.size(); i++) {
			Person pers = alp.get(i).getCreditor();
			if (myTS.contains(pers)) {
//				System.out.println("++!");
				int localNOC = myTS.get(myTS.indexOf(pers)).getNumOfCreditors();
				myTS.get(myTS.indexOf(pers)).setNumOfCreditors(localNOC+1);
			} else {
//				System.out.println(pers.getName() + "++");
				pers.setNumOfCreditors(1);
				myTS.add(pers);
			}
		}
		//Найдем мах. значение
		int max	= 0;
		int indexMax = 0;
		for (int i = 0; i < myTS.size(); i++) {
			int currentNumOfCreditirs = myTS.get(i).getNumOfCreditors(); 
			if ( currentNumOfCreditirs > max) {
				max = currentNumOfCreditirs;
				indexMax = i;
			}
		}
		System.out.println("Max count of debitors = " + max + ". Debitor: " + myTS.get(indexMax).getName());
	}
	
	public static ArrayList<Person> randomPersons(int num) {
//		Random rnd = new Random();
		String[] personName = {"Vasily", "Vladimir", "Vitaly", "Viktor", "Voldemar", "Vikenty",
							   "Vasily1", "Vladimir1", "Vitaly1", "Viktor1", "Voldemar1", "Vikenty1",
							   "Vasily2", "Vladimir2", "Vitaly2", "Viktor2", "Voldemar2", "Vikenty2",
							   "Vasily3", "Vladimir3", "Vitaly3", "Viktor3", "Voldemar3", "Vikenty3",
							   "Vasily4", "Vladimir4", "Vitaly4", "Viktor4", "Voldemar4", "Vikenty4",
								};
		ArrayList<Person> alp2 = new ArrayList<>(); 
		for (int i = 0; i < num; i++) {
			Person newPerson = new Person(personName[rnd.nextInt(personName.length-1)], null);
			alp2.add(newPerson);
//			System.out.println(i + "\t" + newPerson.getName());
		}
		return alp2;
	}

}
