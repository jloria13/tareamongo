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
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author jlori
 */
public class Conector {
    
    MongoClientURI connectionString;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> ColPelis,ColComps;
    ArrayList<Document> Documentos;
    
    public Conector (){
        connectionString = new MongoClientURI("mongodb://localhost:27017");
        this.mongoClient = new MongoClient(connectionString);
        this.database = mongoClient.getDatabase("Cine");
        ColPelis = database.getCollection("Peliculas");
        ColComps = database.getCollection("Companias");
    }
    
    public ArrayList<Pelicula> getPeliculaNombre(String nombre){
        ObjectId ObjectID;
        String Nombre,Genero,Director,Compania_productora,Franquicia;
        Double Fecha,Duracion;
        ArrayList<String> Paises,Actores;
        Pelicula movie;
        ArrayList<Pelicula> Peliculas = new ArrayList<>();
        
        for (Document Documento : ColPelis.find(new Document("nombre",nombre))) {
            ObjectID = Documento.getObjectId("_id");
            Nombre = Documento.getString("nombre");
            Genero = Documento.getString("genero");
            Director = Documento.getString("director");
            Franquicia = Documento.getString("franquicia");
            Paises = Documento.get("pais_produccion", ArrayList.class);
            Duracion = Documento.getDouble("duracion");
            Fecha = Documento.getDouble("fecha");
            Compania_productora = Documento.getString("compania_productora");
            Actores = Documento.get("actores", ArrayList.class);
            movie = new Pelicula(ObjectID,Nombre,Genero,Director,Compania_productora,
                    Franquicia,Fecha,Duracion,Paises,Actores);
            movie.PrintAll();
            Peliculas.add(movie);
        }
        return Peliculas;
    }
    
    public ArrayList<Pelicula> getPeliculaFranquicia(String franquicia){
        ObjectId ObjectID;
        Document Query;
        String Nombre,Genero,Director,Compania_productora,Franquicia;
        Double Fecha,Duracion;
        ArrayList<String> Paises,Actores; 
        Pelicula movie;
        ArrayList<Pelicula> Peliculas = new ArrayList<>();
        
        
        for (Document Documento : ColPelis.find(eq ("franquicia",franquicia))) {
            ObjectID = Documento.getObjectId("_id");
            Nombre = Documento.getString("nombre");
            Genero = Documento.getString("genero");
            Director = Documento.getString("director");
            Franquicia = Documento.getString("franquicia");
            Paises = Documento.get("pais_produccion", ArrayList.class);
            Duracion = Documento.getDouble("duracion");
            Fecha = Documento.getDouble("fecha");
            Compania_productora = Documento.getString("compania_productora");
            Actores = Documento.get("actores", ArrayList.class);
            movie = new Pelicula(ObjectID, Nombre, Genero, Director, Compania_productora,
                    Franquicia, Fecha, Duracion, Paises, Actores);
            movie.PrintAll();
            Peliculas.add(movie);
        }
        return Peliculas;
    }
    
    public ArrayList<Pelicula> getPeliculaRango(double inicio,double fin) {
        ObjectId ObjectID;
        Document Query;
        String Nombre, Genero, Director, Compania_productora, Franquicia;
        Double Fecha, Duracion;
        ArrayList<String> Paises, Actores;
        Pelicula movie;
        ArrayList<Pelicula> Peliculas = new ArrayList<>();

        for (Document Documento : ColPelis.find(and(gte("fecha",inicio),lte("fecha",fin)))) {
            ObjectID = Documento.getObjectId("_id");
            Nombre = Documento.getString("nombre");
            Genero = Documento.getString("genero");
            Director = Documento.getString("director");
            Franquicia = Documento.getString("franquicia");
            Paises = Documento.get("pais_produccion", ArrayList.class);
            Duracion = Documento.getDouble("duracion");
            Fecha = Documento.getDouble("fecha");
            Compania_productora = Documento.getString("compania_productora");
            Actores = Documento.get("actores", ArrayList.class);
            movie = new Pelicula(ObjectID, Nombre, Genero, Director, Compania_productora,
                    Franquicia, Fecha, Duracion, Paises, Actores);
            movie.PrintAll();
            Peliculas.add(movie);
        }
        return Peliculas;
    }
    
    public ArrayList<Pelicula> getCompaniaProductora (String Compania_productora){
        String Nombre,Genero;
        Double Fecha;
        Pelicula pelicula;
        ArrayList<Pelicula> Peliculas = new ArrayList<>();
        for (Document Documento : ColPelis.find(eq("compania_productora",
                Compania_productora)).projection(fields(include("nombre","genero","fecha"),excludeId()))){
            Nombre = Documento.getString("nombre");
            Genero = Documento.getString("genero");
            Fecha = Documento.getDouble("fecha");
            pelicula = new Pelicula(Nombre,Genero,Fecha);
            pelicula.PrintAll();
            Peliculas.add(pelicula);
        }
        return Peliculas;
    }
}
