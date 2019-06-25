package app;

import model.Kolhoz;

public class AgricultureApp {

	public static void main(String[] args) {
		Kolhoz[] village = new Kolhoz[3];
		for (int i = 0; i < village.length; i++) {
			village[i] = new Kolhoz();
		}
		
		for (int i = 0; i < village.length; i++) {
			village[i].harvest();
		}

		for (int i = 0; i < village.length; i++) {
			System.out.println(village[i].getZakroma());
		}
	}

}
