package app;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dto.Person;

public class MongoTestApp {

	public static void main(String[] args) {

		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );	// e.g. or Log.WARNING, etc.
		mongoLogger.setLevel(Level.WARNING); 
		
		MongoClient mClient = new MongoClient("localhost",27017);
		MongoDatabase mDb = mClient.getDatabase("test");
		MongoCollection<Document> mC = mDb.getCollection("persons");
		
//		System.out.println("*\t*\t*\t*\t*\t*\t*\t*\t*\t*\t*\t*\t*");
		for (int i = 0; i < 100; i++) {System.out.print("=");} System.out.println();
//		String dbQuery =  "{weight : {$gte : 80}}";
		String dbQuery =  "{$and: [{weight : {$gte : 7}},{age : {$lte : 5}}]}";
		for(Document document : mC.find(BasicDBObject.parse(dbQuery)))
			System.out.println("ID: " + document.getObjectId("_id") + " " + 
					new Person (
							document.getString("name"),
							document.getInteger("age"),
							document.getDouble("weight"),
							document.getBoolean("married")
							)
					);
		
		for (int i = 0; i < 100; i++) {System.out.print("=");} System.out.println();
		
	}

}
