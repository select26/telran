package application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.GroupEntity;
import application.entities.StudentEntity;
import application.exceptions.NoDataFoundException;
import application.repositories.GroupJpaRepository;
import application.repositories.StudentJpaRepository;
import application.repositories.TeacherJpaRepository;

@Service
public class UniversityUpdateService implements IUniversityUpdate {
	
	@Autowired
	TeacherJpaRepository teachers;
	
	@Autowired
	GroupJpaRepository groups;
	
	@Autowired
	StudentJpaRepository students;
	
	@Override
	public void updateStudentGroup(int studentId, String groupName) {
	
		if(!groups.existsById(groupName))
			throw new NoDataFoundException("No group named "+ groupName);
		if(!students.existsById(studentId))
			throw new NoDataFoundException("No student with id: "+ studentId);
		StudentEntity student = students.findById(studentId).get();
		student.setGroup(groups.findById(groupName).get());
		students.save(student);
	}
	
	@Override
	public void updateStudentAge(int studentId, int age) {
		if(!students.existsById(studentId))
			throw new NoDataFoundException("No student with id: "+ studentId);
		StudentEntity student = students.findById(studentId).get();
		student.setAge(age);
		students.save(student);
	}
	
	@Override
	public void updateGroupTeacher(String groupName, int teacherId) {
		
		if(!teachers.existsById(teacherId))
			throw new NoDataFoundException("No teacher with id:  "+ teacherId);
		if(!groups.existsById(groupName))
			throw new NoDataFoundException("No group named "+ groupName);
		GroupEntity group = groups.findById(groupName).get();
		group.setTeacher(teachers.findById(teacherId).get());
		groups.save(group);
	}
	
	@Override
	public void updateGroupCourse(String groupName, String course) {
		
		if(!groups.existsById(groupName))
			throw new NoDataFoundException("No group named "+ groupName);
		GroupEntity group = groups.findById(groupName).get();
		group.setCourse(course);
		groups.save(group);
	}

	

}
