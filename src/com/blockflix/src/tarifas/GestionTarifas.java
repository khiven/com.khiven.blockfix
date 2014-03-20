package com.blockflix.src.tarifas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.TipoTarifa;

public class GestionTarifas {

	
	private ArrayList<Tarifa> listaTarifas;
	
	
	
	public GestionTarifas(){
		
		this.listaTarifas = loadTarifas();
		if (this.listaTarifas.isEmpty())  crearTarifas();
	}
	
	
	
/********* GESTION DE TARIFAS ***********/
	
	public ArrayList<Tarifa> loadTarifas(){

		Object aux;
		ObjectInputStream ois;
		ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_TARIFAS));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Tarifa){
					tarifas.add((Tarifa)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return tarifas;

	}
	
	
	public void saveTarifas(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_TARIFAS));

			for(Tarifa tarifa: listaTarifas){
				oos.writeObject(tarifa);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public void crearTarifas(){
		//System.out.println("NO HE CARGADO LAS TARIFAS DEL FICHERO");
		this.listaTarifas.add(Constantes.crearTarifaPeliculas());
		this.listaTarifas.add(Constantes.crearTarifaSeries());
		this.listaTarifas.add(Constantes.crearTarifaMusica());
		this.listaTarifas.add(Constantes.crearTarifaPeliculasSeries());
		this.listaTarifas.add(Constantes.crearTarifaPeliculasMusica());
		this.listaTarifas.add(Constantes.crearTarifaSeriesMusica());
		this.listaTarifas.add(Constantes.crearTarifaPremium());
	}

	public Tarifa getTarifaByTipo(TipoTarifa tipoTarifa){
		for (Tarifa tarifa : listaTarifas){
			if (tarifa.getTipo()==tipoTarifa) return tarifa;
		}
		return null;
	}
	
	public void printInfoTarifa(TipoTarifa tipoTarifa){
		Tarifa tarifa = getTarifaByTipo(tipoTarifa);
		System.out.println(tarifa.toString());
	}
	
	public void printListaTarifas(){
		System.out.println();
		for(Tarifa tarifa : listaTarifas){
			
			printInfoTarifa(tarifa.getTipo());
		}
	}
	
	public void modificarTarifa(TipoTarifa tarifa, float precio, float precioExtension, int tiempo, int tiempoExtension){
		for (Tarifa t : listaTarifas){
			if (t.getTipo()==tarifa){
				t.setPrecio(precio);
				t.setPrecioExtension(precioExtension);
				t.setTiempo(tiempo);
				t.setTiempoExtension(tiempoExtension);
				return;
			}
			
		}
	}
}
