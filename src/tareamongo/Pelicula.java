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
    double Fecha, Duracion;
    ArrayList<String> Paises, Actores;
    
    public Pelicula (ObjectId ObjectID,String Nombre,String Genero,
            String Director,String Compania_productora,String Franquicia,
            double Fecha,double Duracion,ArrayList<String> Paises,
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
    
    public void PrintAll (){
        System.out.println("ObjectID: "+this.ObjectID);
        System.out.println("Nombre: "+this.Nombre);
        System.out.println("Director: "+this.Director);
        System.out.println("Companía Productora: "+this.Compania_productora);
        System.out.println("Franquicia: "+this.Franquicia);
        System.out.println("Actores: ");
        for (String Actor:Actores){
            System.out.println("-"+Actor);
        }
        System.out.println("Países: ");
        for (String Pais:Paises){
            System.out.println("-"+Pais);
        }
        System.out.println("Duración: "+this.Duracion);
        System.out.println("Año: "+this.Fecha);
    }
    
}
