package com.blockflix.src.productos;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;

/** Clase producto pelicula
 * @author Antonio Amate
 *
 */
public class Pelicula extends Producto{

	private int agno;
	private String director;


	/**
	 * Constructor de un producto pelicula
	 * @param nombre Nombre del producto
	 * @param agno	 Año del producto
	 * @param director Director del producto
	 * @param categoria Categoria del producto
	 * @param soporte Soporte del producto
	 * @param id id producto
	 */
	public Pelicula (String nombre,int agno, String director, String categoria,Soporte soporte,int id){

		super(nombre,categoria,TipoProducto.PELICULA,soporte,id);	
		this.agno=agno;
		this.director=director;
	}
	
	/**
	 * Set de año 
	 * @param agno Nuevo año
	 */
	public void setAgno(int agno){
		this.agno=agno;
	}
	
	/**
	 * Set de director
	 * @param interprete Nuevo director
	 */
	public void setDirector(String director){
		this.director=director;
	}
	
	/**
	 * Get de Año
	 * @return Año del producto pelicula
	 */
	public int getAgno(){
		return this.agno;
	}
	
	/**
	 * Get de director
	 * @return Director del producto pelicula
	 */
	public String getDirector(){
		return this.director;
	}
	
	public String toString(){
		return super.toString()
				+"\nDirector: "+this.getDirector()
				+"\nAño: "+this.getAgno();
				
	}
}
