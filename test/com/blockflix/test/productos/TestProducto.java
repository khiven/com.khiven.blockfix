package com.blockflix.test.productos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.EstadoProducto;
import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.productos.*;

public class TestProducto {

	@Test
	public void testProducto() {
		String nombre = "King Kong";
		String categoria = "Accion";
		TipoProducto tipo = TipoProducto.PELICULA;
		Soporte soporte = Soporte.BLURAY;
		Producto prueba = new Producto(nombre,categoria,tipo,soporte);
		assertNotNull(prueba);
		assertEquals(prueba.getNombre(),nombre);
		assertEquals(prueba.getCategoria(),categoria);
		assertEquals(prueba.getTipo(),tipo);
		assertEquals(prueba.getSoporte(),soporte);
		assertEquals(prueba.getEstado(),EstadoProducto.DISPONIBLE);
	}

	@Test
	public void testIncrementarAlquileres() {
		int auxVeces;
		String nombre = "King Kong";
		String categoria = "Accion";
		TipoProducto tipo = TipoProducto.PELICULA;
		Soporte soporte = Soporte.BLURAY;
		Producto prueba = new Producto(nombre,categoria,tipo,soporte);
		auxVeces = prueba.getVecesAlquilado();
		prueba.incrementarAlquileres();
		assertEquals(prueba.getVecesAlquilado(),auxVeces+1);
	}

}
