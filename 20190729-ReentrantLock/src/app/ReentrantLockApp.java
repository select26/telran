package app;

public class ReentrantLockApp {

	private static final int NUM_THREADS = 10;

	public static void main(String[] args) throws InterruptedException {
		
		Thread[] threads = new Thread[NUM_THREADS];
		for (int i = 0; i < threads.length; i++) threads[i] = new Thread(new Colhoz());
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < threads.length; i++) threads[i].start();
		for (int i = 0; i < threads.length; i++) threads[i].join();
		long t2 = System.currentTimeMillis();
		System.out.println(Colhoz.zakroma + ", time is: " + (t2-t1));
	}

}
