package app.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import dto.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="group")
public class GroupEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int	   id_group; 

	private String name;
	private String course;
	
	// one country to many cities
	// mapped by - creates foreign keys with countryEntity
	// cascade - type of connection between tables in case of changing/deleting country - changes/deleting cities
	@OneToMany(mappedBy="groupEntity", cascade=CascadeType.ALL)
	@JsonManagedReference //used to preserve recursion when creating JSON of city and country, ManagedReference - is used from the side of one to many
	private Set<StudentEntity> students = new HashSet<>();

	public GroupEntity(String name, String course) {
		super();
		this.name = name;
		this.course = course;
	}

	public GroupEntity(Group group) {
		super();
		this.name = group.getName();
		this.course = group.getCourse();
	}
	
	public Group EntityToGroup(){
		return new Group(name, course);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupEntity other = (GroupEntity) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (id_group != other.id_group)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + id_group;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
}
