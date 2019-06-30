package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class HashSetTasksApp {

	private static final int NUM_NUM = 10;
	static Random gen = new Random();
	public static void main(String[] args) {
		
		ArrayList<Integer> ali = new ArrayList<>();
		for (int i=0; i<NUM_NUM; i++) ali.add(gen.nextInt(10));
		System.out.println(ali);
		
		/*ali = new ArrayList<Integer>(new HashSet<Integer>(ali));
		System.out.println(ali);*/
		
		HashSet<Integer> fromArrayList = new HashSet<>(ali);
		int counter = 0;
		for (Integer i : ali) {
			if (fromArrayList.contains(i+1))counter++;
		}
		System.out.println(counter);
		
		LinkedHashSet<Integer> hundreds = new LinkedHashSet<>();
		for (int i=1; i< 10; i++)hundreds.add(i*100);
		for(Integer i : hundreds) System.out.println(i);

	}

	
}
