package app;

public class SomeThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Some thread started.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		System.out.println("Some thread finished.");
	}
	
}
