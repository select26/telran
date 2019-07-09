package app;

public enum MyWriter {

	Pushkin ("Alexander","Pushkin"),
	Tolstoy ("Lev", "Tolstoy"),
	Twain ("Samuel", "Clemens");
	
	String firstName;
	String lastName;
	
	private MyWriter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
}
