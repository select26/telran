package dto;

import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)

public class Child extends Person{

	private String detsad;

	public Child(String name, LocalDate birthday, String detsad) {
		super(name, birthday);
		this.detsad = detsad;
	}
}
