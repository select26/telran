package app;

public class AwaitSignalApp {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new SomeThread());
		thread.start();
		
		Thread.sleep(1000);
		
		SomeThread.lock.lock();								// Dlya raboti .condition.signal() 
		SomeThread.flag = false;							// menyaem flag
		
		SomeThread.condition.signal();						// Budim process
		SomeThread.lock.unlock();							// Snimaem blokirovku
			
		System.out.println("main finished..");
		
	}

}
