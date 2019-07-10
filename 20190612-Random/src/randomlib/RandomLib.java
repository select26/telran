package randomlib;

import java.time.LocalDate;
import java.util.Random;

public class RandomLib {
	private static final int ALPHABET_length = 52;
	private static final String ALPHABET = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	private static Random gen = new Random();

	public static int nextIntRange(int min, int max) {
		return min + gen.nextInt(max - min + 1);
	}

	public static double nextDoubleRange(double min, double max) {
		return min + gen.nextDouble() * (max - min);
	}

	public static boolean nextRandomBoolean(double trueProbability) {
		return gen.nextDouble() < trueProbability;
	}

	public static String nextRandomString(int num) {
		String str = "";
		for (int i = 0; i < num; i++) {
			// str.charAt(i) = Integer.gen.nextInt()
			// str = str +
			// Character.toString(ALPHABET.charAt(gen.nextInt(ALPHABET_length)));
			str = str + (ALPHABET.charAt(gen.nextInt(ALPHABET_length)));
		}
		return str;

	}

	public static String nextStringFromSet(String[] set) {
		if (set == null || set.length == 0)
			return "Array lo tov";
		return set[gen.nextInt(set.length)];
	}
	
//	static Random gen = new Random();
	public static LocalDate randomLocalDate(LocalDate begin, LocalDate end) {
		long beginDays = begin.toEpochDay();
		long endDays = end.toEpochDay();
		int diapazon = (int) (endDays - beginDays);
		return LocalDate.ofEpochDay(beginDays + gen.nextInt(diapazon));
	}
	
}