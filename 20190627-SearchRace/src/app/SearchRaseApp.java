package app;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchRaseApp {

	private static final int NUM_NUM = 1_000_000;
	private static final int NUM_ITER = 1000;

	public static void main(String[] args) {

		ArrayList<Integer> ali = new ArrayList<>();
		HashSet<Integer> hsi = new HashSet<>(); 
		
		for (int i = 0; i < NUM_NUM; i++) {
			ali.add(i);
			hsi.add(i);
		}
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_ITER; i++) {
			ali.contains(-1);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Time for ArrayList: " + (t2-t1) + " ms");
		
		t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_ITER * 10_000; i++) {
			hsi.contains(-1);
		}
		t2 = System.currentTimeMillis();
		System.out.println("Time for HashSet: " + (t2-t1) + " ms");
	}

}
