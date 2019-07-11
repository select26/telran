package enumerations;

public enum PublisherCountry {
	
	USA(0.4), Germany(0.3), France(0.2), Israel(0.1);
	
	double value;

	private PublisherCountry(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	

}
