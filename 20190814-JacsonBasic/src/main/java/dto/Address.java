package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {

	private String 	city;
	private String 	street;
	private int 	bldg;
	private int 	apt;
	
}
