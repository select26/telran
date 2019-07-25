package app;

public class AnotherThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Another thread started.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		System.out.println("Another thread finished.");
	}

}
