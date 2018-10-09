/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareamongo;

import java.util.ArrayList;

public class TareaMongo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new Conector().getPeliculaNombre("Venom");
        Conector conector = new Conector();
        ArrayList<Pelicula> pelis = conector.getPeliculaNombre("Venom");
    }
    
}
