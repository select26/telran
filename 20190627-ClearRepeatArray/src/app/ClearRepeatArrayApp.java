package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class ClearRepeatArrayApp {

	
	private static final int NUM_NUM = 20;

	public static void main(String[] args) {
	
		Random gen = new Random();
		ArrayList<Integer> ali = new ArrayList<>();
//		HashSet<Integer> hsi = new HashSet<>(); 
		int bliznec = 0;

		for (int i = 0; i < NUM_NUM; i++) {
			ali.add(gen.nextInt(20));
		}
//		ali.add(1);
//		ali.add(1);
//		ali.add(1);
//		ali.add(1);
//		ali.add(1);
//		ali.add(1);
//		ali.add(2);
//		ali.add(3);
		
		System.out.println(ali.toString());
		
		HashSet<Integer> fromArrayList = new HashSet<>(ali);
		for (int i = 0; i < ali.size()-1; i++) {
			if (fromArrayList.contains(ali.get(i)+1)) bliznec++;
		}
		System.out.println("bliznec: " + bliznec);
		
//		for (Integer i : ali) hsi.add(i); 
//		ali.clear();
//		for (Integer i : hsi) ali.add(i);
		ali = new ArrayList<Integer>(new HashSet<Integer>(ali));
		System.out.println(ali);
	}
}
