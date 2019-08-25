package application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dto.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="student")
public class StudentEntity {
	
	@Id
	private int studentId;
	private String name;	
	private int age;
	
	@ManyToOne
	private GroupEntity group;
	
	public StudentEntity(Student student) {
		this(student.getStudentId(),
			 student.getName(), 
			 student.getAge(), 
			 new GroupEntity(student.getGroup()));
	}
	
	public Student getStudent() {
		return new Student(studentId, name, age, group.getGroup());
	}

	
		
	
}
