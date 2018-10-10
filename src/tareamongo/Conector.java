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
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;
import org.bson.types.ObjectId;

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
    
    public ArrayList<Pelicula> getPeliculaCompania (String Compania_productora){
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
    
    public ArrayList getAggregatesCompania (String Compania_productora){
        int Cantidad=0;
        Double Min=0.0,Max=0.0;
        ArrayList Datos = new ArrayList();
        for (Document Documento : ColPelis.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("compania_productora",Compania_productora)),
                Aggregates.group(null, Accumulators.sum("cantidad", 1))))){
            Cantidad = Documento.getInteger("cantidad");
            System.out.println("Cantidad: "+Cantidad);
        }
        Datos.add(Cantidad);
        for (Document Documento : ColPelis.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("compania_productora", Compania_productora)),
                Aggregates.group(null, Accumulators.max("max", "$duracion"))))) {
            Max = Documento.getDouble("max");
            System.out.println("Max: "+Max);
        }
        Datos.add(Max);
        for (Document Documento : ColPelis.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("compania_productora", Compania_productora)),
                Aggregates.group(null, Accumulators.min("min", "$duracion"))))) {
            Min = Documento.getDouble("min");
            System.out.println("Min: "+Min);
        }
        Datos.add(Min);
        return Datos;
    }
    
    public ArrayList<CompaniaProductora> getCompaniaProductora (String Compania_productora){
        String Nombre,Web;
        Double Fundacion;
        CompaniaProductora Compania;
        ArrayList<CompaniaProductora> Companias = new ArrayList<>();
        for (Document Documento : ColComps.find(new Document("nombre",Compania_productora))){
            Nombre = Documento.getString("nombre");
            Web = Documento.getString("web");
            Fundacion = Documento.getDouble("fundacion");
            Compania = new CompaniaProductora(Fundacion,Nombre,Web);
            Compania.PrintAll();
            Companias.add(Compania);
        }
        return Companias;
    }
    
    public void setPelicula(String Nombre,String Genero,String Director,String Franquicia,
            ArrayList<String> PaisProdu,Double Duracion,Double Fecha,
            String CompaniaProductora,ArrayList<String> Actores){
        ColPelis.updateOne(
                eq("nombre",Nombre),
                new Document("$set",new Document("genero",Genero)
                        .append("director", Director)
                        .append("franquicia",Franquicia)
                        .append("duracion", Duracion)
                        .append("compania_productora", CompaniaProductora)
                        .append("fecha", Fecha)
                        .append("paises", PaisProdu)
                        .append("actores", Actores))); 
    }
    
    public void deletePelicula(String Nombre){
        ColPelis.deleteOne(eq("nombre",Nombre));
    }
    
    public void setCompaniaProductora (String Nombre,String Web,Double Fundacion){
        ColComps.updateOne(eq("nombre",Nombre),
                new Document("$set",new Document("web",Web)
                        .append("fundacion", Fundacion)));
    }
    
    public void deleteCompaniaProductora (String Nombre){
        ColComps.deleteOne(eq("nombre",Nombre));
    }
    
    public void insertPelicula(String Nombre,String Genero,String Director,String Franquicia,
            ArrayList<String> PaisProdu,Double Duracion,Double Fecha,
            String CompaniaProductora,ArrayList<String> Actores){
        ColPelis.insertOne(new Document("nombre",Nombre)
                .append("genero", Genero)
                .append("director", Director)
                .append("franquicia", Franquicia)
                .append("duracion", Duracion)
                .append("fecha", Fecha)
                .append("compania_productora", CompaniaProductora)
                .append("actores", Actores)
                .append("paises", PaisProdu));
    }
    
    public void insertCompaniaProductora (String Nombre,String Web,Double Fundacion){
        ColComps.insertOne(new Document("nombre",Nombre)
                .append("web", Web).append("fundacion", Fundacion));
    }
}
