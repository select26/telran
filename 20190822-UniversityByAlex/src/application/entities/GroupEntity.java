package application.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dto.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="groupp")

public class GroupEntity {
	
	@Id
	private String name;
	private String course;
	
	@ManyToOne
	private TeacherEntity teacher;
	
	@OneToMany(mappedBy="group", cascade=CascadeType.ALL)
	private Set<StudentEntity> students = new HashSet<>();

	public GroupEntity(String name, String course, TeacherEntity teacher) {
		super();
		this.name = name;
		this.course = course;
		this.teacher = teacher;
	}
	
	public GroupEntity(Group group) {
			this.name = group.getName(); 
			this.course = group.getCourse();
			this.teacher = new TeacherEntity(group.getTeacher());
	}
	
	public Group getGroup() {
		return new Group(name,course, teacher.getTeacher());
	}
	
	public boolean isEmpty() {
		return students.isEmpty();
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}

	
	
	
		
	
	
	

}
