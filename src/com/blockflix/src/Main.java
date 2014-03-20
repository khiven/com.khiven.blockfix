package com.blockflix.src;

import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.empleado.Empleado;
import com.blockflix.src.gerente.Gerente;
import com.blockflix.src.productos.Producto;


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
		
		emp=new Empleado();
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		
		listaProductos.add(emp.gp.buscarProductoById(1));
		listaProductos.add(emp.gp.buscarProductoById(2));
		
//		for (Producto p: listaProductos){
//			//System.out.println("\nProducto a alquilar: "+p.toString());
//			System.out.println(p.getTipo().toString());
//		}

//		generarProductos();
//		generarSocios();
//		generarEjemplares();
		
//	ger.printTop10Peliculas();	
	ger.printTop10Musica();
		
		
//		emp.contratarTarifaSocio(1, TipoTarifa.PELICULAS, false);
//		emp.gc.printListaContratos();
		
//	emp.alquilar(1, listaProductos);
//		emp.ga.printAlquileres();
//		emp.ge.printEjemplares();
//		emp.devolverAlquiler(1);

//				ger.gs.printListaSocios();
//				ger.gp.printListaProductos();
//				ger.ge.printEjemplares();
////				
//				ger.save();
////				
//				ger.reset();
//				System.out.println("\n ELIMINADOS TODOS LOS DATOS DE MEMORIA");
//				ger.gs.printListaSocios();
//				ger.gp.printListaProductos();
//				ger.ge.printEjemplares();
//				System.out.println("\n CARGANDO TODOS LOS DATOS DE FICHEROS");
//				ger.load();
//				ger.gs.printListaSocios();
//				ger.gp.printListaProductos();
//				ger.ge.printEjemplares();
		
	

		Constantes.saveVariables();

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

	public static void generarEjemplares(){
		for (int i=0;i<30;i++){
			ger.ge.addEjemplar(i);
		}
	}
}
