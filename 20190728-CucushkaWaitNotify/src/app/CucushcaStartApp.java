package app;

import java.util.ArrayList;

public class CucushcaStartApp {

	static final int NUM_CUCUSHCA = 10;
	public static ArrayList<Thread> alt = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		Object mutex = Cucushca.getMutex(); 
		
		Thread temp = null;
//		Thread temp2 = null;
		for (int i = NUM_CUCUSHCA; i >0 ; i--) {
			temp = new Thread(new Cucushca(i));
			alt.add(temp);
//			temp2 = temp;
//			Thread.sleep(10);						// narushaetsya poryadok!!
		}
//		System.out.println(alt);
		for (Thread t : alt) {
			t.start();
			Thread.sleep(20);						// narushaetsya poryadok!!
		}

		Thread.sleep(1000);

		System.out.println("All started!");
		synchronized (mutex) {
			Cucushca.setWakeup(true);
			mutex.notify();
		}
	}

}
