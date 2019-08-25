package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Teacher {
	
	private int teacherId;
	private String firstName;
	private String lastName;

}
