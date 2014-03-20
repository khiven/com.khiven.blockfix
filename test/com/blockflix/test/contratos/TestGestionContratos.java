package com.blockflix.test.contratos;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Test;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.contratos.Contrato;
import com.blockflix.src.contratos.GestionContratos;

public class TestGestionContratos {

	@Test
	public void testGestionContratos() {
		GestionContratos gestion = new GestionContratos();
		assertNotNull(gestion);
	}

	@Test
	public void testLoadContratos() {
		GestionContratos gestion = new GestionContratos();
		ArrayList<Contrato> contratos = new ArrayList<Contrato>();
		ObjectOutputStream oos;
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		Contrato contrato = new Contrato(nSocio,tipoTarifa,extTiempo);
		contratos.add(contrato);
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_CONTRATOS));

			for(Contrato contrato1 : contratos){
				oos.writeObject(contrato1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion.loadContratos();
		assertEquals(contrato.getExtTiempo(),gestion.getContratoSocio(nSocio).getExtTiempo());
		assertEquals(contrato.getnSocio(),gestion.getContratoSocio(nSocio).getnSocio());
		assertEquals(contrato.getTarifa(),gestion.getContratoSocio(nSocio).getTarifa());
	}

	@Test
	public void testSaveContratos() {
		GestionContratos gestion = new GestionContratos();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Contrato> Contratos = new ArrayList<Contrato>();
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		gestion.resetContratos();
		gestion.contratarTarifa(nSocio, tipoTarifa, extTiempo);
		Contrato Contrato = new Contrato(nSocio, tipoTarifa, extTiempo);
		gestion.saveContratos();
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_CONTRATOS));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Contrato){
					Contratos.add((Contrato)aux);
					Contrato = Contratos.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		assertEquals(gestion.getContratoSocio(nSocio).toString(),Contrato.toString());
	}

	@Test
	public void testContratarTarifa() {
		GestionContratos gestion = new GestionContratos();
		gestion.resetContratos();
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		assertNull(gestion.getContratoSocio(nSocio));
		gestion.contratarTarifa(nSocio, tipoTarifa, extTiempo);
		assertNotNull(gestion.getContratoSocio(nSocio));
		assertEquals(extTiempo,gestion.getContratoSocio(nSocio).getExtTiempo());
		assertEquals(nSocio,gestion.getContratoSocio(nSocio).getnSocio());
		assertEquals(tipoTarifa,gestion.getContratoSocio(nSocio).getTarifa());
	}
	
	@Test
	public void testEliminarContrato() {
		GestionContratos gestion = new GestionContratos();
		gestion.resetContratos();
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		gestion.contratarTarifa(nSocio, tipoTarifa, extTiempo);
		assertNotNull(gestion.getContratoSocio(nSocio));
		gestion.eliminarContrato(nSocio);
		assertNull(gestion.getContratoSocio(nSocio));
	}

	@Test
	public void testResetContratos() {
		GestionContratos gestion = new GestionContratos();
		gestion.resetContratos();
		int nSocio = 1;
		TipoTarifa tipoTarifa = TipoTarifa.MUSICA;
		boolean extTiempo = true;
		gestion.contratarTarifa(nSocio, tipoTarifa, extTiempo);
		assertNotNull(gestion.getContratoSocio(nSocio));
		gestion.resetContratos();
		assertNull(gestion.getContratoSocio(nSocio));
	}
}
