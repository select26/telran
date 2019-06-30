package app;

import java.util.Random;

import model.MyHashSet;

public class MyHashSetApp {

	private static final int NUM_NUM = 12;
	static Random gen = new Random();
	
	public static void main(String[] args) {
		MyHashSet<Integer> hsi = new MyHashSet<>();
		for (int i = 0; i < NUM_NUM; i++)  hsi.add(gen.nextInt(800));
//		for (int i = 0; i < NUM_NUM; i++)  hsi.add(i);
		hsi.display();
		System.out.println(hsi.size());
		
		hsi.add(-657);
		hsi.add(-57);
		hsi.add(-65);
		hsi.display();
		
		for (Integer i : hsi)System.out.print(i+"  ");
		System.out.println();
		
//		System.out.println(hsi.contains(50));
//		System.out.println(hsi.remove(50));
//		hsi.display();
//		System.out.println(hsi.size());
	}

}
