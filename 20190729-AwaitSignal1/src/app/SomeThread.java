package app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SomeThread implements Runnable{

	public static Lock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	public static boolean flag = true;
	
	@Override
	public void run() {
		
		lock.lock();
		try {
			while (flag)									//Zashita ot sluuchainogo
				try {
					condition.await();						//probuzhdemiya
				} catch (InterruptedException e) {} 
		} finally {
			lock.unlock();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		System.out.println("SomeThread finished..");
	}

}
