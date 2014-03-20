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
		int id = 3;
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte,id);
		assertNotNull(pelicula);
		assertEquals(pelicula.getNombre(),nombre);
		assertEquals(pelicula.getAgno(),agno);
		assertEquals(pelicula.getDirector(),director);
		assertEquals(pelicula.getCategoria(),categoria);
		assertEquals(pelicula.getSoporte(),soporte);
		assertEquals(pelicula.getTipo(),TipoProducto.PELICULA);
	}
	
	@Test
	public void testToString(){
		String nombre = "Gravity";
		int agno = 2013;
		String director = "Cuaron";
		String categoria = "Ciencia Ficcion";
		Soporte soporte = Soporte.BLURAY;
		int id = 3;
		Pelicula pelicula = new Pelicula(nombre,agno,director,categoria,soporte,id);
		assertEquals(pelicula.toString(),"\nTipo de producto: Pelicula\nNombre producto: Gravity\nID: 3\nCategoría: Ciencia Ficcion\nSoporte: BLURAY\nVeces alquilado: 0\nDirector: Cuaron\nAño: 2013");
	}

}
