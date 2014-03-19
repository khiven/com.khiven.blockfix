package com.blockflix.test.productos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.productos.Pelicula;

public class TestPelicula {

	@Test
	public void testPelicula() {
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte);
		assertNotNull(pelicula);
		assertEquals(pelicula.getNombre(),nombre);
		assertEquals(pelicula.getAgno(),agno);
		assertEquals(pelicula.getDirector(),director);
		assertEquals(pelicula.getCategoria(),categoria);
		assertEquals(pelicula.getSoporte(),soporte);
		assertEquals(pelicula.getTipo(),TipoProducto.PELICULA);
	}

}
