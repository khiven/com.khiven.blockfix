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
		int id = 4;
		Serie serie =  new Serie(nombre,temporada,volumen,categoria,soporte,id);
		assertNotNull(serie);
		assertEquals(serie.getNombre(),nombre);
		assertEquals(serie.getTemporada(),temporada);
		assertEquals(serie.getVolumen(),volumen);
		assertEquals(serie.getCategoria(),categoria);
		assertEquals(serie.getSoporte(),soporte);
		assertEquals(serie.getTipo(),TipoProducto.SERIE);
	}
	
	@Test
	public void testToString(){
		String nombre = "Shameless US";
		int temporada = 4;
		int volumen = 8;
		String categoria = "comedia";
		Soporte soporte = Soporte.DVD;
		int id = 4;
		Serie serie =  new Serie(nombre,temporada,volumen,categoria,soporte,id);
		assertEquals(serie.toString(),"\nTipo de producto: Serie\nNombre producto: Shameless US\nID: 4\nCategoría: comedia\nSoporte: DVD\nVeces alquilado: 0\nTemporada: 4\nVolumen: 8");
	}

}