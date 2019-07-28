package app;

public class WaitNotify1App {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("main started..");
		SomeThread sm = new SomeThread();
		Thread t1 = new Thread(sm);
		Thread t2 = new Thread(sm);
		
		t1.start();
		t2.start();
		
//		Thread.sleep(1);
		
		Object mutex = SomeThread.getMutex(); 
		synchronized (mutex) {
			sm.setWakeup(true);
			mutex.notify();
		}
		
		System.out.println("main finished..");
		
	}

}
