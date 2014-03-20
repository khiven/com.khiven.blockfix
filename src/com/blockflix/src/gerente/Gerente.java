package com.blockflix.src.gerente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.blockflix.src.alquiler.GestionAlquileres;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.ejemplar.GestionEjemplares;
import com.blockflix.src.productos.GestionProductos;
import com.blockflix.src.productos.Musica;
import com.blockflix.src.productos.Pelicula;
import com.blockflix.src.productos.Producto;
import com.blockflix.src.productos.Serie;
import com.blockflix.src.socios.GestionSocios;
import com.blockflix.src.socios.Socio;
import com.blockflix.src.tarifas.GestionTarifas;

public class Gerente {

	public GestionProductos gp;
	public GestionEjemplares ge;
	public GestionAlquileres ga;
	public GestionSocios gs;
	public GestionTarifas gt;

	public Gerente(){
		gp=new GestionProductos();
		ge=new GestionEjemplares();
		ga=new GestionAlquileres();
		gs=new GestionSocios();
		gt=new GestionTarifas();
	}

	/******************** AGREGAR *******************************/
	public void addPelicula(String nombre, int agno, String director, String categoria, Soporte soporte){
		//Comprobamos que no exista ya el producto
		if (gp.buscarPeliculaByNombre(nombre)!=null){
			System.out.println("\n El producto ya existe");
			return;
		}
		//Si no existe se añade
		gp.addPelicula(nombre, agno, director, categoria, soporte);
	}
	
	
	public void addMusica(String nombre, int agno, String interprete, String categoria, Soporte soporte){
		//Comprobamos que no exista ya el producto
		if (gp.buscarMusicaByNombre(nombre)!=null){
			System.out.println("\n El producto ya existe");
			return;
		}
		//Si no existe se añade
		gp.addMusica(nombre, agno, interprete, categoria, soporte);
	}
	
	
	public void addSerie(String nombre, int temporada, int volumen, String categoria, Soporte soporte){
		//Comprobamos que no exista ya el producto
		if (gp.buscarSerieByNombre(nombre)!=null){
			System.out.println("\n El producto ya existe");
			return;
		}
		//Si no existe se añade
		gp.addSerie(nombre, temporada, volumen, categoria, soporte);
	}

	/*********************************** MODIFICAR ********************************************/
	
	public void mostrarInfoProducto(int id){
		Producto p = gp.buscarProductoById(id);
		if (p==null){
			System.out.println("\n No existe tal producto");
		}
		
		System.out.println(p.toString());
	}
	
	public void modificarPelicula(int id, String nombre, int agno, String director, String categoria, Soporte soporte){
		if (gp.buscarPeliculaById(id)==null){
			System.out.println("\n No existe el producto");
			return;
		}
		else if (!isModificable(id)){
			System.out.println("\n No se puede modificar un producto que esta alguilado");
			return;
		}
		else{
		gp.modificarDatosPelicula(id, nombre, agno, director, categoria, soporte);
		}
	}

	public void modificarMusica(int id, String nombre, int agno, String interprete, String categoria, Soporte soporte){
		if (gp.buscarMusicaById(id)==null){
			System.out.println("\n No existe el producto");
			return;
		}
		else if (!isModificable(id)){
			System.out.println("\n No se puede modificar un producto que esta alguilado");
			return;
		}
		else{
		gp.modificarDatosMusica(id, nombre, agno, interprete, categoria, soporte);
		}
	}
	
	public void modificarSerie(int id, String nombre, int temporada, int volumen, String categoria, Soporte soporte){
		if (gp.buscarSerieById(id)==null){
			System.out.println("\n No existe el producto");
			return;
		}
		else if (!isModificable(id)){
			System.out.println("\n No se puede modificar un producto que esta alguilado");
			return;
		}
		else{
			gp.modificarDatosSerie(id, nombre, temporada, volumen, categoria, soporte);	
		}
		
	}

	/************************************************** ELIMINAR **********************************************/
	
	public void eliminarPelicula(int id){
		if (gp.buscarPeliculaById(id)==null){
			System.out.println("\n No existe el producto");
			return;
		}
		else if (!isModificable(id)){
			System.out.println("\n No se puede modificar un producto que esta alguilado");
			return;
		}
		else{
		gp.eliminarPelicula(id);
		ge.eliminarEjemplaresProducto(id);
		}
	}
	
	public void eliminarMusica(int id){
		if (gp.buscarMusicaById(id)==null){
			System.out.println("\n No existe el producto");
			return;
		}
		else if (!isModificable(id)){
			System.out.println("\n No se puede modificar un producto que esta alguilado");
			return;
		}
		else{
			gp.eliminarMusica(id);
			ge.eliminarEjemplaresProducto(id);
		}
	}
	public void eliminarSerie(int id){
		if (gp.buscarSerieById(id)==null){
			System.out.println("\n No existe el producto");
			return;
		}
		else if (!isModificable(id)){
			System.out.println("\n No se puede modificar un producto que esta alguilado");
			return;
		}
		else{
			gp.eliminarSerie(id);
			ge.eliminarEjemplaresProducto(id);
		}
	}
	
	
	
	
	/******************** CHECKS **************************/
	
	public void printListaMorosos(){
		ArrayList<Socio> listaMorosos = gs.getListaMorosos();
		if (listaMorosos.isEmpty()){
			System.out.println("\n No hay socios morosos");
		}
		else{
			System.out.println("\nLista de morosos: \n");
			for (Socio socio : listaMorosos){
				System.out.println(socio.toString());
			}
		}
	}
	
	public void printTop10Peliculas(){
		ArrayList<Pelicula> top10 = gp.getTop10Peliculas();
		 Collections.sort(top10, new Comparator<Pelicula>() {
		        @Override public int compare(Pelicula p1, Pelicula p2) {
		            return p1.getVecesAlquilado()- p2.getVecesAlquilado();
		        }

		    });
		 System.out.println("\n Top 10 Peliculas");
		 for (Pelicula p : top10){
			 System.out.println("\n"+p.toString());
		 }
	}
	
	public void printTop10Series(){
		ArrayList<Serie> top10 = gp.getTop10Series();
		Collections.sort(top10, new Comparator<Serie>() {
			@Override public int compare(Serie p1, Serie p2) {
				return p1.getVecesAlquilado()- p2.getVecesAlquilado();
			}
			
		});
		System.out.println("\n Top 10 Series");
		for (Serie p : top10){
			System.out.println("\n"+p.toString());
		}
	}
	
	public void printTop10Musica(){
		ArrayList<Musica> top10 = gp.getTop10Musica();
		Collections.sort(top10, new Comparator<Musica>() {
			@Override public int compare(Musica p1, Musica p2) {
				return p1.getVecesAlquilado()- p2.getVecesAlquilado();
			}
			
		});
		System.out.println("\n Top 10 Musica");
		for (Musica p : top10){
			System.out.println("\n"+p.toString());
		}
	}
	
	
	public boolean isModificable(int id){
		return !ge.hayEjemplaresAlquilados(id);
	}
	
	public void modificarPrecioAlquilerPelicula(double nuevoPrecio){
		Constantes.variables.PRECIO_ALQUILER_PELICULA=nuevoPrecio;
	}
	public void modificarPrecioAlquilerSeries(double nuevoPrecio){
		Constantes.variables.PRECIO_ALQUILER_SERIE=nuevoPrecio;
	}
	public void modificarPrecioAlquilerMusica(double nuevoPrecio){
		Constantes.variables.PRECIO_ALQUILER_MUSICA=nuevoPrecio;
	}
	
	public void modificarTarifa(TipoTarifa tarifa, float precio, float precioExtension, int tiempo, int tiempoExtension){
		gt.modificarTarifa(tarifa, precio, precioExtension, tiempo, tiempoExtension);
	}
	
	public void modificarTiempoAlquiler(int nuevosDiasAlquiler){
		Constantes.variables.DURACION_ALQUILER = nuevosDiasAlquiler;
	}
	
	public void modificarNombreVideoclub(String nuevoNombre){
		Constantes.variables.NOMBRE_VIDEOCLUB=nuevoNombre;
	}
	
	public void modificarSancionPorDia(double nuevaSancion){
		Constantes.variables.SANCION_POR_DIA =nuevaSancion;
	}
	
	public void load(){
		
		gs.reloadSocios();
		gt.loadTarifas();
		gp.loadProductos();
		gp.loadCategorias();
		ge.loadEjemplares();
		ga.loadAlquileres();
		
	}
	
	public void save(){
		gs.saveSocios();
		gt.saveTarifas();
		gp.saveProductos();
		ge.saveEjemplares();
		ga.saveAlquileres();
	}
	
	public void reset(){
		gs.resetSocios();
		gp.resetProductos();
		gp.resetCategorias();
		ge.resetEjemplares();
		ga.resetAlquileres();
	}
	
	public void exit(){
		save();
		
	}
}
