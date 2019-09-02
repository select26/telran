package app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.docs.CarDoc;
import app.docs.ModelDoc;
import app.docs.RentRecordDoc;
import app.repo.*;
import dto.Model;
import dto.RentRecord;

@Service
public class RentalRecordService {							//implements ICarPerson {
	
	@Autowired	CarMongoRepo	carRepo;
	@Autowired	DriverMongoRepo driverRepo;
	@Autowired	ModelMongoRepo	modelRepo;
	@Autowired	RentalRecordMongoRepo recordRepo;
	
	public boolean addRecord(RentRecordDoc record) {
		// Если машина есть и уже не в работе
		if(carRepo.existsById(record.getCar()) && !(carRepo.findById(record.getCar())).get().isInUse()) {
			recordRepo.save(record);
			CarDoc res = carRepo.findById(record.getCar()).get();		// найдем машину
			res.setInUse(true);											// теперь занята
			carRepo.save(res);											// сохраним
			return true;
		}
		return false;
	}
	
	public RentRecordDoc getRecordByCar(String car){
		RentRecordDoc res = recordRepo.findById(car).orElse(null);
		return res;
	}
	public List<RentRecordDoc> getAllRecords(){
		return recordRepo.findAll();
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
