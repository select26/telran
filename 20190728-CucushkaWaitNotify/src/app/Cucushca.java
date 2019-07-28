package app;

public class Cucushca implements Runnable {
	public int instance = 0;
	public Thread next = null;
	private static Object mutex = new Object();
	private static boolean wakeup = false;

//	public Cucushca(int i, Thread next) {
//		this.instance = i;
//		this.next = next;
//	}
	public Cucushca(int i) {
		this.instance = i;
	}
	
	public void run() {
		System.out.println("Cucushka " + instance + " sleeping");

		synchronized (mutex) {
			
			try {
				while (!wakeup) mutex.wait();			// inogda potok prosypaetsya samosotyatelno
				wakeup = false;							// proveryaem, 4to nas deysvitelno razbudili
			} catch (InterruptedException e) {}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println("Cucushka " + instance + " finished");
		
		synchronized (mutex) {
			wakeup = true;
			mutex.notify();
		}
	}

	public void setNext(Thread next) {
		this.next = next;
	}

	public static Object getMutex() {
		return mutex;
	}

	public static void setMutex(Object mutex) {
		Cucushca.mutex = mutex;
	}

	public static boolean isWakeup() {
		return wakeup;
	}

	public static void setWakeup(boolean wakeup) {
		Cucushca.wakeup = wakeup;
	}
}
