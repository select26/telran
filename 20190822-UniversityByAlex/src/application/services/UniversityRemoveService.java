package application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.GroupEntity;
import application.entities.StudentEntity;
import application.entities.TeacherEntity;
import application.exceptions.NoDataFoundException;
import application.exceptions.RemoveForbiddenException;
import application.repositories.GroupJpaRepository;
import application.repositories.StudentJpaRepository;
import application.repositories.TeacherJpaRepository;

@Service
public class UniversityRemoveService implements IUniversityRemove {
	
	@Autowired
	TeacherJpaRepository teachers;
	
	@Autowired
	GroupJpaRepository groups;
	
	@Autowired
	StudentJpaRepository students;
	
	@Override
	public TeacherEntity removeTeacher(int teacherId) {
		TeacherEntity teacher = teachers.findById(teacherId).orElse(null);
		if (teacher == null)
			throw new NoDataFoundException("No teacher with id: "+ teacherId);
		if (!teacher.isEmpty())
			throw new RemoveForbiddenException("Teacher with id "+ teacherId + " has groups");
		teachers.delete(teacher);
		return teacher;
	}
	
	@Override
	public GroupEntity removeGroup(String groupName) {
		GroupEntity group = groups.findById(groupName).orElse(null);
		if (group == null)
			throw new NoDataFoundException("No group named "+ groupName);
		if (!group.isEmpty())
			throw new RemoveForbiddenException("Group named "+ groupName + " has students");
		groups.delete(group);
		return group;
	}
	
	@Override
	public StudentEntity removeStudent(int studentId) {
		StudentEntity student = students.findById(studentId).orElse(null);
		if (student == null)
			throw new NoDataFoundException("No student with id: "+ studentId);
		students.delete(student);
		return student;
	}

}
