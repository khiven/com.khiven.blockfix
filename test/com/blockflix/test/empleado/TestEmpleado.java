package com.blockflix.test.empleado;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes.EstadoEjemplar;
import com.blockflix.src.empleado.Empleado;

public class TestEmpleado {

	@Test
	public void testEmpleado() {
		Empleado empleado = new Empleado();
		assertNotNull(empleado);
	}

	@Test
	public void testMarcarEjemplar() {
		Empleado empleado = new Empleado();
		int idProducto = 1;
		empleado.ge.addEjemplar(idProducto);
		int idEjemplar = empleado.ge.buscarEjemplaresProducto(idProducto).get(0).getId();
		empleado.ge.getEjemplar(idEjemplar).setEstado(EstadoEjemplar.DISPONIBLE);
		assertEquals(EstadoEjemplar.DISPONIBLE,empleado.ge.getEjemplar(idEjemplar).getEstado());
		empleado.marcarEjemplar(idEjemplar, EstadoEjemplar.NO_DISPONIBLE);
		assertEquals(EstadoEjemplar.NO_DISPONIBLE,empleado.ge.getEjemplar(idEjemplar).getEstado());
	}
	
	@Test
	public void testReset() {
		Empleado empleado = new Empleado();
		int idProducto = 1;
		empleado.ge.addEjemplar(idProducto);
		assertNotEquals(0,empleado.ge.buscarEjemplaresProducto(idProducto).size());
		empleado.reset();
		assertEquals(0,empleado.ge.buscarEjemplaresProducto(idProducto).size());
	}

}
