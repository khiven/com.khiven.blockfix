package com.blockflix.src.productos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;

public class GestionProductos {


	private ArrayList<String> categoriasCine;
	private ArrayList<String> categoriasSeries;
	private ArrayList<String> categoriasMusica;

	private ArrayList<Pelicula> listaPeliculas;
	private ArrayList<Serie> listaSeries;
	private ArrayList<Musica> listaMusica;

	private int lastIdProducto;

	public GestionProductos(){
		categoriasCine = new ArrayList<String>();
		categoriasSeries= new ArrayList<String>();
		categoriasMusica = new ArrayList<String>();
		this.loadCategorias();
		loadProductos();
		setLastIdProducto();
	}

	/************************************************************************PRODUCTOS *******************************************/


	public void loadProductos(){
		this.listaPeliculas=loadPeliculas();
		this.listaSeries=loadSeries();
		this.listaMusica=loadMusica();
	}

	public void saveProductos(){
		this.savePeliculas();
		this.saveSeries();
		this.saveMusica();
	}


	public void setLastIdProducto(){
		ArrayList<Producto> productos = new ArrayList<Producto>();

		productos.addAll(this.listaPeliculas);
		productos.addAll(this.listaSeries);
		productos.addAll(this.listaMusica);
		int aux=0;
		for(Producto p: productos){
			aux =  aux > p.getId() ? aux : p.getId();
		}
		this.lastIdProducto = aux;
	}

	public void printListaProductos(){
		printListaPeliculas();
		printListaSeries();
		printListaMusica();
	}

	public void resetProductos(){
		resetPeliculas();
		resetSeries();
		resetMusica();
	}
	public Producto buscarProductoById(int id){
		Producto p= buscarPeliculaById(id);
		if (p==null){
			p=buscarSerieById(id);
			if (p==null){
				p=buscarMusicaById(id);
				if (p==null) return null;
			}
		}
		return p;
	}
	
	public Producto buscarProductoByNombre(String nombre){
		Producto p = buscarPeliculaByNombre(nombre);
		if (p==null){
			p=buscarSerieByNombre(nombre);
			if (p==null){
				p=buscarMusicaByNombre(nombre);
				if (p==null) return null;
			}
		}
		return p;
	}
	
	public ArrayList<Producto> buscarProductoByCategoria(String cat){
		ArrayList<Producto> p = new ArrayList<Producto>(); 
		p.addAll(buscarPeliculaByCategoria(cat));
		if (p.isEmpty()){
			p.addAll(buscarSeriesByCategoria(cat));
			if (p.isEmpty()){
				p.addAll(buscarMusicaByCategoria(cat));
				if (p.isEmpty()) return null;
			}
		}
		return p;
	}
	
	
	
	/**************************** PELICULAS *******************************/
	public ArrayList<Pelicula> loadPeliculas(){

		Object aux;
		ObjectInputStream ois;
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_PELICULAS));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Pelicula){
					peliculas.add((Pelicula)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return peliculas;

	}

	public void savePeliculas(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_PELICULAS));

			for(Pelicula pelicula : listaPeliculas){
				oos.writeObject(pelicula);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pelicula buscarPeliculaById(int id){
		for (Pelicula p : listaPeliculas){
			if (p.getId()==id) return p;
		}
		return null;
	}
	
	public Pelicula buscarPeliculaByNombre(String nombre){
		for (Pelicula p : listaPeliculas){
			if (p.getNombre().equals(nombre)) return p;
		}
		return null;
	}


	public ArrayList<Pelicula> buscarPeliculaByCategoria(String cat){
		ArrayList<Pelicula> resultados = new ArrayList<Pelicula>();
		for (Pelicula x : listaPeliculas){
			if (x.getCategoria().equals(cat)) resultados.add(x);
		}
		return resultados;
	}


	public void addPelicula(String nombre, int agno, String director, String categoria, Soporte soporte){

		Pelicula p = new Pelicula(nombre,agno,director,categoria,soporte,++this.lastIdProducto);
		listaPeliculas.add(p);
	}

	
	public void modificarDatosPelicula(int id,String nombre,int agno,String director,String categoria,Soporte soporte){
		for (Pelicula aux : listaPeliculas)
			if (aux.getId()==id){
				aux.setNombre(nombre);
				aux.setAgno(agno);
				aux.setDirector(director);
				aux.setCategoria(categoria);
				aux.setSoporte(soporte);
				this.savePeliculas();
				return;
			}
	}
	
	public void eliminarPelicula(int id){
		for (Pelicula aux : listaPeliculas){
			if (aux.getId()==id){
				listaPeliculas.remove(aux);
				this.savePeliculas();
				return;
			}
		}
	}
	
	
	
	
	public void printListaPeliculas(){
		for (Pelicula p : listaPeliculas){
			System.out.println();
			System.out.println(p.toString());
		}
	}
	
	
	public void resetPeliculas(){
		this.listaPeliculas.clear();
	}


	/**************************************************************************************************************/
	/**************************** SERIES *******************************/
	public ArrayList<Serie> loadSeries(){

		Object aux;
		ObjectInputStream ois;
		ArrayList<Serie> series= new ArrayList<Serie>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_SERIES));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Serie){
					series.add((Serie)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return series;

	}

	public void saveSeries(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_SERIES));

			for(Serie serie: listaSeries){
				oos.writeObject(serie);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Serie buscarSerieById(int id){
		for (Serie p : listaSeries){
			if (p.getId()==id) return p;
		}
		return null;
	}
	
	public Serie buscarSerieByNombre(String nombre){
		for (Serie s : listaSeries){
			if (s.getNombre().equals(nombre)) return s;
		}
		return null;
	}

	public ArrayList<Serie> buscarSeriesByCategoria(String cat){
		ArrayList<Serie> resultados = new ArrayList<Serie>();
		for (Serie x : listaSeries){
			if (x.getCategoria().equals(cat)) resultados.add(x);
		}
		return resultados;
	}


	public void addSerie(String nombre, int temporada, int volumen, String categoria, Soporte soporte){

		Serie p = new Serie(nombre,temporada,volumen,categoria,soporte,++this.lastIdProducto);
		listaSeries.add(p);
	}

	
	public void modificarDatosSerie(int id,String nombre,int temporada,int volumen,String categoria,Soporte soporte){
		for (Serie aux : listaSeries)
			if (aux.getId()==id){
				aux.setNombre(nombre);
				aux.setTemporada(temporada);
				aux.setVolumen(volumen);
				aux.setCategoria(categoria);
				aux.setSoporte(soporte);
				this.saveSeries();
				return;
			}
	}
	
	public void eliminarSerie(int id){
		for (Serie aux : listaSeries){
			if (aux.getId()==id){
				listaSeries.remove(aux);
				this.saveSeries();
				return;
			}
		}
	}
	
	public void printListaSeries(){
		for (Serie p : listaSeries){
			System.out.println();
			System.out.println(p.toString());
		}
	}

	public void resetSeries(){
		this.listaSeries.clear();
	}
	/**************************************************************************************************************/



	/**************************** MUSICA *******************************/
	public ArrayList<Musica> loadMusica(){

		Object aux;
		ObjectInputStream ois;
		ArrayList<Musica> musicas= new ArrayList<Musica>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_MUSICA));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Musica){
					musicas.add((Musica)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return musicas;

	}

	public void saveMusica(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_MUSICA));

			for(Musica musica: listaMusica){
				oos.writeObject(musica);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Musica buscarMusicaById(int id){
		for (Musica p : listaMusica){
			if (p.getId()==id) return p;
		}
		return null;
	}
	
	public Musica buscarMusicaByNombre(String nombre){
		for (Musica m : listaMusica){
			if (m.getNombre().equals(nombre)) return m;
		}
		return null;
	}

	public ArrayList<Musica> buscarMusicaByCategoria(String cat){
		ArrayList<Musica> resultados = new ArrayList<Musica>();
		for (Musica x : listaMusica){
			if (x.getCategoria().equals(cat)) resultados.add(x);
		}
		return resultados;
	}
	
	public void addMusica(String nombre, int agno, String interprete, String categoria, Soporte soporte){

		Musica p = new Musica(nombre,agno,interprete,categoria,soporte,++this.lastIdProducto);
		listaMusica.add(p);
	}
	
	public void modificarDatosMusica(int id,String nombre,int agno,String interprete,String categoria,Soporte soporte){
		for (Musica aux : listaMusica)
			if (aux.getId()==id){
				aux.setNombre(nombre);
				aux.setAgno(agno);
				aux.setInterprete(interprete);
				aux.setCategoria(categoria);
				aux.setSoporte(soporte);
				this.saveMusica();
				return;
			}
	}
	
	public void eliminarMusica(int id){
		for (Musica aux : listaMusica){
			if (aux.getId()==id){
				listaMusica.remove(aux);
				this.saveMusica();
				return;
			}
		}
	}
	
	
	public void printListaMusica(){
		for (Musica p : listaMusica){
			System.out.println();
			System.out.println(p.toString());
		}
	}
	
	public void resetMusica(){
		this.listaMusica.clear();
	}
	
	/**************************************************************************************************************/




	/***************************************************************************************************************************/

	/************************************************************************CATEGORIAS ****************************************/
	public void loadCategoria(TipoProducto tipoCat,String filePath){

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));


			String line = br.readLine();
			while (line != null){
				switch (tipoCat) {
				case PELICULA:
					this.categoriasCine.add(line);
					break;
				case SERIE :
					this.categoriasSeries.add(line);
					break;
				case MUSICA :
					this.categoriasMusica.add(line);
					break;
				}
				line = br.readLine();
			}
			br.close();
		}catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void loadCategorias(){
		this.loadCategoria(TipoProducto.PELICULA, Constantes.PATH_CATEGORIAS_PELICULAS);
		this.loadCategoria(TipoProducto.SERIE, Constantes.PATH_CATEGORIAS_SERIES);
		this.loadCategoria(TipoProducto.MUSICA, Constantes.PATH_CATEGORIAS_MUSICA);
	}

	public void printCategoria(TipoProducto cat){
		ArrayList<String> aux;
		switch (cat) {
		case PELICULA:
			aux=this.categoriasCine;
			System.out.println();
			System.out.println("Categorias de Cine");
			break;
		case SERIE :
			aux=this.categoriasSeries;
			System.out.println();
			System.out.println("Categorias de Series");
			break;
		case MUSICA :
			aux=this.categoriasMusica;
			System.out.println();
			System.out.println("Categorias de Musica");
			break;
		default:
			aux=null;
		}
		if (aux!=null){

			for (int i=0;i< aux.size();i++){
				System.out.println(aux.get(i));
			}
		}

	}

	public void printeCategorias(){
		printCategoria(TipoProducto.PELICULA);
		printCategoria(TipoProducto.SERIE);
		printCategoria(TipoProducto.MUSICA);
	}
	
	public void resetCategorias(){
		this.categoriasCine.clear();
		this.categoriasSeries.clear();
		this.categoriasMusica.clear();
	}
	/*************************************************************************************************************************/


}
