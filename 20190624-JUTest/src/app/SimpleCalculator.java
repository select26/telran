package app;

public class SimpleCalculator implements ICalculator{

	@Override
	public int multiply(int op1, int op2) {
		
		return op1 * op2;
	}

	@Override
	public float multiply(float op1, float op2) {
		
		return op1 * op2;
	}

	@Override
	public int devide(int op1, int op2) {
		if (op2 == 0) return Integer.MAX_VALUE;
		else return op1 / op2;
	}

	@Override
	public float devide(float op1, float op2) {
		if (op2==0) return Float.NaN;
		else return op1 / op2;
	}

}
