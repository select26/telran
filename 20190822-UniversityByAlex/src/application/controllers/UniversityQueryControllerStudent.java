package application.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entities.StudentEntity;
import application.services.IUniversityQueries;
import dto.Group;
import dto.Student;

@RestController
@RequestMapping("/get/student")
public class UniversityQueryControllerStudent {

	@Autowired
	IUniversityQueries queryService;
	
	@GetMapping("/student")
	public ResponseEntity<?> getStudent(@RequestParam int studentId) {
		try {
			return new ResponseEntity<Student>(queryService.getStudent(studentId).getStudent(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allStudents")
	public ResponseEntity<?> getAllStudents() {
		try {
			return new ResponseEntity<List<Student>>(
					 UniversityUtil.listToList(queryService.getAllStudents(), StudentEntity::getStudent), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/count")
	public ResponseEntity<?> countStudents() {
		try {
			return new ResponseEntity<Long>(queryService.countStudents(),HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allStudentsByGroup")
	public ResponseEntity<?> getAllStudentsByGroup(@RequestParam String groupName) {
		try {
			return new ResponseEntity<List<Student>>(
					 UniversityUtil.listToList(queryService.getAllStudentsByGroup(groupName), StudentEntity::getStudent), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allStudentsByTeacher")
	public ResponseEntity<?> getAllStudentsByTeacher(@RequestParam int teacherId) {
		try {
			return new ResponseEntity<List<Student>>(
				UniversityUtil.listToList(queryService
						.getStudentsByTeacherWithPredicate(teacherId, student->true), StudentEntity::getStudent), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allStudentsByTeacherMinAge")
	public ResponseEntity<?> getAllStudentsByTeacher(@RequestParam int teacherId, @RequestParam int age) {
		try {
			return new ResponseEntity<List<Student>>(
				UniversityUtil.listToList(queryService
						.getStudentsByTeacherWithPredicate(teacherId, student->student.getAge() >= age), StudentEntity::getStudent), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/getMostPopulatedGroup")
	public ResponseEntity<?> getMostPopulatedGroup(){
		try {
			return new ResponseEntity<Group>(queryService.getMostPopulatedGroup().getGroup(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
}

