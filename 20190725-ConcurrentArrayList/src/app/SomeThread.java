package app;

import java.util.ArrayList;

public class SomeThread implements Runnable {
	
	private static final int NUM_UNITS = 100_000;
	public 	static ArrayList<Integer> ali = new ArrayList<>();
	
	@Override
	public void run() {
		for (int i = 0; i < NUM_UNITS; i++) addOne();
	}

	private static synchronized void addOne() {
		ali.add(1);
	}
}
