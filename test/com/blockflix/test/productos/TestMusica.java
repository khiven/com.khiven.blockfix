package com.blockflix.test.productos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.productos.Musica;

public class TestMusica {

	@Test
	public void testMusica() {
		String nombre = "Mi menor";
		int agno = 1789;
		String interprete = "Elton John";
		String categoria = "Heavy";
		Soporte soporte = com.blockflix.src.constantes.Constantes.Soporte.VINILO;
		Musica cancion = new Musica(nombre,agno,interprete,categoria,soporte);
		assertNotNull(cancion);
		assertEquals(cancion.getAgno(),agno);
		assertEquals(cancion.getNombre(),nombre);
		assertEquals(cancion.getCategoria(),categoria);
		assertEquals(cancion.getInterprete(),interprete);
		assertEquals(cancion.getSoporte(),soporte);
		assertEquals(cancion.getTipo(),TipoProducto.MUSICA);
	}

}