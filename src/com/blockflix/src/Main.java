package com.blockflix.src;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.empleado.Empleado;
import com.blockflix.src.gerente.Gerente;


/** Clase principal de pruebas
 * @author Antonio Amate
 *
 */
public class Main {

	public static Empleado emp;
	public static Gerente ger;
	/** Metodo main que ejecuta las pruebas
	 * 
	 * @param args Vacío
	 */
	public static void main(String[] args) {
		ger = Constantes.doLogin("admin", "password_gerente");
		
		generarProductos();
		generarSocios();
		
		ger.gs.printListaSocios();
		ger.gp.printListaProductos();
		
		ger.save();
		
		ger.reset();
		System.out.println("\n ELIMINADOS TODOS LOS DATOS DE MEMORIA");
		ger.gs.printListaSocios();
		ger.gp.printListaProductos();
		System.out.println("\n CARGANDO TODOS LOS DATOS DE FICHEROS");
		ger.load();
		ger.gs.printListaSocios();
		ger.gp.printListaProductos();

	}

	public static void generarProductos(){
		for (int i=0;i<10;i++){
			ger.addPelicula("Pelicula_Prueba_"+i, 2000+i, "Director_Prueba_"+i, ger.gp.categoriasCine.get(i), Soporte.BLURAY);
			ger.addMusica("Musica_Prueba_"+i,2000+i, "Interprete_Prueba_"+i, ger.gp.categoriasMusica.get(i), Soporte.CD);
			ger.addSerie("Serie_Prueba_"+i, i, i, ger.gp.categoriasSeries.get(i), Soporte.DVD);
		}
	}
	
	public static void generarSocios(){
		for (int i=0;i<10;i++){
			ger.gs.addSocio("Socio_prueba_"+i,"Apellidos_Prueba_"+i, "Direccion_Prueba_"+i, "Telefono_prueba_"+i, "DNI_prueba_"+i);
		}
	}
}
