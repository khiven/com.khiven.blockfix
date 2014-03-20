package com.blockflix.test.gerente;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.gerente.Gerente;

public class TestGerente {

	@Test
	public void testGerente() {
		Gerente gerente = new Gerente();
		assertNotNull(gerente);
	}

	@Test
	public void testAddPelicula() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String director = "director";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetPeliculas();
		assertNull(gerente.gp.buscarPeliculaByNombre(nombre));
		gerente.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gerente.gp.buscarPeliculaByNombre(nombre));
	}

	@Test
	public void testAddMusica() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String interprete = "interprete";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetMusica();
		assertNull(gerente.gp.buscarMusicaByNombre(nombre));
		gerente.addMusica(nombre, agno, interprete, categoria, soporte);
		assertNotNull(gerente.gp.buscarMusicaByNombre(nombre));
	}

	@Test
	public void testAddSerie() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int temporada = 1000;
		int volumen = 100;
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetSeries();
		assertNull(gerente.gp.buscarSerieByNombre(nombre));
		gerente.addSerie(nombre, temporada, volumen, categoria, soporte);
		assertNotNull(gerente.gp.buscarSerieByNombre(nombre));
	}

	@Test
	public void testModificarPelicula() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String director = "director";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		String nombre2 = "nombre2";
		int agno2 = 10002;
		String director2 = "director2";
		String categoria2 = "categoria2";
		Soporte soporte2 = Soporte.DVD;
		gerente.gp.resetPeliculas();
		gerente.addPelicula(nombre, agno, director, categoria, soporte);
		int id = gerente.gp.buscarPeliculaByNombre(nombre).getId();
		assertNull(gerente.gp.buscarPeliculaByNombre(nombre2));
		gerente.modificarPelicula(id, nombre2, agno2, director2, categoria2, soporte2);
		assertNotNull(gerente.gp.buscarPeliculaByNombre(nombre2));
	}

	@Test
	public void testModificarMusica() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String interprete = "interprete";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		String nombre2 = "nombre2";
		int agno2 = 10002;
		String interprete2 = "interprete2";
		String categoria2 = "categoria2";
		Soporte soporte2 = Soporte.DVD;
		gerente.gp.resetMusica();
		gerente.addMusica(nombre, agno, interprete, categoria, soporte);
		int id = gerente.gp.buscarMusicaByNombre(nombre).getId();
		assertNull(gerente.gp.buscarMusicaByNombre(nombre2));
		gerente.modificarMusica(id, nombre2, agno2, interprete2, categoria2, soporte2);
		assertNotNull(gerente.gp.buscarMusicaByNombre(nombre2));
	}

	@Test
	public void testModificarSerie() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int temporada = 1000;
		int volumen = 100;
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		String nombre2 = "nombre2";
		int temporada2 = 10002;
		int volumen2 = 1002;
		String categoria2 = "categoria2";
		Soporte soporte2 = Soporte.DVD;
		gerente.gp.resetSeries();
		gerente.addSerie(nombre, temporada, volumen, categoria, soporte);
		int id = gerente.gp.buscarSerieByNombre(nombre).getId();
		assertNull(gerente.gp.buscarSerieByNombre(nombre2));
		gerente.modificarSerie(id, nombre2, temporada2, volumen2, categoria2, soporte2);
		assertNotNull(gerente.gp.buscarSerieByNombre(nombre2));
		
	}

	@Test
	public void testEliminarPelicula() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String director = "director";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetPeliculas();
		gerente.addPelicula(nombre, agno, director, categoria, soporte);
		int id = gerente.gp.buscarPeliculaByNombre(nombre).getId();
		assertNotNull(gerente.gp.buscarPeliculaByNombre(nombre));
		gerente.eliminarPelicula(id);
		assertNull(gerente.gp.buscarPeliculaByNombre(nombre));
	}

	@Test
	public void testEliminarMusica() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String interprete = "interprete";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetMusica();
		gerente.addMusica(nombre, agno, interprete, categoria, soporte);
		int id = gerente.gp.buscarMusicaByNombre(nombre).getId();
		assertNotNull(gerente.gp.buscarMusicaByNombre(nombre));
		gerente.eliminarMusica(id);
		assertNull(gerente.gp.buscarMusicaByNombre(nombre));
	}

	@Test
	public void testEliminarSerie() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int temporada = 1000;
		int volumen = 100;
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetSeries();
		gerente.addSerie(nombre, temporada, volumen, categoria, soporte);
		int id = gerente.gp.buscarSerieByNombre(nombre).getId();
		assertNotNull(gerente.gp.buscarSerieByNombre(nombre));
		gerente.eliminarSerie(id);
		assertNull(gerente.gp.buscarSerieByNombre(nombre));
	}

	@Test
	public void testModificarPrecioAlquilerPelicula() {
		Gerente gerente = new Gerente();
		gerente.modificarPrecioAlquilerPelicula(5);
		assertEquals(5,Constantes.variables.PRECIO_ALQUILER_PELICULA,0.1);
	}

	@Test
	public void testModificarPrecioAlquilerSeries() {
		Gerente gerente = new Gerente();
		gerente.modificarPrecioAlquilerSeries(5);
		assertEquals(5,Constantes.variables.PRECIO_ALQUILER_SERIE,0.1);
	}

	@Test
	public void testModificarPrecioAlquilerMusica() {
		Gerente gerente = new Gerente();
		gerente.modificarPrecioAlquilerMusica(5);
		assertEquals(5,Constantes.variables.PRECIO_ALQUILER_MUSICA,0.1);
	}
	
	@Test
	public void testModificarTarifa() {
		Gerente gerente = new Gerente();
		gerente.modificarTarifa(TipoTarifa.MUSICA, 8, 5, 20, 2);
		assertEquals(TipoTarifa.MUSICA,gerente.gt.getTarifaByTipo(TipoTarifa.MUSICA).getTipo());
		assertEquals(8,gerente.gt.getTarifaByTipo(TipoTarifa.MUSICA).getPrecio(),0.1);
		assertEquals(5,gerente.gt.getTarifaByTipo(TipoTarifa.MUSICA).getPrecioExtension(),0.1);
		assertEquals(20,gerente.gt.getTarifaByTipo(TipoTarifa.MUSICA).getTiempo());
		assertEquals(2,gerente.gt.getTarifaByTipo(TipoTarifa.MUSICA).getTiempoExtension());
	}

	@Test
	public void testModificarTiempoAlquiler() {
		Gerente gerente = new Gerente();
		gerente.modificarTiempoAlquiler(15);
		assertEquals(15,Constantes.variables.DURACION_ALQUILER);
	}

	@Test
	public void testModificarNombreVideoclub() {
		Gerente gerente = new Gerente();
		gerente.modificarNombreVideoclub("club patata");
		assertEquals("club patata",Constantes.variables.NOMBRE_VIDEOCLUB);
	}

	@Test
	public void testModificarSancionPorDia() {
		Gerente gerente = new Gerente();
		gerente.modificarSancionPorDia(10);
		assertEquals(10,Constantes.variables.SANCION_POR_DIA,0.1);
	}

	@Test
	public void testReset() {
		Gerente gerente = new Gerente();
		String nombre = "nombre";
		int agno = 1000;
		String director = "director";
		String categoria = "categoria";
		Soporte soporte = Soporte.BLURAY;
		gerente.gp.resetPeliculas();
		gerente.addPelicula(nombre, agno, director, categoria, soporte);
		assertNotNull(gerente.gp.buscarPeliculaByNombre(nombre));
		gerente.reset();
		assertNull(gerente.gp.buscarPeliculaByNombre(nombre));
	}

}
