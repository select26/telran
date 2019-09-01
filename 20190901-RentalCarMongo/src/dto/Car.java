package dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

	private String vin;
//	private String 	model;
	private Model 	model;
	private boolean inUse	 = false;
	private boolean removed	 = false;
	
//	public Car(String vIN, Model model) {
//		super();
//		VIN = vIN;
//		this.model = model;
//		this.inUse = false;
//		this.removed = false;
//	}
	
//	@JsonFormat(pattern="yyyy-MM-dd")
//	private LocalDate productionDate;
//	private double 	engine;
//	private boolean ac;
//	private PersonDto owner;
	
}
