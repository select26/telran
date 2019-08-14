package dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Person {
	
	private String 		FirstName;
	private String 		LastName;
	private Address 	address; 
	private Contact[] 	contacts;
	@JsonFormat(pattern = "yyyy_MMM_dd")
	private LocalDate	birthday;
	
}
