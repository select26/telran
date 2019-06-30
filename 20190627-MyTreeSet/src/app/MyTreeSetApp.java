package app;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class MyTreeSetApp {

	private static final int NUM_NUM = 10;
	static Random gen = new Random();
	public static void main(String[] args) {
		ArrayList<Integer> ali = new ArrayList<>();
		for (int i = 0; i < NUM_NUM; i++) ali.add(gen.nextInt(1000));
		System.out.println(ali);
		TreeSet<Integer> tsi = new TreeSet<>(ali);
		System.out.println(tsi);
	}

}
