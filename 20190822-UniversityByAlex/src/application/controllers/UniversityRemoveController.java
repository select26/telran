package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.services.IUniversityRemove;
import dto.Group;
import dto.Student;
import dto.Teacher;

@RestController
@RequestMapping("/delete")
public class UniversityRemoveController {
	
	@Autowired
	IUniversityRemove removeService;
	
	@DeleteMapping("/student")
	public ResponseEntity<?> removeStudent(@RequestParam int studentId) {
		try {
			return new ResponseEntity<Student>(removeService.removeStudent(studentId).getStudent(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@DeleteMapping("/group")
	public ResponseEntity<?> removeGroup(@RequestParam String groupName) {
		try {
			return new ResponseEntity<Group>(removeService.removeGroup(groupName).getGroup(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@DeleteMapping("/teacher")
	public ResponseEntity<?> removeTeacher(@RequestParam int teacherId) {
		try {
			return new ResponseEntity<Teacher>(removeService.removeTeacher(teacherId).getTeacher(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}

}
