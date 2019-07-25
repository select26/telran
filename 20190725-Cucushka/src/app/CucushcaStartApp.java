package app;

import java.util.ArrayList;

public class CucushcaStartApp {

	static final int NUM_CUCUSHCA = 10;
	public static ArrayList<Thread> alt = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		
		Thread temp = null;
		Thread temp2 = null;
		for (int i = NUM_CUCUSHCA; i >0 ; i--) {
			temp = new Thread(new Cucushca(i,temp2));
			alt.add(temp);
			temp2 = temp;
		}
		System.out.println(alt);
		for (Thread t : alt) t.start();

		Thread.sleep(2000);
		alt.get(9).interrupt();
	}

}
