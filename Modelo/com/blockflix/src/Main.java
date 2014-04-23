package com.blockflix.src;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.blockflix.controller.ControlLoginPanel;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.empleado.Empleado;
import com.blockflix.src.gerente.Gerente;
import com.blockflix.view.VentanaPrincipal;

/** Clase principal de pruebas
 * @author Antonio Amate
 *
 */
public class Main {

	
	public static Empleado emp=null;
	public static Gerente ger=null;
	static boolean recargarTodo=false;
	
	/** Metodo main que ejecuta las pruebas
	 *  IMPORTANTE ------------------------------------- LAS PRUEBAS SUPONEN QUE FUNCIONA LA PASARELA DE PAGO
	 *  												SI FALLA, EJECUTAR EL PROGRAMA UNA VEZ CON recargarTodo=True
	 *  												Y POSTERIORMENTE EJECUTARLO CON recargarTodo=false
	 * @param args Vacío
	 */
	
	public static void main(String[] args) {
		
		
		
		// Cambiamos el theme de JSwing a Nimbus
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
		
		VentanaPrincipal vp = new VentanaPrincipal("BlockFlix");
		vp.setVisible(true);
	}
//		
//		emp=new Empleado();
//		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
//		Socio socioPrueba;
//		Producto p;
//		
//		
//		if (recargarTodo){
//			ger = Constantes.doLogin("admin", "password_gerente");
//			
//			recargarTodo();
//		}
//		else
//		{
//
//			//Productos para la prueba de alquiler
//			listaProductos.add(emp.gp.buscarProductoById(1));
//			listaProductos.add(emp.gp.buscarProductoById(2));
//			listaProductos.add(emp.gp.buscarProductoById(3));
//
//
//			//PRUEBAS
//
//
//			/*********** PERSISTENCIA DE FICHEROS ***************/
//			//Se imprimen todos los datos actuales que hay en memoria (se hace solo con una lista
//			//las demas funcionan igual
//			emp.gp.printListaProductos();
//			//Se guardan
//			emp.save();
//			System.out.println("\n Datos guardados en ficheros");
//			//Se resetean de memoria
//			emp.reset();
//			//Se intentan imprimir ahora para comprobar que no estan en memoria
//			System.out.println("\n Datos eliminados de memoria");
//			emp.gp.printListaProductos();
//			System.out.println("\n Datos cargados de ficheros");
//			emp.load();
//			emp.gp.printListaProductos();
//
//
//			/****************************************************/
//
//			/********** PRUEBAS DEL EMPLEADO ********************/
//
//			//		//Añadir socio
//			emp.gs.addSocio("Pepito", "Gutierrez", "C/ Aleatoria", "911911911","75756615X");
//			//		//Mostrar info socio
//			//		    //Buscar socio por DNI
//			socioPrueba=emp.gs.buscarSocio("75756615X");
//			System.out.println(socioPrueba.toString());	
//			//		//Modificar socio
//			emp.gs.modificarDatosSocio(socioPrueba.getnSocio(), "PepitoCambiado", "ApellidosCambiados", "DireccionCambiada", "telefonoCambiado", socioPrueba.getDni());
//			//		//Vemos los cambios (se mantiene el DNI)
//			socioPrueba=emp.gs.buscarSocio("75756615X");
//			System.out.println(socioPrueba.toString());
//
//			//Alquilamos productos para el socio sin tarifa de 3 productos 
//			emp.alquilar(socioPrueba.getnSocio(), listaProductos);
//
//			//Comprobamos que se ha realizado correctamente el alquiler (a no ser que falle la pasarela de pago, en cuyo caso habria que
//			//reiniciar las pruebas
//
//			emp.ga.printAlquileres();
//
//			//Devolvemos el alquiler
//
//			emp.devolverAlquiler(socioPrueba.getnSocio());
//
//			//Comprobamos que ya no hay alquileres
//
//			emp.ga.printAlquileres();
//
//			//Contratamos tarifa para el socio
//
//			emp.contratarTarifaSocio(socioPrueba.getnSocio(), TipoTarifa.PREMIUM, false);
//
//			//Volvemos a alquilar ahora no se nos cobra (tenemos tarifa premium)
//
//			emp.alquilar(socioPrueba.getnSocio(), listaProductos);
//
//			//Comprobamos que se ha alquilado
//			emp.ga.printAlquileres();
//
//			//Devolvemos el alquiler
//			emp.devolverAlquiler(socioPrueba.getnSocio());
//
//			//Sancionamos al socio (se haria automatico si se pasa de la fecha)
//			emp.gs.sancionarSocio(socioPrueba.getnSocio(), 10);
//
//			//No puede alquilar
//
//			emp.alquilar(socioPrueba.getnSocio(), listaProductos);
//
//			//Paga la sancion (suponiendo que la pasarela lo hace bien)
//
//			emp.pagarSancionSocio(socioPrueba.getnSocio());
//
//			//Intentamos alquilar ahora
//
//			emp.alquilar(socioPrueba.getnSocio(), listaProductos);
//
//			//Devolvemos el alquiler y eliminamos al socio
//			emp.devolverAlquiler(socioPrueba.getnSocio());
//
//
//
//			//		//Eliminamos al socio
//			emp.gs.eliminarSocio(socioPrueba.getnSocio());
//			//		//Comprobamos que no existe
//			if ((socioPrueba=emp.gs.buscarSocio("75756615X"))==null)
//				System.out.println("No existe el socio");
//
//
//			//Fin de la demostracion del empleado
//			emp.salir();
//			/***************************************************************************************************************/
//			
//			/**************************************** PRUEBAS GERENTE ******************************************************/
//			//Acceso mediante login
//			ger = Constantes.doLogin("admin", "password_gerente");
//			//Añadir producto
//			ger.addMusica("Musica agregada", 2000, "Aleatorio", "Categoria aleatoria", Soporte.VINILO);
//			//Comprobamos que se ha añadido 
//				//Buscar Producto
//				p=ger.gp.buscarProductoByNombre("Musica agregada");
//				System.out.println(((Musica)p).toString());
//				//Modificar Producto
//				ger.gp.modificarDatosMusica(p.getId(), "Nombre modificado", 2002, "Interprete modificado", "Categoria Aleatoria", Soporte.CD);
//				//Lo buscamos y vemos que ha cambiado
//				p=ger.gp.buscarProductoByNombre("Nombre modificado");
//				System.out.println(((Musica)p).toString());
//				//Lo eliminamos
//				ger.gp.eliminarMusica(p.getId());
//				//Comprobamos que no existe
//				if ((p=ger.gp.buscarProductoByNombre("Nombre modificado"))==null)
//					System.out.println("El producto no existe");
//			
//				ger.save();
//			
//			//Lista morosos sancionamos al socio de id1 con el empleado
//				emp.load();
//				emp.gs.sancionarSocio(2, 10);
//				emp.save();
//				ger.load();
//				ger.printListaMorosos();
//				
//			//Tops
//				//Mostramos el top10 de peliculas por ejemplo (el empleado alquilo peliculas por lo que habra incrementos)
//				ger.printTop10Peliculas();
//
//			
//			//Modificaciones en las variables del sistema (una de ejemplo, las demas funcionan igual) ademas los cambios persisten al
//				//reiniciar el sistema
//				System.out.println("\n Nombre actual del videoclub:"+Constantes.variables.NOMBRE_VIDEOCLUB);
//				ger.modificarNombreVideoclub("Nombre Modificado");
//				System.out.println("\n Nombre modificado del videoclub: "+Constantes.variables.NOMBRE_VIDEOCLUB);
//			ger.save();
//			
//			/***************************************************************************************************************/
//			
//			
//			//Al salir del programa se guardan los cambios de las variables del sistema ( se cargan por defecto)
//			Constantes.saveVariables();
//
//		}
//	}

	public static void recargarTodo(){
		ger.reset();
		ger.save();
		ger.load();
		generarProductos();
		generarSocios();
		generarEjemplares();
		ger.save();
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
