package com.blockflix.src.productos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.TipoProducto;

public class GestionProductos {


	private ArrayList<String> categoriasCine;
	private ArrayList<String> categoriasSeries;
	private ArrayList<String> categoriasMusica;

	public GestionProductos(){
		categoriasCine = new ArrayList<String>();
		categoriasSeries= new ArrayList<String>();
		categoriasMusica = new ArrayList<String>();
		this.loadCategorias();
	}

	/************************************************************************PRODUCTOS *******************************************/
	
	
	
	
	
	
	
	
	
	
	/***************************************************************************************************************************/
	
	/************************************************************************CATEGORIAS ****************************************/
	public void loadCategoria(TipoProducto tipoCat,String filePath){

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));


			String line = br.readLine();
			while (line != null){
				switch (tipoCat) {
				case PELICULA:
					this.categoriasCine.add(line);
					break;
				case SERIE :
					this.categoriasSeries.add(line);
					break;
				case MUSICA :
					this.categoriasMusica.add(line);
					break;
				}
				line = br.readLine();
			}
			br.close();
		}catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void loadCategorias(){
		this.loadCategoria(TipoProducto.PELICULA, Constantes.PATH_CATEGORIAS_PELICULAS);
		this.loadCategoria(TipoProducto.SERIE, Constantes.PATH_CATEGORIAS_SERIES);
		this.loadCategoria(TipoProducto.MUSICA, Constantes.PATH_CATEGORIAS_MUSICA);
	}

	public void printCategoria(TipoProducto cat){
		ArrayList<String> aux;
		switch (cat) {
		case PELICULA:
			aux=this.categoriasCine;
			System.out.println();
			System.out.println("Categorias de Cine");
			break;
		case SERIE :
			aux=this.categoriasSeries;
			System.out.println();
			System.out.println("Categorias de Series");
			break;
		case MUSICA :
			aux=this.categoriasMusica;
			System.out.println();
			System.out.println("Categorias de Musica");
			break;
		default:
			aux=null;
		}
		if (aux!=null){
	
			for (int i=0;i< aux.size();i++){
				System.out.println(aux.get(i));
			}
		}

	}

	public void printeCategorias(){
		printCategoria(TipoProducto.PELICULA);
		printCategoria(TipoProducto.SERIE);
		printCategoria(TipoProducto.MUSICA);
	}
/*************************************************************************************************************************/
	
	
}
