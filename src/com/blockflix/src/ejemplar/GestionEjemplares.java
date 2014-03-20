package com.blockflix.src.ejemplar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.EstadoEjemplar;
import com.blockflix.src.productos.Producto;

public class GestionEjemplares {

	private ArrayList<Ejemplar> listaEjemplares;
	private int lastIdEjemplar;

	public GestionEjemplares(){
		this.listaEjemplares = loadEjemplares();
		setLastIdEjemplar();
	}

	public ArrayList<Ejemplar> loadEjemplares(){
		Object aux;
		ObjectInputStream ois;
		ArrayList<Ejemplar> ejemplares= new ArrayList<Ejemplar>();


		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_EJEMPLARES));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			while (aux != null)
			{
				if (aux instanceof Ejemplar){
					ejemplares.add((Ejemplar)aux);

				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block


			//e.printStackTrace();
		}

		return ejemplares;

	}

	public void saveEjemplares(){


		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_EJEMPLARES));

			for(Ejemplar ejemplar: listaEjemplares){
				oos.writeObject(ejemplar);
			}
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void reloadEjemplares(){
		this.listaEjemplares=loadEjemplares();
	}
	public void resetEjemplares(){
		listaEjemplares.clear();
	}

	public void addEjemplar(int idProducto){
		listaEjemplares.add(new Ejemplar(++lastIdEjemplar,idProducto));
		this.saveEjemplares();
	}

	public void eliminarEjemplar(int id){
		for (Ejemplar ej : listaEjemplares){
			if (ej.getId()==id){
				listaEjemplares.remove(ej);
				this.saveEjemplares();
				return;
			}
		}
	}

	public void eliminarEjemplaresProducto(int id){
		for (Ejemplar ej : listaEjemplares){
			if (ej.getProducto()==id){
				listaEjemplares.remove(ej);
			}
		}
	}

	public void setLastIdEjemplar(){
		int aux=0;
		for(Ejemplar ejemplar: listaEjemplares){
			aux =  aux > ejemplar.getId() ? aux : ejemplar.getId();
		}
		this.lastIdEjemplar = aux;
	}

	public void printEjemplares(){
		for (Ejemplar e : listaEjemplares){
			System.out.println();
			System.out.println(e.toString());
		}
	}

	public ArrayList<Ejemplar> buscarEjemplaresProducto(int id){
		ArrayList<Ejemplar> resultados = new ArrayList<Ejemplar>();
		for (Ejemplar e : listaEjemplares){
			if (e.getProducto() == id) resultados.add(e);
		}
		return resultados;
	}

	public ArrayList<Ejemplar> buscarEjemplaresDisponiblesProducto(int id){
		
		ArrayList<Ejemplar> resultados = new ArrayList<Ejemplar>(); 
		
		resultados=buscarEjemplaresProducto(id);
		ArrayList<Ejemplar> aux = new ArrayList<Ejemplar>(resultados); 
		
			for (Ejemplar e : aux){
				if (e.getEstado()!= EstadoEjemplar.DISPONIBLE) resultados.remove(e);
			}
		
		return resultados;
	}

	public Ejemplar getEjemplar(int idEjemplar){
		for (Ejemplar e: listaEjemplares){
			if (e.getId()==idEjemplar){
				return e;
			}	
		}
		return null;
	}

	public void alquilarEjemplar(int idEjemplar){
		for (Ejemplar e : listaEjemplares){
			if (e.getId()==idEjemplar){
				e.setEstado(EstadoEjemplar.ALQUILADO);
			}
		}
		this.saveEjemplares();
	}

	public void devolverEjemplar(int idEjemplar){
		for (Ejemplar e : listaEjemplares){
			if (e.getId()==idEjemplar){
				e.setEstado(EstadoEjemplar.DISPONIBLE);
			}
		}
		this.saveEjemplares();
	}

	public void devolverEjemplares(ArrayList<Integer> listaEjemplares){
		for (Integer i : listaEjemplares){
			devolverEjemplar(i);

		}
	}

	//Retira ejemplares para todos los productos del alquiler
	public ArrayList<Integer> retirarEjemplaresAlquiler(ArrayList<Producto> listaProductos){
		ArrayList<Integer> listaEjemplares = new ArrayList<Integer>();
		for (Producto p : listaProductos){
			listaEjemplares.add(retirarEjemplarProducto(p));
		}
		return listaEjemplares;
	}


	public int retirarEjemplarProducto(Producto p){
		//Cogemos el primer ejemplar de los disponibles
		int idEjemplar =buscarEjemplaresDisponiblesProducto(p.getId()).get(0).getId();
		alquilarEjemplar(idEjemplar);
		return idEjemplar;
	}

	public boolean hayEjemplaresAlquilados(int producto){
		for (Ejemplar e : listaEjemplares){
			if (e.getProducto()==producto && e.getEstado()==EstadoEjemplar.ALQUILADO)
				return true;
		}
		return false;
	}

}
