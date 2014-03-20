package com.blockflix.src.contratos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.TipoTarifa;

public class GestionContratos {

	
	public ArrayList<Contrato> listaContratos;
	
	public GestionContratos(){
		this.listaContratos=loadContratos();
	}
	
	/************ GESTION DE CONTRATOS **************/

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

	public void contratarTarifa(int nSocio,TipoTarifa tarifa,boolean ext){
		Contrato contrato= new Contrato(nSocio,tarifa,ext);
		this.listaContratos.add(contrato);
	}
	
	

	public void printListaContratos(){
		for (Contrato contrato:listaContratos){
			
			System.out.println(contrato.toString());
		

		}
	}
	
	
	public Contrato getContratoSocio(int nSocio){
		for(Contrato contrato : listaContratos){
			if (nSocio==contrato.getnSocio()) return contrato;
		}
		return null;
	}
	
	public void eliminarContrato(int nSocio){
		for (Contrato contrato: listaContratos){
			if (nSocio==contrato.getnSocio()){
				listaContratos.remove(contrato);
				return;
				}
		}
	}
	
	
	public void resetContratos(){
		listaContratos.clear();
	}

	
	
	
	
	
	
	
}
