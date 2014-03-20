package com.blockflix.test.ejemplar;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.EstadoEjemplar;
import com.blockflix.src.ejemplar.*;

public class TestGestionEjemplares {

	@Test
	public void testGestionEjemplares() {
		GestionEjemplares gestion = new GestionEjemplares();
		assertNotNull(gestion);
	}

	@Test
	public void testLoadEjemplares() {
		GestionEjemplares gestion = new GestionEjemplares();
		ArrayList<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ObjectOutputStream oos;
		int id = 1;
		int idProducto = 1;
		Ejemplar ejemplar = new Ejemplar(id,idProducto);
		ejemplares.add(ejemplar);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_EJEMPLARES));

			for(Ejemplar ejemplar1 : ejemplares){
				oos.writeObject(ejemplar1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion.loadEjemplares();
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).get(0).getId(),id);
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).get(0).getProducto(),idProducto);
	}

	@Test
	public void testSaveEjemplares() {
		GestionEjemplares gestion = new GestionEjemplares();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		int idProducto = 1;
		gestion.resetEjemplares();
		gestion.setLastIdEjemplar();
		gestion.addEjemplar(idProducto);
		int id = gestion.buscarEjemplaresDisponiblesProducto(idProducto).get(0).getId();
		Ejemplar ejemplar = new Ejemplar(id,idProducto);
		gestion.saveEjemplares();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_EJEMPLARES));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Ejemplar){
					ejemplares.add((Ejemplar)aux);
					ejemplar = ejemplares.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).get(0).getId(),ejemplar.getId());
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).get(0).getProducto(),ejemplar.getProducto());
	}

	@Test
	public void testResetEjemplares() {
		GestionEjemplares gestion = new GestionEjemplares();
		int idProducto = 1;
		gestion.addEjemplar(idProducto);
		assertNotEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
		gestion.resetEjemplares();
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
	}

	@Test
	public void testAddEjemplar() {
		GestionEjemplares gestion = new GestionEjemplares();
		int idProducto = 1;
		gestion.resetEjemplares();
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
		gestion.addEjemplar(idProducto);
		assertNotEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
	}

	@Test
	public void testEliminarEjemplar() {
		GestionEjemplares gestion = new GestionEjemplares();
		int idProducto = 1;
		gestion.resetEjemplares();
		gestion.addEjemplar(idProducto);
		int id = gestion.buscarEjemplaresProducto(idProducto).get(0).getId();
		assertNotEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
		gestion.eliminarEjemplar(id);
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
	}

	@Test
	public void testBuscarEjemplaresProducto() {
		GestionEjemplares gestion = new GestionEjemplares();
		int idProducto = 1;
		gestion.resetEjemplares();
		gestion.addEjemplar(idProducto);
		assertNotEquals(gestion.buscarEjemplaresProducto(idProducto).size(),0);
		assertEquals(gestion.buscarEjemplaresProducto(idProducto).get(0).getProducto(),idProducto);
	}

	@Test
	public void testBuscarEjemplaresDisponiblesProducto() {
		GestionEjemplares gestion = new GestionEjemplares();
		int idProducto = 1;
		gestion.resetEjemplares();
		gestion.addEjemplar(idProducto);
		assertNotEquals(gestion.buscarEjemplaresDisponiblesProducto(idProducto).size(),0);
		assertEquals(gestion.buscarEjemplaresDisponiblesProducto(idProducto).get(0).getProducto(),idProducto);
		assertEquals(gestion.buscarEjemplaresDisponiblesProducto(idProducto).get(0).getEstado(),EstadoEjemplar.DISPONIBLE);
	}

}
