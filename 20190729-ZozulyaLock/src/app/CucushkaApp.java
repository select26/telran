package app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CucushkaApp {

	private static final int NUM_ZOZULAS = 3;

	public static Lock lock = new ReentrantLock();
	public static Condition condition = null; // = lock.newCondition();
	public static Condition nextCondition = null;
	
	public static void main(String[] args) {

//		Thread[] forest = new Thread[NUM_ZOZULAS];
//		for (int i = NUM_ZOZULAS; i > 0; i--) {
//			condition = lock.newCondition();
//			forest[i-1] = new Thread(new Cucushka(i, nextCondition, condition));
//			nextCondition = condition;
//		}
		Cucushka nextCucushka = null;
		Cucushka[] forest = new Cucushka[NUM_ZOZULAS];
		for (int i = NUM_ZOZULAS; i > 0; i--) {
			condition = lock.newCondition();
			forest[i-1] = (new Cucushka(i, nextCondition, condition, nextCucushka));
			new Thread (forest[i-1]).start();
			nextCondition = condition;
			nextCucushka = forest[i-1]; 
		}
		
//		for (int i=0; i<NUM_ZOZULAS; i++) forest[i].start();
		
		CucushkaApp.lock.lock();
		forest[0].flag = false;
//		forest[1].flag = false;
//		forest[2].flag = false;
//		forest[3].flag = false;
		condition.signal();
		CucushkaApp.lock.unlock();
		
		System.out.println("main finished..");
		
	}

}
