package app;

public class SomeThread implements Runnable {

	@Override
	public void run() {
		System.out.println("SomeThread started.");
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("I'm razbuzhen!!!!");
		}
		System.out.println("SomeThread finished.");
	}

}
