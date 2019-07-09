package app;

public enum RightNames {

	Sunday ("rishon"),
	Monday ("sheni"),
	Thusday ("shishi"),
	Wednesday ("ravii"),
	Thursday ("hamishi"),
	Friday ("shlishi"),
	Saturday ("shabbat");

	public String value;

	private RightNames(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	@Override
	public String toString() {
		return value;
	}
	
}
