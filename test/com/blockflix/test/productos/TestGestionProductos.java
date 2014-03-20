package com.blockflix.test.productos;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.productos.Musica;
import com.blockflix.src.productos.Pelicula;
import com.blockflix.src.productos.Serie;
import com.blockflix.src.productos.GestionProductos;

public class TestGestionProductos {

	@Test
	public void testGestionProductos() {
		GestionProductos gestion = new GestionProductos();
		assertNotNull(gestion);
	}

	@Test
	public void testLoadProductos() {
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		int id = 4;
		GestionProductos gestion2 = new GestionProductos();
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		ObjectOutputStream oos;
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte,id);
		peliculas.add(pelicula);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_PELICULAS));

			for(Pelicula pelicula1 : peliculas){
				oos.writeObject(pelicula1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion2.loadProductos();
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getAgno(),pelicula.getAgno());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getCategoria(),pelicula.getCategoria());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getDirector(),pelicula.getDirector());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getNombre(),pelicula.getNombre());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getSoporte(),pelicula.getSoporte());
	}

	@Test
	public void testSaveProductos() {
		GestionProductos gestion = new GestionProductos();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		gestion.addPelicula(nombre,agno,director,categoria,soporte);
		int id = gestion.buscarPeliculaByNombre(nombre).getId();
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte,id);
		gestion.saveProductos();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_PELICULAS));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Pelicula){
					peliculas.add((Pelicula)aux);
					pelicula = peliculas.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.buscarPeliculaByNombre(nombre).toString(),pelicula.toString());
	}

	@Test
	public void testResetProductos() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gestion.buscarPeliculaByNombre(nombre));
		gestion.resetProductos();
		assertNull(gestion.buscarPeliculaByNombre(nombre));
	}

	@Test
	public void testBuscarProductoById() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		int id = 3;
		assertNull(gestion.buscarProductoById(id));
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		id = gestion.buscarPeliculaByNombre(nombre).getId();
		assertNotNull(gestion.buscarProductoById(id));
	}

	@Test
	public void testBuscarProductoByNombre() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		assertNull(gestion.buscarProductoByNombre(nombre));
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gestion.buscarProductoByNombre(nombre));
	}

	@Test
	public void testBuscarProductoByCategoria() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Fantasia";
		Soporte soporte = Soporte.BLURAY;
		assertNull(gestion.buscarProductoByCategoria(categoria));
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertEquals(gestion.buscarProductoByCategoria(categoria).size(),1);
	}
	
	@Test
	public void testLoadPeliculas() {
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		int id = 4;
		GestionProductos gestion2 = new GestionProductos();
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		ObjectOutputStream oos;
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte,id);
		peliculas.add(pelicula);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_PELICULAS));

			for(Pelicula pelicula1 : peliculas){
				oos.writeObject(pelicula1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion2.loadPeliculas();
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getAgno(),pelicula.getAgno());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getCategoria(),pelicula.getCategoria());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getDirector(),pelicula.getDirector());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getNombre(),pelicula.getNombre());
		assertEquals(gestion2.buscarPeliculaByNombre(nombre).getSoporte(),pelicula.getSoporte());
	}

	@Test
	public void testSavePeliculas() {
		GestionProductos gestion = new GestionProductos();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		gestion.addPelicula(nombre,agno,director,categoria,soporte);
		int id = gestion.buscarPeliculaByNombre(nombre).getId();
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte,id);
		gestion.savePeliculas();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_PELICULAS));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Pelicula){
					peliculas.add((Pelicula)aux);
					pelicula = peliculas.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.buscarPeliculaByNombre(nombre).toString(),pelicula.toString());
	}

	@Test
	public void testBuscarPeliculaById() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		int id = 3;
		assertNull(gestion.buscarPeliculaById(id));
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		id = gestion.buscarPeliculaByNombre(nombre).getId();
		assertNotNull(gestion.buscarPeliculaById(id));
	}

	@Test
	public void testBuscarPeliculaByNombre() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		assertNull(gestion.buscarPeliculaByNombre(nombre));
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gestion.buscarPeliculaByNombre(nombre));
	}

	@Test
	public void testBuscarPeliculaByCategoria() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		assertEquals(gestion.buscarPeliculaByCategoria(categoria).size(),0);
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertEquals(gestion.buscarPeliculaByCategoria(categoria).size(),1);
	}
	
	@Test
	public void testAddPelicula() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		assertNull(gestion.buscarPeliculaByNombre(nombre));
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gestion.buscarPeliculaByNombre(nombre));
	}

	@Test
	public void testModificarDatosPelicula() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		String nombre2 = "Crash";
		int agno = 2013;
		int agno2 = 2014;
		String director = "Cuaron";
		String director2 = "Woody Allen";
		String categoria = "Ciencia Ficcion";
		String categoria2 = "Comedia";
		Soporte soporte = Soporte.BLURAY;
		Soporte soporte2 = Soporte.DVD;
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		int id = gestion.buscarPeliculaByNombre(nombre).getId();
		assertNull(gestion.buscarPeliculaByNombre(nombre2));
		gestion.modificarDatosPelicula(id, nombre2, agno2, director2, categoria2, soporte2);
		assertNotNull(gestion.buscarPeliculaByNombre(nombre2));
		assertEquals(gestion.buscarPeliculaByNombre(nombre2).getAgno(),agno2);
		assertEquals(gestion.buscarPeliculaByNombre(nombre2).getDirector(),director2);
		assertEquals(gestion.buscarPeliculaByNombre(nombre2).getCategoria(),categoria2);
		assertEquals(gestion.buscarPeliculaByNombre(nombre2).getSoporte(),soporte2);
		assertEquals(gestion.buscarPeliculaByNombre(nombre2).getNombre(),nombre2);
		gestion.modificarDatosPelicula(id, nombre, agno, director, categoria, soporte);
	}
	
	@Test
	public void testEliminarPelicula() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gestion.buscarPeliculaByNombre(nombre));
		int id = gestion.buscarPeliculaByNombre(nombre).getId();
		gestion.eliminarPelicula(id);
		assertNull(gestion.buscarPeliculaByNombre(nombre));
	}
	
	@Test
	public void testResetPeliculas() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetPeliculas();
		gestion.setLastIdProducto();
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		gestion.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gestion.buscarPeliculaByNombre(nombre));
		gestion.resetPeliculas();
		assertNull(gestion.buscarPeliculaByNombre(nombre));
	}
	
	@Test
	public void testLoadSeries() {
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		int id = 7;
		GestionProductos gestion2 = new GestionProductos();
		ArrayList<Serie> series = new ArrayList<Serie>();
		ObjectOutputStream oos;
		Serie serie = new Serie(nombre,temporada,volumen,categoria,soporte,id);
		series.add(serie);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_SERIES));

			for(Serie serie1 : series){
				oos.writeObject(serie1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion2.loadSeries();
		assertEquals(gestion2.buscarSerieByNombre(nombre).getTemporada(),serie.getTemporada());
		assertEquals(gestion2.buscarSerieByNombre(nombre).getCategoria(),serie.getCategoria());
		assertEquals(gestion2.buscarSerieByNombre(nombre).getVolumen(),serie.getVolumen());
		assertEquals(gestion2.buscarSerieByNombre(nombre).getNombre(),serie.getNombre());
		assertEquals(gestion2.buscarSerieByNombre(nombre).getSoporte(),serie.getSoporte());
	}

	@Test
	public void testSaveSeries() {
		GestionProductos gestion = new GestionProductos();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Serie> series = new ArrayList<Serie>();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		int id = gestion.buscarSerieByNombre(nombre).getId();
		Serie serie = new Serie(nombre,temporada,volumen,categoria,soporte,id);
		gestion.saveSeries();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_SERIES));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Serie){
					series.add((Serie)aux);
					serie = series.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.buscarSerieByNombre(nombre).toString(),serie.toString());
	}

	@Test
	public void testBuscarSerieById() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		int id = 4;
		assertNull(gestion.buscarSerieById(id));
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		id = gestion.buscarSerieByNombre(nombre).getId();
		assertNotNull(gestion.buscarSerieById(id));
	}

	@Test
	public void testBuscarSerieByNombre() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		assertNull(gestion.buscarSerieByNombre(nombre));
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		assertNotNull(gestion.buscarSerieByNombre(nombre));
	}

	@Test
	public void testBuscarSerieByCategoria() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		assertEquals(gestion.buscarSeriesByCategoria(categoria).size(),0);
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		assertEquals(gestion.buscarSeriesByCategoria(categoria).size(),1);
	}
	
	@Test
	public void testAddSerie() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		assertNull(gestion.buscarSerieByNombre(nombre));
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		assertNotNull(gestion.buscarSerieByNombre(nombre));
	}

	@Test
	public void testModificarDatosSerie() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		String nombre2 = "Shameless UK";
		int temporada2 = 7;
		int volumen2 = 14;
		String categoria2 = "comedia2";
		Soporte soporte2 = Soporte.BLURAY;
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		int id = gestion.buscarSerieByNombre(nombre).getId();
		assertNull(gestion.buscarSerieByNombre(nombre2));
		gestion.modificarDatosSerie(id, nombre2, temporada2, volumen2, categoria2, soporte2);
		assertNotNull(gestion.buscarSerieByNombre(nombre2));
		assertEquals(gestion.buscarSerieByNombre(nombre2).getTemporada(),temporada2);
		assertEquals(gestion.buscarSerieByNombre(nombre2).getVolumen(),volumen2);
		assertEquals(gestion.buscarSerieByNombre(nombre2).getCategoria(),categoria2);
		assertEquals(gestion.buscarSerieByNombre(nombre2).getSoporte(),soporte2);
		assertEquals(gestion.buscarSerieByNombre(nombre2).getNombre(),nombre2);
		gestion.modificarDatosSerie(id, nombre, temporada, volumen, categoria, soporte);
	}
	
	@Test
	public void testEliminarSerie() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		assertNotNull(gestion.buscarSerieByNombre(nombre));
		int id = gestion.buscarSerieByNombre(nombre).getId();
		gestion.eliminarSerie(id);
		assertNull(gestion.buscarSerieByNombre(nombre));
	}

	@Test
	public void testResetSeries() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetSeries();
		gestion.setLastIdProducto();
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		gestion.addSerie(nombre,temporada,volumen,categoria,soporte);
		assertNotNull(gestion.buscarSerieByNombre(nombre));
		gestion.resetSeries();
		assertNull(gestion.buscarSerieByNombre(nombre));
	}

	@Test
	public void testLoadMusica() {
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		int id = 2;
		GestionProductos gestion2 = new GestionProductos();
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		ObjectOutputStream oos;
		Musica musica = new Musica(nombre,agno,interprete,categoria,soporte,id);
		musicas.add(musica);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_MUSICA));

			for(Musica musica1 : musicas){
				oos.writeObject(musica1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion2.loadMusica();
		assertEquals(gestion2.buscarMusicaByNombre(nombre).getAgno(),musica.getAgno());
		assertEquals(gestion2.buscarMusicaByNombre(nombre).getCategoria(),musica.getCategoria());
		assertEquals(gestion2.buscarMusicaByNombre(nombre).getInterprete(),musica.getInterprete());
		assertEquals(gestion2.buscarMusicaByNombre(nombre).getNombre(),musica.getNombre());
		assertEquals(gestion2.buscarMusicaByNombre(nombre).getSoporte(),musica.getSoporte());
	}

	@Test
	public void testSaveMusica() {
		GestionProductos gestion = new GestionProductos();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		int id = gestion.buscarMusicaByNombre(nombre).getId();
		Musica musica =  new Musica(nombre,agno,interprete,categoria,soporte,id);
		gestion.saveMusica();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_MUSICA));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Musica){
					musicas.add((Musica)aux);
					musica = musicas.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.buscarMusicaByNombre(nombre).toString(),musica.toString());
	}

	@Test
	public void testBuscarMusicaById() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		int id = 2;
		assertNull(gestion.buscarMusicaById(id));
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		id = gestion.buscarMusicaByNombre(nombre).getId();
		assertNotNull(gestion.buscarMusicaById(id));
	}

	@Test
	public void testBuscarMusicaByNombre() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		assertNull(gestion.buscarMusicaByNombre(nombre));
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		assertNotNull(gestion.buscarMusicaByNombre(nombre));
	}

	@Test
	public void testBuscarMusicaByCategoria() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		assertEquals(gestion.buscarMusicaByCategoria(categoria).size(),0);
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		assertEquals(gestion.buscarMusicaByCategoria(categoria).size(),1);
	}
	
	@Test
	public void testAddMusica() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		assertNull(gestion.buscarMusicaByNombre(nombre));
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		assertNotNull(gestion.buscarMusicaByNombre(nombre));
	}

	@Test
	public void testModificarDatosMusica() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		String nombre2 = "La menor";
		int agno2 = 2789;
		String interprete2 = "Elton Johannes";
		String categoria2 = "Clasica";
		Soporte soporte2 = com.blockflix.src.constantes.Constantes.Soporte.CD;
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		int id = gestion.buscarMusicaByNombre(nombre).getId();
		assertNull(gestion.buscarMusicaByNombre(nombre2));
		gestion.modificarDatosMusica(id, nombre2, agno2, interprete2, categoria2, soporte2);
		assertNotNull(gestion.buscarMusicaByNombre(nombre2));
		assertEquals(gestion.buscarMusicaByNombre(nombre2).getAgno(),agno2);
		assertEquals(gestion.buscarMusicaByNombre(nombre2).getInterprete(),interprete2);
		assertEquals(gestion.buscarMusicaByNombre(nombre2).getCategoria(),categoria2);
		assertEquals(gestion.buscarMusicaByNombre(nombre2).getSoporte(),soporte2);
		assertEquals(gestion.buscarMusicaByNombre(nombre2).getNombre(),nombre2);
		gestion.modificarDatosMusica(id, nombre, agno, interprete, categoria, soporte);
	}
	
	/*@Test
	public void testEliminarMusica() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = Soporte.VINILO;
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		assertNotNull(gestion.buscarMusicaByNombre(nombre));
		int id = gestion.buscarMusicaByNombre(nombre).getId();
		gestion.eliminarMusica(id);
		assertNull(gestion.buscarMusicaByNombre(nombre));
	}*/

	@Test
	public void testResetMusica() {
		GestionProductos gestion = new GestionProductos();
		gestion.resetMusica();
		gestion.setLastIdProducto();
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		gestion.addMusica(nombre,agno,interprete,categoria,soporte);
		assertNotNull(gestion.buscarMusicaByNombre(nombre));
		gestion.resetMusica();
		assertNull(gestion.buscarMusicaByNombre(nombre));
	}
	
}
