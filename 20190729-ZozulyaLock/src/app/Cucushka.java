package app;

import java.util.concurrent.locks.Condition;

public class Cucushka implements Runnable{
	private int num;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Condition condition = null;
	public Condition nextCondition = null;
	public Cucushka nextCucushka = null;
	
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
			while (flag)									// Protect from random unsleeping
				try {
					condition.await();						// Go to sleep
				} catch (InterruptedException e) {}
		} finally {
			CucushkaApp.lock.unlock();
		}
		
		try {
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				Thread.sleep(100);
			}
			System.out.print(". ");
		} catch (InterruptedException e) {}
		
		System.out.println("Cucushka " + num + " finished..");
		
		if (nextCucushka != null) {
			nextCucushka.setFlag(false);					// Enable unsleep next Cucushka
			CucushkaApp.lock.lock();
			nextCondition.signal(); 						// Unsleeping next Cucushca
			CucushkaApp.lock.unlock();
		}
			
	}
}
