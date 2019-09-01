package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Model {

//	private int		id;
	private String 	name;
	private double 	rentalPrice;
	private double 	tankVolume;
	private boolean	removed;
	
}
