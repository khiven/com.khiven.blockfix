package com.blockflix.test.tarifas;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.tarifas.Tarifa;

public class TestTarifa {

	@Test
	public void testTarifa() {
		TipoTarifa tipo = TipoTarifa.MUSICA;
		float precio = 15;
		int tiempo = 30;
		int tiempoExtension = 1;
		float precioExtension = 2;
		Tarifa tarifa = new Tarifa(tipo,precio,tiempo,tiempoExtension,precioExtension);
		assertNotNull(tarifa);
		assertEquals(tarifa.getPrecio(),precio,0.1);
		assertEquals(tarifa.getPrecioExtension(),precioExtension,0.1);
		assertEquals(tarifa.getTiempo(),tiempo);
		assertEquals(tarifa.getTiempoExtension(),tiempoExtension);
		assertEquals(tarifa.getTipo(),tipo);
	}

	@Test
	public void testToString() {
		TipoTarifa tipo = TipoTarifa.MUSICA;
		float precio = 15;
		int tiempo = 30;
		int tiempoExtension = 1;
		float precioExtension = 2;
		Tarifa tarifa = new Tarifa(tipo,precio,tiempo,tiempoExtension,precioExtension);
		assertEquals(tarifa.toString(),"Tipo de tarifa: Tarifa de Música\nDuración de la tarifa: 30dias\nPrecio de la tarifa: 15.0€\nDuracion de la extension temporal: 1días\nPrecio de la extensión temporal: 1€\n");
	}

}
