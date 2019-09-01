package app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.docs.ModelDoc;

public interface ModelMongoRepo extends MongoRepository<ModelDoc, String>{

}
