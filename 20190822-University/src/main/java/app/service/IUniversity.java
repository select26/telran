package app.service;

public interface IUniversity {

	boolean addTeacher(String firstName, String lastName);
	boolean addGroup(String name, String course);
	boolean addStudent(String name, int age);
}
