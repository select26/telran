package app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.documents.CarDoc;
import app.documents.PersonDoc;
import dto.PersonDto;

public interface PersonMongoRepo extends MongoRepository<PersonDoc, Integer>{
//	List<PersonDoc> findByOwnerId(int id);
}
