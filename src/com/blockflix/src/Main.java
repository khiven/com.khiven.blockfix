package com.blockflix.src;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.productos.Pelicula;

/** Clase principal de pruebas
 * @author Antonio Amate
 *
 */


public class Main {


	


	/** Metodo main que ejecuta las pruebas
	 * 
	 * @param args Vacío
	 */
    public static void main(String[] args) {
        //Se crean instancias
    	 Pelicula pelicula = new Pelicula("Pen",1947,"Pakito","Aburrida",Soporte.BLURAY);
        //Accedemos al metodo estatico para ver el numero
        //de instancias de tipo Persona creadas ASD
        System.out.println(pelicula.getNombre());
    }

}
