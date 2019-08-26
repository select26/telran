package app.entities;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.*;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class EmployeeId implements Serializable{

	private String 	firstName;
	private String 	lastName;

}
