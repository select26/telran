package application;

import java.util.function.UnaryOperator;

public class Zozula implements Runnable{
	
	private int num;
	private boolean wokeup = false;
	private UnaryOperator<Zozula> getNext;
	//private Zozula next;
	//private Object mutex = new Object();

	public Zozula(int num, UnaryOperator getNext) {
		super();
		this.num = num;
		this.getNext = getNext;
	}
	
	

	public int getNum() {
		return num;
	}


/*
	public void setNext(Zozula next) {
		this.next = next;
	}

	public Object getMutex() {
		return mutex;
	}
*/
	public void setWokeup(boolean wokeup) {
		this.wokeup = wokeup;
	}

	@Override
	public void run() {
		
		while(true) {
			synchronized (this) {
				try {
					while(!wokeup) this.wait();
					wokeup = false;
				} catch (InterruptedException e) {}
			}

			System.out.println("Zozula #"+num+": ku-ku!");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			//Zozula nextZozula = ZozulaService.getNext(this);
			Zozula nextZozula = getNext.apply(this);
			if (nextZozula != null) {
				//Object nextMutex = next.getMutex();
				synchronized (nextZozula) {
					nextZozula.setWokeup(true);
					nextZozula.notify();
				}
			}
		}

	}

}
