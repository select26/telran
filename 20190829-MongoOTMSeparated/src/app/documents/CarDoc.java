package app.documents;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import dto.CarDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="car_otm_sep")								// Annotation for MongoDB
public class CarDoc {
	
	@Id
	private String 	VIN;
	private String 	model;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate productionDate;
	private double 	engine;
	private boolean ac;
	private int ownerId;
	
	public CarDoc(CarDto car) {
		this.VIN		= car.getVIN();
		this.model		= car.getModel();
		this.productionDate = car.getProductionDate();
		this.engine		= car.getEngine();
		this.ac			= car.isAc();
		this.ownerId 	= car.getOwner().getId();
	}
	
	public CarDoc(String vIN, String model, LocalDate productionDate, double engine, boolean ac) {
		super();
		VIN 			= vIN;
		this.model 		= model;
		this.productionDate = productionDate;
		this.engine 	= engine;
		this.ac 		= ac;
	}
	
	public CarDto getCarDto(PersonDoc person) {
		return new CarDto(VIN, model, productionDate, engine, ac,
							person.getPersonDto());
	}
}
