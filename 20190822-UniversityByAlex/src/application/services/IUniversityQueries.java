package application.services;

import java.util.List;
import java.util.function.Predicate;

import application.entities.GroupEntity;
import application.entities.StudentEntity;
import application.entities.TeacherEntity;

public interface IUniversityQueries {

	StudentEntity getStudent(int studentId);
	GroupEntity getGroup(String groupName);
	TeacherEntity getTeacher(int teacherId);

	List<StudentEntity> getAllStudents();
	List<StudentEntity> getAllStudentsByGroup(String groupName);
	List<StudentEntity> getAllStudentsByTeacher(int teacherId);
	List<StudentEntity> getStudentsByTeacherWithPredicate(int teacherId, Predicate<StudentEntity> predicate);

	List<GroupEntity> getAllGroups();
	List<GroupEntity> getAllGroupsByTeacher(int teacherId);

	List<TeacherEntity> getAllTeachers();
	
	GroupEntity getGroupByStudent(int studentId);
	TeacherEntity getTeacherByStudent(int studentId);
	TeacherEntity getTeacherByGroup(String groupName);
	
	long countStudents();
	GroupEntity getMostPopulatedGroup();

}