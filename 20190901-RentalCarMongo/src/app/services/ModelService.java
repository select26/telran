package app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.docs.ModelDoc;
import app.repo.*;
import dto.Model;

@Service
public class ModelService {							//implements ICarPerson {
	
	@Autowired	CarMongoRepo	carRepo;
	@Autowired	DriverMongoRepo driverRepo;
	@Autowired	ModelMongoRepo	modelRepo;
	@Autowired	RentalRecordMongoRepo recordRepo;
	
	public boolean addModel(Model model) {
		if(modelRepo.existsById(model.getName())) return false;
		modelRepo.save(new ModelDoc(model));
		return true;
	}
	
	public ModelDoc getModelByName(String name){
//		System.err.println("[getModelByName] name: " + name);
		ModelDoc res = modelRepo.findById(name).orElse(null);
//		System.err.println("[getModelByName] ModelDoc response: " + res);
		return res;
	}
	public List<ModelDoc> getAllModels(){
		return modelRepo.findAll();
	}

	//	@Override
//	public boolean addOwner(PersonDto person) {
//		if(personRepo.existsById(person.getId())) return false;
//		personRepo.save(new PersonDoc(person));
//		return true;
//	}
//
//	@Override
//	public boolean addCar(CarDto car) {
//		if(carRepo.existsById(car.getVIN())) return false;
//		if(!personRepo.existsById(car.getOwner().getId()))			//If owner not exists
//			personRepo.save(new PersonDoc(car.getOwner()));			//create new owner
//		carRepo.save(new CarDoc(car));
//		return true;
//	}
//
//	@Override
//	public List<CarDto> getOwnerCars(int id) {
//		PersonDoc found = personRepo.findById(id).orElse(null);
//		return found==null ?
//				new ArrayList<CarDto>() :
//				carRepo.findByOwnerId(id).stream()
//									.map(car -> car.getCarDto(found))
//									.collect(Collectors.toList() );
//	}
//
//	public List<PersonDto> getAllOwners(){
//		return personRepo.findAll().stream()
//				.map(owner -> owner.getPersonDto())
//				.collect(Collectors.toList() );
//	}
//	
//
//	public List<CarDto> getAllCars(){
//		return carRepo.findAll().stream()
//				.map(car -> car.getCarDto(personRepo.findById(car.getOwnerId()).get()))
//				.collect(Collectors.toList() );
//	}
}
