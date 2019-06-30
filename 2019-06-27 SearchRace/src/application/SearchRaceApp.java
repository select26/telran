package application;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchRaceApp {

	private static final int NUM_NUM = 1000000;
	private static final int NUM_ITER = 100;

	public static void main(String[] args) {
		
		ArrayList<Integer> ali = new ArrayList<>();
		HashSet<Integer> hsi = new HashSet<>();
		
		for (int i = 0; i<NUM_NUM; i++) {
			ali.add(i);
			hsi.add(i);
		}
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i<NUM_ITER; i++) {
			ali.contains(-1);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("ArrayList: "+(t2-t1)+"ms");
		
		t1 = System.currentTimeMillis();
		for (int i = 0; i<NUM_ITER*1000000; i++) {
			hsi.contains(-1);
		}
		t2 = System.currentTimeMillis();
		System.out.println("HashSet: "+(t2-t1)+"ms");

	}

}
