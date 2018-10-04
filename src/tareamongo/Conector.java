/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareamongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author jlori
 */
public class Conector {
    
    public Conector (){
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("Cine");
        MongoCollection<Document> collection = database.getCollection("Peliculas");
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
        System.out.println(collection.count());
    }
}
