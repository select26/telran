package predicates;

import java.util.function.Predicate;

public class MultOfN implements Predicate<Integer>{

	private int n;
		
	public MultOfN(int n) {
		super();
		this.n = n;
	}

	@Override
	public boolean test(Integer i) {
		return i%n == 0;
	}

}
