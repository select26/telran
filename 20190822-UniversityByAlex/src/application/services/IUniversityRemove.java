package application.services;

import application.entities.GroupEntity;
import application.entities.StudentEntity;
import application.entities.TeacherEntity;

public interface IUniversityRemove {

	TeacherEntity removeTeacher(int teacherId);

	GroupEntity removeGroup(String groupName);

	StudentEntity removeStudent(int studentId);

}