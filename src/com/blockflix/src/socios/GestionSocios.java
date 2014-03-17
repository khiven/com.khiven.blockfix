package com.blockflix.src.socios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.tarifas.Tarifa;

public class GestionSocios {

	private ArrayList<Socio> listaSocios;
	private ArrayList<Contrato> listaContratos;
	public Tarifa tarifaPeliculas;
	private int lastNsocio;


	public GestionSocios(){
		this.listaSocios=loadSocios();
		this.listaContratos=loadContratos();
		setLastNsocio();
		tarifaPeliculas=Constantes.crearTarifasPeliculas();

	}

	public ArrayList<Socio> loadSocios(){

		Object aux;
		ObjectInputStream ois;
		ArrayList<Socio> socios = new ArrayList<Socio>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_SOCIOS));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Socio){
					socios.add((Socio)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return socios;

	}

	public void saveSocios(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_SOCIOS));

			for(Socio socio : listaSocios){
				oos.writeObject(socio);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setLastNsocio(){
		int aux=0;
		for(Socio socio : listaSocios){
			aux =  aux > socio.getnSocio() ? aux : socio.getnSocio();
		}
		this.lastNsocio = aux;
	}

	public void addSocio(String nombre,String apellidos,String direccion,String telefono,String dni){

		Socio socio = new Socio(nombre,apellidos,direccion,telefono,dni,lastNsocio+1);
		this.lastNsocio++;
		this.listaSocios.add(socio);
	}

	public void printListaSocios(){
		for(Socio socio : listaSocios){
			System.out.println("** SOCIO nº"+socio.getnSocio() +" **");
			System.out.println("Nombre: "+socio.getNombre());
			System.out.println("Apellidos: "+socio.getApellidos());
			System.out.println("Direccion: "+socio.getDireccion());
			System.out.println("Telefono: "+socio.getTelefono());
			System.out.println("DNI: "+socio.getDni());
			System.out.println();

		}
	}

	public void resetSocios(){
		listaSocios.clear();
	}

	public Socio buscarSocio(int nSocio){
		for (Socio socio : listaSocios){
			if (socio.getnSocio() == nSocio) return socio;
		}
		return null;
	}

	
	public Contrato getContratoSocio(Socio socio){
		for(Contrato contrato : listaContratos){
			if (socio==contrato.getSocio()) return contrato;
		}
		return null;
	}
	
	public Contrato getContratoSocio(int nSocio){
		for(Contrato contrato : listaContratos){
			if (contrato.getSocio().getnSocio()==nSocio) return contrato;
		}
		return null;
	}
	
	/************ CONTRATOS **************/

	public ArrayList<Contrato> loadContratos(){

		Object aux;
		ObjectInputStream ois;
		ArrayList<Contrato> contratos = new ArrayList<Contrato>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_CONTRATOS));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Contrato){
					contratos.add((Contrato)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return contratos;

	}

	public void saveContratos(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_CONTRATOS));

			for(Contrato contrato: listaContratos){
				oos.writeObject(contrato);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contratarTarifa(Socio socio,Tarifa tarifa){
		Contrato contrato= new Contrato(socio,tarifa);
		this.listaContratos.add(contrato);
	}
	
	

	public void printListaContratos(){
		for (Contrato contrato:listaContratos){
			
			System.out.println(contrato.toString());

		}
	}
	
	public void resetContratos(){
		listaContratos.clear();
	}




}
