package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.services.IUniversityAdd;
import dto.Group;
import dto.Student;
import dto.Teacher;

@RestController
@RequestMapping("/add")
public class UniversityAddController {
	
	@Autowired
	IUniversityAdd addService;
	
	@PostMapping("/teacher")
	public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
		try {
			addService.addTeacher(teacher.getTeacherId(), 
					              teacher.getFirstName(), 
					              teacher.getLastName());
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@PostMapping("/group")
	public ResponseEntity<String> addGroup(@RequestBody Group group) {

		try {
			addService.addGroup(group.getName(), 
					            group.getCourse(),
					            group.getTeacher().getTeacherId());
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		try {
			addService.addStudent(student.getStudentId(), 
								  student.getName(),
								  student.getAge(),
								  student.getGroup().getName());
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
}
