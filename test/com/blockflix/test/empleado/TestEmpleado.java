package com.blockflix.test.empleado;

import static org.junit.Assert.*;

import org.junit.Test;

import com.blockflix.src.empleado.Empleado;

public class TestEmpleado {

	@Test
	public void testEmpleado() {
		Empleado empleado = new Empleado();
		assertNotNull(empleado);
	}

	@Test
	public void testMarcarEjemplar() {
		fail("Not yet implemented");
	}

	@Test
	public void testReset() {
		fail("Not yet implemented");
	}

}
