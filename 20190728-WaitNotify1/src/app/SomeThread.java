package app;

public class SomeThread implements Runnable{

	private static Object mutex = new Object();
	private static boolean wakeup = false;
	
	public static void setWakeup(boolean wakeup) {
		SomeThread.wakeup = wakeup;
	}

	@Override
	public void run() {
		System.out.println("child entered..");
		
		synchronized (mutex) {
			
			try {
				while (!wakeup) mutex.wait();			// inogda potok prosypaetsya samosotyatelno
//				wakeup = !wakeup;						// proveryaem, 4to nas deysvitelno razbudili
			} catch (InterruptedException e) {}
		}
		System.out.println("child finished..");
	}

	public static Object getMutex() {
		return mutex;
	}

}
