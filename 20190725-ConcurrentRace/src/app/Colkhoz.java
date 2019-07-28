package app;

import java.util.concurrent.atomic.AtomicInteger;

public class Colkhoz implements Runnable {

	private static final Object mutex = new Object();
	private static final int NUM_NUM = 100_000;
	public static int zakroma = 0;
//	public static AtomicInteger zakroma = new AtomicInteger(0);
	
	@Override
	public void run() {
		
		for (int i = 0; i < NUM_NUM; i++){ 
//			zakroma.incrementAndGet();
//			synchronized (this.getClass()) {
			synchronized (mutex) {
				zakroma++;
			}
		}
		System.out.print("d! ");
	}

}
