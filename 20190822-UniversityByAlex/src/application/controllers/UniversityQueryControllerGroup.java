package application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entities.GroupEntity;
import application.services.IUniversityQueries;
import dto.Group;

@RestController
@RequestMapping("/get/group")
public class UniversityQueryControllerGroup {

	@Autowired
	IUniversityQueries queryService;
		
	@GetMapping("/group")
	public ResponseEntity<?> getGroup(@RequestParam String groupName) {
		try {
			return new ResponseEntity<Group>( queryService.getGroup(groupName).getGroup(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allGroups")
	public ResponseEntity<?> getAllGroups() {
		try {
			return new ResponseEntity<List<Group>>(
					 UniversityUtil.listToList(queryService.getAllGroups(), GroupEntity::getGroup), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/allGroupsByTeacher")
	public ResponseEntity<?> getAllGroupsByTeacher(@RequestParam int teacherId) {
		try {
			return new ResponseEntity<List<Group>>(
					 UniversityUtil.listToList(queryService.getAllGroupsByTeacher(teacherId), GroupEntity::getGroup), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
	
	@GetMapping("/groupByStudent")
	public ResponseEntity<?> getGroupByStudent(@RequestParam int studentId) {
		try {
			return new ResponseEntity<Group>(queryService.getGroupByStudent(studentId).getGroup(), HttpStatus.OK);
		}
		catch(Exception e) {
			return UniversityUtil.exceptionsHandler(e);
		}
	}
}

