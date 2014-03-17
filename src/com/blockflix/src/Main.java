package com.blockflix.src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
		Pelicula pelicula = new Pelicula("Pelicula1",1947,"Pakito","Aburrida",Soporte.BLURAY);
		//File prueba = new File("/Ficheros_de_datos/Socios.dat");


				ObjectOutputStream pruebaStream;
				try {
					pruebaStream = new ObjectOutputStream(new FileOutputStream("Ficheros_de_datos/Socios.dat"));
					pruebaStream.writeObject(pelicula);
					pelicula = new Pelicula("Pelicula2",1947,"Pakito","Aburrida",Soporte.BLURAY);
					pruebaStream.writeObject(pelicula);
					pruebaStream.close();
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//
//		Object aux;
//		ObjectInputStream ois;
//
//		try {
//			ois = new ObjectInputStream(new FileInputStream("Socios.dat"));
//		//	System.out.print(ois.available());
//			aux= ois.readObject();
//	
//			while (aux != null)
//			{
//				if (aux instanceof Pelicula){
//					System.out.println(((Pelicula)aux).getNombre());
//
//				}
//				aux = ois.readObject();
//			}
//			ois.close();
//		} catch (IOException | ClassNotFoundException e ) {
//			// TODO Auto-generated catch block
//			
//			
//			//e.printStackTrace();
//		
//		}





		//Accedemos al metodo estatico para ver el numero
		//de instancias de tipo Persona creadas ASD
		//System.out.println(pelicula.getNombre());

	}

}
