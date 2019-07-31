package accumulator;

public class DoubleAverageAccumulator {

	private double sum = 0;
	private int counter = 0;
	
	public DoubleAverageAccumulator() {
		super();
	}

	public DoubleAverageAccumulator(DoubleAverageAccumulator acc) {
		super();
		this.sum = acc.sum;
		this.counter = acc.counter;
	}

	public DoubleAverageAccumulator(double sum, int counter) {
		super();
		this.sum = sum;
		this.counter = counter;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
