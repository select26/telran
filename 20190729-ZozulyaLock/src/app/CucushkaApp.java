package app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CucushkaApp {

	private static final int NUM_ZOZULAS = 10;

	public static Lock lock = new ReentrantLock();
	public static Condition condition = null;
	public static Condition nextCondition = null;
	
	public static void main(String[] args) {

		Cucushka nextCucushka = null;
		Cucushka[] forest = new Cucushka[NUM_ZOZULAS];
		for (int i = NUM_ZOZULAS; i > 0; i--) {
			condition = lock.newCondition();
			forest[i-1] = (new Cucushka(i, nextCondition, condition, nextCucushka));
			new Thread (forest[i-1]).start();						// Starting threads..
			nextCondition = condition;
			nextCucushka = forest[i-1];
		}
		
		CucushkaApp.lock.lock();
		forest[0].setFlag(false);									// Enable unsleep for 0 thread
		condition.signal();											// Unsleep 0 thread
		CucushkaApp.lock.unlock();
		
		System.out.println("main finished..");
		
	}

}
