package dto;

import annotations.Getter;
import annotations.Setter;

public class Person {
	
	private int id;
	private String name;
	private double salary;
	
	@Getter(field="id")
	public int poll1() {
		return id;
	}
	@Setter(field="id")
	public void put2(int id) {
		this.id = id;
	}
	@Getter(field="name")
	public String poll3() {
		return name;
	}
	@Setter(field="name")
	public void put4(String name) {
		this.name = name;
	}
	@Getter(field="salary")
	public double poll5() {
		return salary;
	}
	@Setter(field="salary")
	public void put6(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
