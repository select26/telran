package dto;

import java.util.HashSet;
import java.util.Set;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Country {
	
	private String country;
	private Set<City> cities = new HashSet<City>();
}
