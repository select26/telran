package application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.GroupEntity;
import application.entities.StudentEntity;
import application.entities.TeacherEntity;
import application.exceptions.DuplicateDataException;
import application.exceptions.NoDataFoundException;
import application.repositories.GroupJpaRepository;
import application.repositories.StudentJpaRepository;
import application.repositories.TeacherJpaRepository;

@Service
public class UniversityAddService implements IUniversityAdd {
	
	@Autowired
	TeacherJpaRepository teachers;
	
	@Autowired
	GroupJpaRepository groups;
	
	@Autowired
	StudentJpaRepository students;
	
	@Override
	public void addTeacher(int teacherId, String firstName, String lastName) {
		if (teachers.existsById(teacherId)) 
			throw new DuplicateDataException("Teacher duplicate: "+ teacherId);
		teachers.save(new TeacherEntity(teacherId, firstName, lastName));
	}
	
	@Override
	public void addGroup(String groupName, String course, int teacherId ) {
		TeacherEntity teacher = teachers.findById(teacherId).orElse(null);
		if (teacher == null) 
			throw new NoDataFoundException("No teacher with id: "+ teacherId);
		if (groups.existsById(groupName))
			throw new DuplicateDataException("Group duplicate: "+ groupName);
		groups.save(new GroupEntity(groupName, course, teacher));
	}
	
	@Override
	public void addStudent(int studentId, String studentName, int studentAge, String groupName ) {
		GroupEntity group = groups.findById(groupName).orElse(null);
		if (group == null) 
			throw new NoDataFoundException("No group with name: "+ groupName);
		if (students.existsById(studentId)) 
			throw new DuplicateDataException("Student duplicate: "+ studentId);
		students.save(new StudentEntity(studentId, studentName, studentAge, group));
	}

}
