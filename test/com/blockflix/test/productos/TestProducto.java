package com.blockflix.test.productos;

import static org.junit.Assert.*;

import org.junit.Test;

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
		int id = 1;
		Producto prueba = new Producto(nombre,categoria,tipo,soporte,id);
		assertNotNull(prueba);
		assertEquals(prueba.getNombre(),nombre);
		assertEquals(prueba.getCategoria(),categoria);
		assertEquals(prueba.getTipo(),tipo);
		assertEquals(prueba.getSoporte(),soporte);
		assertEquals(prueba.getId(),id);
	}

	@Test
	public void testIncrementarAlquileres() {
		int auxVeces;
		String nombre = "King Kong";
		String categoria = "Accion";
		TipoProducto tipo = TipoProducto.PELICULA;
		Soporte soporte = Soporte.BLURAY;
		int id = 1;
		Producto prueba = new Producto(nombre,categoria,tipo,soporte,id);
		auxVeces = prueba.getVecesAlquilado();
		prueba.incrementarAlquileres();
		assertEquals(prueba.getVecesAlquilado(),auxVeces+1);
	}
	
	@Test
	public void testToString(){
	  
		String nombre = "King Kong";
		String categoria = "Accion";
		TipoProducto tipo = TipoProducto.PELICULA;
		Soporte soporte = Soporte.BLURAY;
		int id = 1;
		Producto prueba = new Producto(nombre,categoria,tipo,soporte,id);
		assertEquals(prueba.toString(),"\nTipo de producto: Pelicula\nNombre producto: King Kong\nID: 1\nCategoría: Accion\nSoporte: BLURAY\nVeces alquilado: 0");			
	}

}
