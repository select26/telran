package app;

public class ThreadAsLambdaApp {

	public static void main(String[] args) {
//		Thread thread = 
		new Thread( () -> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {};
			System.out.println("thread");
		}).start();;
//		thread.start();
		System.out.println("main");
	}

}
