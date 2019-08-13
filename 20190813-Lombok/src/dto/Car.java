package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
//@Data

public class Car {
	
	private String model;
	private int year;
	private double engine;
	private boolean ac;
}
