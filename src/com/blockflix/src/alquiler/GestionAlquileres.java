package com.blockflix.src.alquiler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;

public class GestionAlquileres {

	private ArrayList<Alquiler> listaAlquileres;
	
	public GestionAlquileres(){
		this.listaAlquileres = loadAlquileres();
	}
	
	
	public ArrayList<Alquiler> loadAlquileres(){
		
		Object aux;
		ObjectInputStream ois;
		ArrayList<Alquiler> alquileres= new ArrayList<Alquiler>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_ALQUILERES));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Alquiler){
					alquileres.add((Alquiler)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return alquileres;
		
	}
	
	public void saveAlquileres(){
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_ALQUILERES));

			for(Alquiler alquiler: listaAlquileres){
				oos.writeObject(alquiler);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAlquiler(int nSocio, ArrayList<Integer> ejemplares){
		this.listaAlquileres.add(new Alquiler(nSocio,ejemplares));
	}
	
	public void removeAlquiler(int nSocio){
		for (Alquiler a : listaAlquileres){
			if (a.getnSocio()==nSocio){
				this.listaAlquileres.remove(a);
				this.saveAlquileres();
				return;
			}
		}
	}
	
	public void resetAlquileres(){
		this.listaAlquileres.clear();
	}
	
	public void printAlquileres(){
		for (Alquiler a : listaAlquileres){
			System.out.println();
			System.out.println(a.toString());
		}
	}
}
