package app;

import java.util.ArrayList;

public class ConcurrentRaceApp {

	private static final int NUM_COLHOZ = 10;

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Thread> alt = new ArrayList<>();
		for (int i = 0; i < NUM_COLHOZ; i++) alt.add(new Thread(new Colkhoz()));
		for (Thread t : alt) t.start();
//		for (Thread t : alt) t.join();

		Thread.sleep(3000);
		
		System.out.println("V colhoze:" + Colkhoz.zakroma);
	}

}
