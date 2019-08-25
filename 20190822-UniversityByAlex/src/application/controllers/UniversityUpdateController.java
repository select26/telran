package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.services.IUniversityUpdate;

@RestController
@RequestMapping("/update")
public class UniversityUpdateController {
	
	@Autowired
	IUniversityUpdate updateService;
	
	@PutMapping("/student/group")
	public ResponseEntity<String>updateStudentGroup(@RequestParam int studentId,
			                                        @RequestParam String groupName){
		try {
			updateService.updateStudentGroup(studentId, groupName);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@PutMapping("/student/age")
	public ResponseEntity<String>updateStudentAge(@RequestParam int studentId,
			                                        @RequestParam int age){
		try {
			updateService.updateStudentAge(studentId, age);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	
	@PutMapping("/group/teacher")
	public ResponseEntity<String>updateGroupTeacher(@RequestParam String groupName,
			                                        @RequestParam int teacherId){
		try {
			updateService.updateGroupTeacher(groupName, teacherId);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@PutMapping("/group/course")
	public ResponseEntity<String>updateGroupCourse(@RequestParam String groupName,
			                                        @RequestParam String course){
		try {
			updateService.updateGroupCourse(groupName, course);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}



}
