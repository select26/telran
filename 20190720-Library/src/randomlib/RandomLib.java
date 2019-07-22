package randomlib;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLib {
	
	private static final int ALPHABET_LENGTH = 62;
	private static final String ALPHABET = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static Random gen = new Random();
	
	public static int nextIntRange(int min, int max) {
		return min + gen.nextInt(max - min + 1);
	}
	
	public static long nextLongRange(long min, long max) {
		return ThreadLocalRandom.current().nextLong(min, max+1);
	}
	
	public static double nextDoubleRange(double min, double max) {
		return min + gen.nextDouble()*(max - min);
	}
	
	public static boolean nextRandomBoolean(double trueProbability) {
		return gen.nextDouble() < trueProbability;
	}
	
	public static String nextRandomString(int len) {
		String result = "";
		for (int i = 0; i < len; i++)
			result = result +
				ALPHABET.charAt(gen.nextInt(ALPHABET_LENGTH));
		return result;
	}
	
	public static String nextStringFromSet(String[] set) {
		if (set == null || set.length == 0) return "ha-ha-ha";
		return set[gen.nextInt(set.length)];
	}
	
	public static <T>T randomOfArray(T[] arr) {
		int arrLength = arr.length;
		return arrLength == 0 ? null : arr[gen.nextInt(arrLength)];
	}
	
	public static <T>T randomOfList(List<T> list) {
		int listSize = list.size();
		return listSize == 0 ? null : list.get(gen.nextInt(listSize));
	}
	
	public static LocalDate randomLocalDate(LocalDate from, LocalDate to) {
		long epochDaysFrom = from.toEpochDay();
		long epochDaysTo = to.toEpochDay();
		return LocalDate.ofEpochDay(ThreadLocalRandom.current()
				.nextLong(epochDaysFrom, epochDaysTo+1));
	}

}
