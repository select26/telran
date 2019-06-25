package comparators;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

	@Override
	// Snacala 4etnie po ubivaniu, potom ne4tnie po vozrastaniu
	public int compare(Integer i1, Integer i2) {
		boolean e1 = (i1 % 2 == 0);
		boolean e2 = (i2 % 2 == 0);
		if (e1 == e2) {
			return e1 ? i2 - i1 : i1 - i2;
		}
		return e1 ? -1 : 1;
	}
	
}
