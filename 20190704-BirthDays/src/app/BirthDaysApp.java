package app;

import java.util.HashSet;
import java.util.Random;

public class BirthDaysApp {

	private static final int NUM_PERSON = 28;
	private static final int NUM_DAYS = 365;
	private static final int NUM_ROOMS = 100;
	static Random gen = new Random();
	public static void main(String[] args) {
		int counter = 0;
		for (int i = 0; i < NUM_ROOMS; i++) {
			if (makeRoom()) counter++;
		}
		System.out.println(counter);
	}

	public static boolean makeRoom() {
		HashSet<Integer> room = new HashSet<>();
		for (int i = 0; i < NUM_PERSON; i++) {
			if (!room.add(gen.nextInt(NUM_DAYS))) return true;
		}
		return false;
	}
	
}
