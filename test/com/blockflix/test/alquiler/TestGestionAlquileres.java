package com.blockflix.test.alquiler;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Test;

import com.blockflix.src.alquiler.*;
import com.blockflix.src.constantes.Constantes;

public class TestGestionAlquileres {

	@Test
	public void testGestionAlquileres() {
		GestionAlquileres gestion = new GestionAlquileres();
		assertNotNull(gestion);
	}

	@Test
	public void testLoadAlquileres() {
		GestionAlquileres gestion = new GestionAlquileres();
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();
		ObjectOutputStream oos;
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		Alquiler alquiler = new Alquiler(nSocio,ejemplares);
		alquileres.add(alquiler);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_ALQUILERES));

			for(Alquiler alquiler1 : alquileres){
				oos.writeObject(alquiler1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion.loadAlquileres();
		assertNotNull(gestion.getAlquiler(nSocio));
		assertEquals(alquiler.getEjemplares(),gestion.getAlquiler(nSocio).getEjemplares());
		assertEquals(alquiler.getnSocio(),gestion.getAlquiler(nSocio).getnSocio());
	}

	@Test
	public void testSaveAlquileres() {
		GestionAlquileres gestion = new GestionAlquileres();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		gestion.resetAlquileres();
		gestion.addAlquiler(nSocio, ejemplares);
		Alquiler alquiler = new Alquiler(nSocio, ejemplares);
		gestion.saveAlquileres();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_ALQUILERES));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Alquiler){
					alquileres.add((Alquiler)aux);
					alquiler = alquileres.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(alquiler.toString(),gestion.getAlquiler(nSocio).toString());
	}

	@Test
	public void testAddAlquiler() {
		GestionAlquileres gestion = new GestionAlquileres();
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		gestion.resetAlquileres();
		assertNull(gestion.getAlquiler(nSocio));
		gestion.addAlquiler(nSocio, ejemplares);
		assertNotNull(gestion.getAlquiler(nSocio));
		assertEquals(ejemplares,gestion.getAlquiler(nSocio).getEjemplares());
		assertEquals(nSocio,gestion.getAlquiler(nSocio).getnSocio());
	}

	@Test
	public void testRemoveAlquiler() {
		GestionAlquileres gestion = new GestionAlquileres();
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		gestion.resetAlquileres();
		gestion.addAlquiler(nSocio, ejemplares);
		assertNotNull(gestion.getAlquiler(nSocio));
		gestion.removeAlquiler(nSocio);
		assertNull(gestion.getAlquiler(nSocio));
		gestion.addAlquiler(nSocio, ejemplares);
		gestion.saveAlquileres();
	}

	@Test
	public void testTieneAlquileres() {
		GestionAlquileres gestion = new GestionAlquileres();
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		gestion.resetAlquileres();
		assertEquals(false,gestion.tieneAlquileres(nSocio));
		gestion.addAlquiler(nSocio, ejemplares);
		assertEquals(true,gestion.tieneAlquileres(nSocio));
	}

	@Test
	public void testResetAlquileres() {
		GestionAlquileres gestion = new GestionAlquileres();
		int nSocio = 1;
		ArrayList<Integer> ejemplares = new ArrayList<Integer>();
		gestion.resetAlquileres();
		gestion.addAlquiler(nSocio, ejemplares);
		assertNotNull(gestion.getAlquiler(nSocio));
		gestion.resetAlquileres();
		assertNull(gestion.getAlquiler(nSocio));
	}

}
