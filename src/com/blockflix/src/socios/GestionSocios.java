package com.blockflix.src.socios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.EstadoSocio;

public class GestionSocios {

	private ArrayList<Socio> listaSocios;


	private int lastNsocio;


	public GestionSocios(){
		this.listaSocios=loadSocios();
		setLastNsocio();



	}

	/***********  GESTION DE SOCIOS **********/
	public void reloadSocios(){
		this.listaSocios=loadSocios();
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

			System.out.println();
			System.out.println(socio.toString());

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

	public Socio buscarSocio(String dni){
		for (Socio socio : listaSocios){
			if (socio.getDni().equals(dni)) return socio;
		}
		return null;
	}


	public void eliminarSocio(int nSocio){
		for (Socio socio : listaSocios){
			if (socio.getnSocio()==nSocio){
				listaSocios.remove(socio);
				this.saveSocios();
				return;
			}
		}
	}

	public void modificarDatosSocio(int nSocio,String nombre,String apellidos,String direccion,String telefono,String dni){
		for (Socio socio : listaSocios)
			if (socio.getnSocio()==nSocio){
				socio.setNombre(nombre);
				socio.setApellidos(apellidos);
				socio.setDireccion(direccion);
				socio.setTelefono(telefono);
				socio.setDni(dni);
				this.saveSocios();
				return;
			}
	}
	
	public boolean isSocioSancionado(int nSocio){
		Socio s = buscarSocio(nSocio);
		return s.getEstado()==EstadoSocio.SANCIONADO;
	}
	
	public void sancionarSocio(int nSocio,double cuantia){
		for (Socio s:listaSocios){
			if (s.getnSocio() == nSocio){
				s.incrSancion(cuantia);
				s.setEstado(EstadoSocio.SANCIONADO);
			}
		}
	}
	
	public void eliminarSancion(int nSocio){
		for (Socio s:listaSocios){
			if (s.getnSocio() == nSocio){
				s.setSancion(0);
				s.setEstado(EstadoSocio.SIN_SANCION);
			}
		}
	}
	
	public ArrayList<Socio> getListaMorosos(){
		ArrayList<Socio> s = new ArrayList<Socio>();
		
		for (Socio socio : listaSocios){
			if (socio.getEstado()==EstadoSocio.SANCIONADO)
				s.add(socio);
		}
		return s;
	}


}
