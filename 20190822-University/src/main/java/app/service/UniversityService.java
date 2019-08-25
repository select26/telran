package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.TeacherEntity;
import app.repo.GroupUniRepo;
import app.repo.StudentUniRepo;
import app.repo.TeacherUniRepo;

@Service
public class UniversityService implements IUniversity{
	@Autowired
	GroupUniRepo   groupRepo;
	@Autowired
	StudentUniRepo studentRepo;
	@Autowired
	TeacherUniRepo teacherRepo;
	
	@Override
	public boolean addTeacher(String firstName, String lastName) {
		if (teacherRepo.findByFirstNameAndLastName(firstName, lastName).isEmpty()){
			System.out.println(teacherRepo.save(new TeacherEntity(firstName, lastName)) );
			return true;
		}	
		System.err.println("Duplicated record: " + firstName + " " + lastName+ "!");
		return false;
	}

	@Override
	public boolean addGroup(String name, String course) {
		
		return false;
	}

	@Override
	public boolean addStudent(String name, int age) {
		
		return false;
	}

}
