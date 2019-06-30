package application;

public class RecurtionApp {

	public static void main(String[] args) {
		
		System.out.println(factorial(10));
		
	}
	
	public static long factorial(long n) {
		return n <= 1 ? 1 : n*factorial(n - 1);
		
	}

}
