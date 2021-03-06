package app;

public enum SingletonePersonEnum {
	Sasha("Sasha", 61, 176.3, true);
	private String 	name;
	private int 	age;
	private double 	weight;
	private boolean	married;
	
	private SingletonePersonEnum(String name, int age, double weight, boolean married) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.married = married;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}
	
	
}
