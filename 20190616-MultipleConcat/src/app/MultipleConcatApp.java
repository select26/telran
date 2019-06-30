package app;

public class MultipleConcatApp {

	private static final int NUM_HELLO = 100000;

	public static void main(String[] args) {
		String hello = "hello";
		String result = "";
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_HELLO; i++) {
			result = result + hello;
		} 
		long t2 = System.currentTimeMillis();
		System.out.println("Cincatenation time: " + (t2 - t1) + "ms");

		t1 = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 0; i < NUM_HELLO; i++) {
			stringBuilder.append(hello);
		}
		t2 = System.currentTimeMillis();
		System.out.println("Appedinding time: " + (t2 - t1) + "ms");
	
	}
	

}
