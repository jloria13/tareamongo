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
    
    MongoClientURI connectionString;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> ColPelis,ColComps;
    
    public Conector (){
        connectionString = new MongoClientURI("mongodb://localhost:27017");
        this.mongoClient = new MongoClient(connectionString);
        this.database = mongoClient.getDatabase("Cine");
        ColPelis = database.getCollection("Peliculas");
        ColComps = database.getCollection("Companias");
    }
    
    public void getPeliculas(){
        for (Document cur : ColPelis.find()) {
            System.out.println(cur.toJson());
        }
    }
}
