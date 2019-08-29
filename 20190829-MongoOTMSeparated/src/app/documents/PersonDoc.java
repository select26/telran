package app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dto.PersonDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="person_otm_sep")								// Annotation for MongoDB
public class PersonDoc {

	@Id
	private int		id;
	private String 	firstName;
	private String 	lastName;
	
	public PersonDoc (PersonDto person) {
		this.id			= person.getId();
		this.firstName	= person.getFirstName();
		this.lastName	= person.getLastName();
	}

	public PersonDto getPersonDto() {
		return new PersonDto(id, firstName, lastName);
	}
}
