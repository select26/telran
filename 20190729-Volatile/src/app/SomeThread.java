package app;

public class SomeThread implements Runnable{

	@Override
	public void run() {
	
		while (Container.flag);
		
		System.out.println("SomeThread finished..");
	}
	
}
