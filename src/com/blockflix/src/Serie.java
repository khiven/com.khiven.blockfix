package com.blockflix.src;

import com.blockflix.src.Main.Soporte;
import com.blockflix.src.Main.TipoProducto;

public class Serie extends Producto {

	private int temporada;
	private int volumen;


	public Serie (String nombre,int temporada, int volumen, String categoria,Soporte soporte){

		super(nombre,categoria,TipoProducto.SERIE,soporte);	
		this.temporada=temporada;
		this.volumen= volumen;
	}
	
	public void setTemporada(int temporada){
		this.temporada=temporada;
	}
	
	public void setVolumen(int volumen){
		this.volumen=volumen;
	}
	
	public int getTemporada(){
		return this.temporada;
	}
	
	public int getVolumen(){
		return this.volumen;
	}
}
