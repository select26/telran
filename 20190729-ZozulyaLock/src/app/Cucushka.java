package app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cucushka implements Runnable{
	private int num;
	public boolean flag = true;
	private Cucushka next = null;
	
	public static Condition condition = null;
	public static Condition nextCondition = null;

	public static Cucushka nextCucushka = null;
	
	public Cucushka(int num, Condition nextCondition, Condition condition, Cucushka nextCucushka) {
		super();
		this.num = num;
		this.condition = condition;
		this.nextCondition = nextCondition;
		this.nextCucushka = nextCucushka;
	}

	@Override
	public void run() {
		
		System.out.println("Cucushka " + num + " started..");

		CucushkaApp.lock.lock();
		try {
			while (flag)									//Zashita ot sluuchainogo
				try {
					condition.await();						//probuzhdemiya
				} catch (InterruptedException e) {} 
		} finally {
			CucushkaApp.lock.unlock();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		System.out.println("Cucushka " + num + " finished..");
		
		if (nextCucushka != null) {
			nextCucushka.flag = false;
			CucushkaApp.lock.lock();
			nextCondition.signal(); 
			CucushkaApp.lock.unlock();
		}
			
	}
	
}
