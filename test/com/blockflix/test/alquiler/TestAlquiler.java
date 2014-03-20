package com.blockflix.test.alquiler;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import com.blockflix.src.alquiler.Alquiler;

public class TestAlquiler {

	@Test
	public void testAlquiler() {
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		Alquiler alquiler = new Alquiler(nSocio,ejemplares);
		assertNotNull(alquiler);
		assertEquals(ejemplares,alquiler.getEjemplares());
		assertEquals(nSocio,alquiler.getnSocio());
	}

	@Test
	public void testToString() {
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		Alquiler alquiler = new Alquiler(nSocio,ejemplares);
		assertEquals("\nAlquiler del socio nº1\nDe los ejemplares con id: \nFecha de alquiler: "+ alquiler.getFechaInicio().get(Calendar.DATE) + "/"
				+alquiler.getFechaInicio().get(Calendar.MONTH)+"/"
				+alquiler.getFechaInicio().get(Calendar.YEAR),alquiler.toString());
	}

}
