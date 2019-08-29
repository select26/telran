package dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {

	private String 	VIN;
	private String 	model;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate productionDate;
	private double 	engine;
	private boolean ac;
	private PersonDto owner;
	
}
