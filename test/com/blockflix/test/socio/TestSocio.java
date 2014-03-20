package com.blockflix.test.socio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.blockflix.src.constantes.Constantes.EstadoSocio;
import com.blockflix.src.socios.*;

/**
 * @author Antonio Amate, Alvaro de No
 *	Clase de prueba de Socio
 */
public class TestSocio {
	String nombre = "Pepe";
	String apellido = "Perez";
	String direccion = "Sevilla";
	String telefono = "15";
	String dni = "20C";
	int nSocio = 40;
	Socio pepe;
	@Before public void creaPepe(){
		pepe = new Socio(nombre,apellido,direccion,telefono,dni,nSocio);
	}
	
	/** Prueba del constructor de Socio
	 * Verifica que el socio se crea con los datos dados y en el estado SIN_SANCION
	 */
	@Test
	public void testSocio() {
		assertEquals(pepe.getNombre(),nombre);
		assertEquals(pepe.getApellidos(),apellido);
		assertEquals(pepe.getDireccion(),direccion);
		assertEquals(pepe.getTelefono(),telefono);
		assertEquals(pepe.getDni(),dni);
		assertEquals(pepe.getnSocio(),nSocio);
		assertEquals(pepe.getEstado(),EstadoSocio.SIN_SANCION);
	}

	/** Prueba del metodo toString
	 * 	Verifica que la salida del metodo es una cadena con toda la informacion deseada del socio.
	 */
	@Test
	public void testToString() {
		assertEquals(pepe.toString(),"** SOCIO nº40 **\nNombre: Pepe\nApellidos: Perez\nDireccion: Sevilla\nTelefono: 15\nDNI: 20C\nSancionado: 0.0euros");
	}

	/** Prueba del metodo equals
	 *  Verifica que el metodo devuelve true cuando se invoca con un argumento igual al socio actual
	 *  que devuelve false cuando se invoca con null o con un objeto que no sea un socio
	 *  y que devuelve true cuando se invoca con un socio con el mismo nombre, apellido y dni que el actual.
	 */
	@Test
	public void testEquals() {
		String dni2 = "44X";
		int nSocio2 = 41;
		Socio pepeclon = new Socio(nombre,apellido,direccion,telefono,dni,nSocio);
		Socio juan = null;
		String maria = "Maria";
		Socio pepe2 = new Socio(nombre,apellido,direccion,telefono,dni2,nSocio2);
		pepe.equals(juan);
		assertEquals(pepe.equals(juan),false);
		assertEquals(pepe.equals(pepeclon),true);
		assertEquals(pepe.equals(maria),false);
		assertEquals(pepe.equals(pepe2),(pepe.getNombre().equals(pepe2.getNombre())) && pepe.getApellidos().equals(pepe2.getApellidos()) && pepe.getDni().equals(pepe2.getDni()));
	}

}
