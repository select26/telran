package app;

public class Second implements Runnable {

	@Override
	public void run() {
		System.out.println("Second running..");

		synchronized (MutexStorage.mutex2) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			System.out.println("Second wake up!");

			synchronized (MutexStorage.mutex1) {
				System.out.println("Second in the second syncronized block..");
			}
		}
	}

}
