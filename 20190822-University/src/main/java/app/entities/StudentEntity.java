package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int 	id_student;
	
	private String 	name;
	private int 	age;
	@ManyToOne 				// many cities, one countryused to show type of connection
	@JsonBackReference 		// used to preserve recursion when creating JSON of city and country,
							// BackReference - is used from the side of many cities to one country
	private GroupEntity groupEntity;
	
	public StudentEntity(String name, int age/*, GroupEntity groupEntity*/) {
		super();
		this.name 		 = name;
		this.age 		 = age;
//		this.groupEntity = groupEntity;
	}
	
	public StudentEntity(Student student) {
		super();
		this.name 		 = student.getName();
		this.age 		 = student.getAge();
//		this.groupEntity = student.get;
	}

}
