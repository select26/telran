package app;

import java.util.ArrayList;

public class ConcurrentArrayListApp {

	public static final int NUM_THREADS = 10;
	public static ArrayList<Thread> alt = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < NUM_THREADS; i++) alt.add(new Thread (new SomeThread()));
//		for (Thread t : alt) t.run();
		for (Thread t : alt) t.start();
		for (Thread t : alt) t.join();
		
		System.out.println(SomeThread.ali.size());
	}

}
