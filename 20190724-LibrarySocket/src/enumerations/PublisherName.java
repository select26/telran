package enumerations;

public enum PublisherName {
	
	RedStar("Red star"),
	GoldStar("Gold star"),
	BlackStar("Black star"),
	YellowStar("Yellow star"),
	BlueStar("Blue star");
	
	String value;

	private PublisherName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
