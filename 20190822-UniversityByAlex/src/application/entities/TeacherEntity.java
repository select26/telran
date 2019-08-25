package application.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dto.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="teacher")

public class TeacherEntity {

	@Id
	private int teacherId;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="teacher", cascade=CascadeType.ALL)
	private Set<GroupEntity> groups = new HashSet<GroupEntity>();

	public TeacherEntity(int teacherId, String firstName, String lastName) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public TeacherEntity(Teacher teacher) {
		this(teacher.getTeacherId(), 
			teacher.getFirstName(), 
			teacher.getLastName());
	}
	
	public Teacher getTeacher() {
		return new Teacher(teacherId, firstName, lastName);
	}
	
	public boolean isEmpty() {
		return groups.isEmpty();
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
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + teacherId;
		return result;
	}

	
		
	
	
	
	
	
}
