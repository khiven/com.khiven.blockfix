package com.blockflix.test.productos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.productos.Serie;

public class TestSerie {

	@Test
	public void testSerie() {
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		Serie serie =  new Serie(nombre,temporada,volumen,categoria,soporte);
		assertNotNull(serie);
		assertEquals(serie.getNombre(),nombre);
		assertEquals(serie.getTemporada(),temporada);
		assertEquals(serie.getVolumen(),volumen);
		assertEquals(serie.getCategoria(),categoria);
		assertEquals(serie.getSoporte(),soporte);
		assertEquals(serie.getTipo(),TipoProducto.SERIE);
	}

}