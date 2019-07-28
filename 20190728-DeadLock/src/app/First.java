package app;

public class First implements Runnable {

	@Override
	public void run() {
		System.out.println("First running..");

		synchronized (MutexStorage.mutex1) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			System.out.println("Firts wake up!");

			synchronized (MutexStorage.mutex2) {
				System.out.println("First in the second syncronized block..");
			}
		}
	}

}
