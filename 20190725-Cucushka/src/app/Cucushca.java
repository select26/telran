package app;

public class Cucushca implements Runnable {
	public int instance = 0;
	public Thread next = null;
	
	public Cucushca(int i, Thread next) {
		this.instance = i;
		this.next = next;
	}

	public void run(){
		System.out.println("Cucushka " + instance + " sleeping");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Cucushka " + instance + " running");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
//		System.out.println("Cucushka " + local + " finished");
		if (next==null) System.out.println("All done!");
		else {
			next.interrupt();
		}
	}

	public void setNext(Thread next) {
		this.next = next;
	}
}
