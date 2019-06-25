package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubListApp {

	private static final int NUM_NUM = 10;
	static Random gen = new Random();
	public static void main(String[] args) {

		ArrayList<Integer> ali = new ArrayList<>();
		for (int i = 0; i < NUM_NUM; i++) ali.add(gen.nextInt(10));
		System.out.println(ali);
		List<Integer> sub = ali.subList(2, 7);
		System.out.println(sub);
		
		sub.set(2, 888);
		System.out.println(ali);
		System.out.println(sub);

		System.out.println("++++++++++++++++++++++++++++++++++");
		ArrayList<Integer> range = new ArrayList<>(sub);
		
		System.out.println(range);
		range.set(2, 69);
		System.out.println(range);
		System.out.println(sub);
		
	}

}
