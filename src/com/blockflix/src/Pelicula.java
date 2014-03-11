package com.blockflix.src;

import com.blockflix.src.Main.Soporte;
import com.blockflix.src.Main.TipoProducto;

public class Pelicula extends Producto {

	private int agno;
	private String director;


	public Pelicula (String nombre,int agno, String director, String categoria,Soporte soporte){

		super(nombre,categoria,TipoProducto.PELICULA,soporte);	
		this.agno=agno;
		this.director=director;
	}
	
	public void setAgno(int agno){
		this.agno=agno;
	}
	
	public void setDirector(String director){
		this.director=director;
	}
	
	public int getAgno(){
		return this.agno;
	}
	
	public String getDirector(){
		return this.director;
	}
}
