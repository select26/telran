package app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import app.entities.CarDoc;

public interface CarMongoRepo extends MongoRepository<CarDoc, String>{
	List<CarDoc> findByOwnerId(int id);
//	List<CarDoc> findByModel(String model);
//	List<CarDoc> findByEngineBetween(double from, double to);
//	@Query("{'engine':{$gte :?0, $lte : ?1}}")						//Include border values
//	List<CarDoc> findByEngineBetweenInc(double from, double to);
//	List<CarDoc> findByProductionDate(LocalDate date);
	
}
