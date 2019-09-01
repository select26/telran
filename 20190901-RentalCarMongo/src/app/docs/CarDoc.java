package app.docs;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dto.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="rc_car")								// Annotation for MongoDB
public class CarDoc {
	
	@Id
	private String 	VIN;
	private String 	model;
	private boolean inUse;
	private boolean removed;
	
	public CarDoc(Car car) {
		this.VIN 	 = car.getVin();
		this.model 	 = car.getModel().toString();
		this.inUse 	 = car.isInUse();
		this.removed = car.isRemoved();
	}	
}
