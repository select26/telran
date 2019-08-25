package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student {
	
	private int studentId;
	private String name;
	private int age;
	private Group group;

}
