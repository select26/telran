package app.docs;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dto.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="rc_model")								// Annotation for MongoDB
public class ModelDoc {
	@Id
	private String 	name;
	private double 	rentalPrice;
	private double 	tankVolume;
	private boolean removed;

	public ModelDoc(Model model) {
		this.name	= model.getName();
		this.rentalPrice = model.getRentalPrice();
		this.tankVolume	 = model.getTankVolume();
		this.removed	 = model.isRemoved();
	}
}
