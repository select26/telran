package application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entities.TeacherEntity;
import application.services.IUniversityQueries;
import dto.Teacher;

@RestController
@RequestMapping("/get/teacher")
public class UniversityQueryControllerTeacher {

	@Autowired
	IUniversityQueries queryService;
	
	@GetMapping("/teacher")
	public ResponseEntity<?> getTeacher(@RequestParam int teacherId) {
		try {
			return new ResponseEntity<Teacher>(queryService.getTeacher(teacherId).getTeacher(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allTeachers")
	public ResponseEntity<?> getAllTeachers() {
		try {
			return new ResponseEntity<List<Teacher>>(
					 UniversityUtil.listToList(queryService.getAllTeachers(), TeacherEntity::getTeacher), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/teacherByGroup")
	public ResponseEntity<?> getTeacherByGroup(@RequestParam String groupName) {
		try {
			return new ResponseEntity<Teacher>(queryService.getTeacherByGroup(groupName).getTeacher(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/teacherByStudent")
	public ResponseEntity<?> getTeacherByStudent(@RequestParam int studentId) {
		try {
			return new ResponseEntity<Teacher>(queryService.getTeacherByStudent(studentId).getTeacher(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
}
