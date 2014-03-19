package com.blockflix.test.socio;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.socios.*;

public class TestGestionSocios {

	@Test
	public void testGestionSocios() {
		GestionSocios gestion = new GestionSocios();
		assertNotNull(gestion);
	}

	@Test
	public void testLoadSocios() {
		GestionSocios gestion = new GestionSocios();
		GestionSocios gestion2 = new GestionSocios();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Socio> socios = new ArrayList<Socio>();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		gestion.saveSocios();
		gestion2.loadSocios();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_SOCIOS));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Socio){
					socios.add((Socio)aux);
				}
				aux = ois.readObject();
			}
			ois.close();
			
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion2.buscarSocio(dni),socios.get(1));
	}

	@Test
	public void testSaveSocios() {
		GestionSocios gestion = new GestionSocios();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Socio> socios = new ArrayList<Socio>();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		gestion.saveSocios();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_SOCIOS));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Socio){
					socios.add((Socio)aux);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.buscarSocio(dni),socios.get(1));
	}

	@Test
	public void testAddSocio() {
		GestionSocios gestion = new GestionSocios();
		gestion.resetSocios();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNotNull(gestion.buscarSocio(dni));
	}

	@Test
	public void testResetSocios() {
		GestionSocios gestion = new GestionSocios();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNotNull(gestion.buscarSocio(dni));
		gestion.resetSocios();
		assertNull(gestion.buscarSocio(dni));
	}

	@Test
	public void testBuscarSocioInt() {
		GestionSocios gestion = new GestionSocios();
		gestion.resetSocios();
		gestion.setLastNsocio();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		int nSocio1 = 44;
		int nSocio2 = 1;
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNull(gestion.buscarSocio(nSocio1));
		assertNotNull(gestion.buscarSocio(nSocio2));
	}

	@Test
	public void testBuscarSocioString() {
		GestionSocios gestion = new GestionSocios();
		gestion.resetSocios();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		String dni2 = "33X";
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNull(gestion.buscarSocio(dni2));
		assertNotNull(gestion.buscarSocio(dni));
	}

	/*@Test
	public void testEliminarSocioExistente() {
		GestionSocios gestion = new GestionSocios();
		gestion.resetSocios();
		gestion.setLastNsocio();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		int nSocio = 1;
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNotNull(gestion.buscarSocio(dni));
		gestion.eliminarSocio(nSocio);
		assertNull(gestion.buscarSocio(dni));
	}*/
	
	@Test
	public void testEliminarSocioNoExistente() {
		GestionSocios gestion = new GestionSocios();
		gestion.resetSocios();
		gestion.setLastNsocio();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		int nSocio = 40;
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNotNull(gestion.buscarSocio(dni));
		gestion.eliminarSocio(nSocio);
		assertNotNull(gestion.buscarSocio(dni));
	}

	@Test
	public void testModificarDatosSocio() {
		GestionSocios gestion = new GestionSocios();
		gestion.resetSocios();
		gestion.setLastNsocio();
		String nombre = "Pepe";
		String apellido = "Perez";
		String direccion = "Sevilla";
		String telefono = "15";
		String dni = "20C";
		String nombre2 = "Maria";
		String apellido2 = "Gonzalez";
		String direccion2 = "Valencia";
		String telefono2 = "33";
		String dni2 = "55X";
		int nSocio = 1;
		gestion.addSocio(nombre,apellido,direccion,telefono,dni);
		assertNotNull(gestion.buscarSocio(dni));
		assertNull(gestion.buscarSocio(dni2));
		gestion.modificarDatosSocio(nSocio,nombre2,apellido2,direccion2,telefono2,dni2);
		assertNull(gestion.buscarSocio(dni));
		assertNotNull(gestion.buscarSocio(dni2));
		assertEquals(gestion.buscarSocio(dni2).getNombre(),nombre2);
		assertEquals(gestion.buscarSocio(dni2).getApellidos(),apellido2);
		assertEquals(gestion.buscarSocio(dni2).getDireccion(),direccion2);
		assertEquals(gestion.buscarSocio(dni2).getTelefono(),telefono2);
		assertEquals(gestion.buscarSocio(dni2).getDni(),dni2);
		assertEquals(gestion.buscarSocio(dni2).getnSocio(),nSocio);
		gestion.modificarDatosSocio(nSocio,nombre,apellido,direccion,telefono,dni);
	}

}
