package app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.docs.DriverDoc;

public interface DriverMongoRepo extends MongoRepository<DriverDoc, Integer> {

}
