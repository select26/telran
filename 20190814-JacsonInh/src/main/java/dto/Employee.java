package dto;

import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)

public class Employee extends Person{

	private double salary;

	public Employee(String name, LocalDate birthday, double salary) {
		super(name, birthday);
		this.salary = salary;
	}
	
}
