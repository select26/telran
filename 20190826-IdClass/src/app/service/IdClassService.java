package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ChildEntity;
import app.entities.CompanyEntity;
import app.entities.EmployeeEntity;
import app.entities.EmployeeId;
import app.repo.ChildJpaRepository;
import app.repo.CompanyJpaRepository;
import app.repo.EmployeeJpaRepository;

@Service
public class IdClassService implements IIdClass {

	@Autowired
	EmployeeJpaRepository employRepo;
	
	@Autowired
	CompanyJpaRepository companyRepo;
	
	@Autowired
	ChildJpaRepository 	 childRepo;

	@Override
	public void addCompany(String companyName){
		companyRepo.save(new CompanyEntity(companyName));
	}
	
	@Override
	public boolean addEmployee( String firstName,
								String lastName,
								int age
//								,int companyId 
								){
		if (employRepo.existsById(new EmployeeId(firstName, lastName))) return false;
		return employRepo.save(new EmployeeEntity(firstName, lastName, age)) != null;
				
	};
	
	public void addChild(String childName){
		childRepo.save(new ChildEntity(childName));
	}
	
//	public boolean setFatherToChild()
}
