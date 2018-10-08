/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareamongo;

import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 *
 * @author jlori
 */
public class Pelicula {
    
    ObjectId ObjectID;
    String Nombre, Genero, Director, Compania_productora, Franquicia;
    Double Fecha, Duracion;
    ArrayList<String> Paises, Actores;
    
    public Pelicula (ObjectId ObjectID,String Nombre,String Genero,
            String Director,String Compania_productora,String Franquicia,
            double Fecha,Double Duracion,ArrayList<String> Paises,
            ArrayList<String> Actores){
        this.ObjectID = ObjectID;
        this.Director = Director;
        this.Nombre = Nombre;
        this.Actores = Actores;
        this.Paises = Paises;
        this.Fecha = Fecha;
        this.Duracion = Duracion;
        this.Compania_productora = Compania_productora;
        this.Genero = Genero;
        this.Franquicia = Franquicia;  
    }

    Pelicula(String Nombre, String Genero, Double Fecha) {
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Fecha = Fecha;
    }
    
    public void PrintAll (){
        if (this.ObjectID != null) System.out.println("ObjectID: "+this.ObjectID);
        if (this.Nombre != null) System.out.println("Nombre: "+this.Nombre);
        if (this.Director != null) System.out.println("Director: "+this.Director);
        if (this.Genero != null) System.out.println("Género: "+this.Genero);
        if (this.Compania_productora != null) System.out.println("Companía Productora: "+this.Compania_productora);
        if (this.Franquicia != null) System.out.println("Franquicia: "+this.Franquicia);
        if (this.Actores != null) {
            System.out.println("Actores: ");
            for (String Actor:Actores){
                System.out.println("-"+Actor);
            }
        }
        if (this.Paises != null){
            System.out.println("Países: ");
            for (String Pais:Paises){
                System.out.println("-"+Pais);
            }
        }
        if (this.Duracion != null) System.out.println("Duración: "+this.Duracion);
        if (this.Fecha != null) System.out.println("Año: "+this.Fecha);
    }
    
}
