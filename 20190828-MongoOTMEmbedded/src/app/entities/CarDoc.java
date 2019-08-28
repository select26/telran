package app.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="car_otm")								// Annotation for MongoDB
public class CarDoc {
	
	@Id
	private String 	VIN;
	private String 	model;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate productionDate;
	private double 	engine;
	private boolean ac;
	private Person owner;
	
}
