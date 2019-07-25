package app;

import java.util.ArrayList;

public class StringBuilderRaceApp {

	private static final int NUM_THREADS = 10;

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Thread> alt = new ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++) alt.add(new Thread (new SomeThread()));
//		for (Thread t : alt) t.run();
		for (Thread t : alt) t.start();
		for (Thread t : alt) t.join();
		
		System.out.println(SomeThread.sb.length());
	}

}
