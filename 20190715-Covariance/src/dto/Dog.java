package dto;

public class Dog extends Animal{

	private int age;

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age) {
		super(name);
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString() + "Dog [age=" + age + "]";
	}

	
}
