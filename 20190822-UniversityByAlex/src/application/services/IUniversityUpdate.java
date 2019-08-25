package application.services;

public interface IUniversityUpdate {

	void updateStudentGroup(int studentId, String groupName);
	void updateStudentAge(int studentId, int age);
	void updateGroupTeacher(String groupName, int teacherId);
	void updateGroupCourse(String groupName, String course);

}