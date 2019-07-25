package app;

public class FirstThreadApp {

	public static void main(String[] args) {
		Thread someTread1 = new SomeThread();
		Thread anotherTread = new Thread(new AnotherThread());
		Thread someTread3 = new SomeThread();
		someTread1.start();
		anotherTread.start();
		someTread3.start();
		System.out.println("Main thread finished.");
	}

}
