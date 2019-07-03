package app;

public class Chinese {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chinese(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	

}
