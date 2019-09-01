package app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.docs.RentRecordDoc;
//import app.entities.CarDoc;


public interface RentalRecordMongoRepo extends MongoRepository<RentRecordDoc, String>{
	List<RentRecordDoc> findByDriver(int driver);


}
