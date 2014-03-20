package com.blockflix.test.tarifas;

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
import com.blockflix.src.tarifas.*;

public class TestGestionTarifas {

	@Test
	public void testGestionTarifas() {
		GestionTarifas gestion =  new GestionTarifas();
		assertNotNull(gestion);
	}

	@Test
	public void testLoadTarifas() {
		GestionTarifas gestion = new GestionTarifas();
		ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
		TipoTarifa tipo = TipoTarifa.MUSICA;
		float precio = 5;
		int tiempo = 3;
		int tiempoExtension = 1;
		float precioExtension = 1;
		Tarifa tarifa = new Tarifa(tipo,precio,tiempo,tiempoExtension,precioExtension);
		tarifas.add(tarifa);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_TARIFAS));

			for(Tarifa tarifa1 : tarifas){
				oos.writeObject(tarifa1);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gestion.loadTarifas();
		assertEquals(gestion.getTarifaByTipo(tipo).getPrecio(),tarifa.getPrecio(),0.1);
		assertEquals(gestion.getTarifaByTipo(tipo).getPrecioExtension(),tarifa.getPrecioExtension(),0.1);
		assertEquals(gestion.getTarifaByTipo(tipo).getTiempo(),tarifa.getTiempo());
		assertEquals(gestion.getTarifaByTipo(tipo).getTiempoExtension(),tarifa.getTiempoExtension());
		assertEquals(gestion.getTarifaByTipo(tipo).getTipo(),tarifa.getTipo());
	}

	@Test
	public void testSaveTarifas() {
		GestionTarifas gestion = new GestionTarifas();
		ObjectInputStream ois;
		Object aux;
		ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
		TipoTarifa tipo = TipoTarifa.MUSICA;
		float precio = 5;
		int tiempo = 3;
		int tiempoExtension = 1;
		float precioExtension = 1;
		Tarifa tarifa = new Tarifa(tipo,precio,tiempo,tiempoExtension,precioExtension);
		try{
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_TARIFAS));
			aux= ois.readObject();
			while (aux != null)
			{
				if (aux instanceof Tarifa){
					tarifas.add((Tarifa)aux);
					tarifa = tarifas.get(0);
				}
				aux = ois.readObject();
			}
			ois.close();
			} catch(IOException | ClassNotFoundException e ) {}
		gestion.loadTarifas();
		gestion.saveTarifas();
		assertEquals(gestion.getTarifaByTipo(tipo).toString(),tarifa.toString());
	}

}
