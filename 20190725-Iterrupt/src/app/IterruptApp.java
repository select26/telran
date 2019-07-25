package app;

public class IterruptApp {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main started.");
		Thread someThread = new Thread( new SomeThread());
		someThread.start();
		Thread.sleep(2000);
		someThread.interrupt();
		System.out.println("Main finished.");
	}

}
