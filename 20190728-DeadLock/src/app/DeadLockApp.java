package app;

public class DeadLockApp {

	public static void main(String[] args) {
		Thread threadFirst = new Thread(new First());
		Thread threadSecond = new Thread(new Second());
		threadFirst.start();
		threadSecond.start();
	}

}
