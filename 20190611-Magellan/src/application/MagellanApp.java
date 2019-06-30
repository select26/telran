package application;

public class MagellanApp {

	public static void main(String[] args) {
		
		long ship1 = 1;
		long ship2 = 0;

		while (ship1 > ship2) {
			ship1++;
			ship2++;
		}
		System.out.println(ship1);
		System.out.println(ship2);
		System.out.println(50_000*50_000);
	}

}
