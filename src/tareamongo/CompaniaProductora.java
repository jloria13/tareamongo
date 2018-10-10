/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareamongo;

public class CompaniaProductora {
    
    public Double Fundacion;
    public String Nombre,Web;
    
    public CompaniaProductora (Double Fundacion,String Nombre,String Web){
        this.Fundacion = Fundacion;
        this.Nombre = Nombre;
        this.Web = Web;
    }
    
    public void PrintAll(){
        if (this.Nombre != null) System.out.println("Nombre: "+this.Nombre);
        if (this.Fundacion != null) System.out.println("Fundacion: "+this.Fundacion);
        if (this.Web != null) System.out.println("Web: "+this.Web);
    }
    
}
