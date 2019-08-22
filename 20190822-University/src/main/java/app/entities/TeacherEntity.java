package app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import dto.Teacher;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="teacher")
public class TeacherEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int		id_teacher; 
	
	private String firstName;
	private String lastName;
	// one country to many cities
	// mapped by - creates foreign keys with countryEntity
	// cascade - type of connection between tables in case of changing/deleting country - changes/deleting cities
	@OneToMany(mappedBy="teacherEntity", cascade=CascadeType.ALL)
	@JsonManagedReference //used to preserve recursion when creating JSON of city and country, ManagedReference - is used from the side of one to many
	private Set<GroupEntity> groups = new HashSet<>();
	
	public TeacherEntity(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public TeacherEntity(Teacher teacher){
		this(teacher.getFirstName(), teacher.getLastName());
	}
	
	public Teacher EntityToTeacher(){
		return new Teacher(firstName, lastName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherEntity other = (TeacherEntity) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id_teacher != other.id_teacher)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id_teacher;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
}
