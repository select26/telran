package app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.docs.CarDoc;

public interface CarMongoRepo extends MongoRepository<CarDoc, String>{
//	@Query("{'engine':{$gte :?0, $lte : ?1}}")						//Include border values
//	List<CarDoc> findByEngineBetweenInc(double from, double to);
}
