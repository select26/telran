package application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.GroupEntity;
import application.entities.StudentEntity;
import application.entities.TeacherEntity;
import application.exceptions.NoDataFoundException;
import application.exceptions.NoStudentsException;
import application.repositories.GroupJpaRepository;
import application.repositories.StudentJpaRepository;
import application.repositories.TeacherJpaRepository;

@Service
public class UniversityQueriesService implements IUniversityQueries {
	
	@Autowired
	TeacherJpaRepository teachers;
	
	@Autowired
	GroupJpaRepository groups;
	
	@Autowired
	StudentJpaRepository students;
	
	@Override
	public StudentEntity  getStudent(int studentId){
		StudentEntity student = students.findById(studentId).orElse(null);
		if (student == null)
			throw new NoDataFoundException("No student with id: "+ studentId);
		return student;
	}
	
	@Override
	public GroupEntity  getGroup(String groupName){
		GroupEntity group = groups.findById(groupName).orElse(null);
		if (group == null)
			throw new NoDataFoundException("No groupNamed "+ groupName);
		return group;
	}
	
	@Override
	public TeacherEntity  getTeacher(int teacherId){
		TeacherEntity teacher = teachers.findById(teacherId).orElse(null);
		if (teacher == null)
			throw new NoDataFoundException("No teacher with id: "+ teacherId);
		return teacher;
	} 

	
	@Override
	public List<StudentEntity> getAllStudents(){
		return students.findAll();
	}
	
	@Override
	public long countStudents() {
		return students.count();
	}
	
	@Override
	public List<StudentEntity> getAllStudentsByGroup(String groupName){
		return new ArrayList<StudentEntity>(getGroup(groupName).getStudents());	
	}
	
	@Override
	public List<StudentEntity> getAllStudentsByTeacher(int teacherId){
		return getAllGroupsByTeacher(teacherId).stream()
			.flatMap(group -> group.getStudents().stream())
			.collect(Collectors.toList());	
	}
	
	public long countAllStudents() {
		return students.count();
	}
	
	
	@Override
	public List<GroupEntity> getAllGroups(){
		return groups.findAll();
	}
	
	@Override
	public List<GroupEntity> getAllGroupsByTeacher(int teacherId){
		return new ArrayList<GroupEntity>(getTeacher(teacherId).getGroups());
	}
	
	@Override
	public List<TeacherEntity> getAllTeachers() {
		return teachers.findAll();
	}
	
	@Override
	public GroupEntity getGroupByStudent(int studentId) {
		return getStudent(studentId).getGroup();
	}
	
	@Override
	public TeacherEntity getTeacherByStudent(int studentId) {
		return getStudent(studentId).getGroup().getTeacher();
	}
	
	@Override
	public TeacherEntity getTeacherByGroup(String groupName) {
		return getGroup(groupName).getTeacher();
	}

	@Override
	public List<StudentEntity> getStudentsByTeacherWithPredicate(int teacherId, Predicate<StudentEntity> predicate) {
		return getAllGroupsByTeacher(teacherId).stream()
				.flatMap(group -> group.getStudents().stream().filter(predicate))
				.collect(Collectors.toList());
	}

	@Override
	public GroupEntity getMostPopulatedGroup() {
		if (groups.count() == 0) 
			throw new NoStudentsException("No students in the university");
		
		return groups.findAll().stream()
			.sorted((group1, group2)->group2.getStudents().size() - group1.getStudents().size())
			.findFirst()
			.get();
		
	}

}
