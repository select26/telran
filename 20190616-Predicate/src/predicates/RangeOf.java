package predicates;

import java.util.function.Predicate;

public class RangeOf implements Predicate<Integer>{

	private int Min;
	private int Max;
	
	public RangeOf(int min, int max) {
		super();
		Min = min;
		Max = max;
	}

	@Override
	public boolean test(Integer i) {
		return (i<=Max && i>=Min);
	}
}
