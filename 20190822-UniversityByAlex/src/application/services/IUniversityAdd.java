package application.services;

public interface IUniversityAdd {

	void addTeacher(int teacherId, String firstName, String lastName);
	void addGroup(String groupName, String course, int teacherId);
	void addStudent(int studentId, String studentName, int studentAge, String groupName);

}