package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SomeThread implements Runnable {
	
	private static final int NUM_UNITS = 100_000;
//	public 	static ArrayList<Integer> ali = new ArrayList<>();
	public 	static List<Integer> ali = Collections.synchronizedList(new ArrayList<Integer>());
	
	@Override
	public void run() {
		for (int i = 0; i < NUM_UNITS; i++) addOne();
	}

	private static synchronized void addOne() {
		ali.add(1);
	}
}
