package app.repo;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.entities.CarDoc;

public interface CarMongoRepo extends MongoRepository<CarDoc, String>{
	List<CarDoc> findByModel(String model);
	List<CarDoc> findByEngineBetween(double from, double to);
	@Query("{'engine':{$gte :?0, $lte : ?1}}")						//Include border values
	List<CarDoc> findByEngineBetweenInc(double from, double to);
	List<CarDoc> findByProductionDate(LocalDate date);
	
}
