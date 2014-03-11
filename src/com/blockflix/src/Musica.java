package com.blockflix.src;

import com.blockflix.src.Main.Soporte;
import com.blockflix.src.Main.TipoProducto;

public class Musica extends Producto {

	private int agno;
	private String interprete;


	public Musica (String nombre,int agno, String interprete, String categoria,Soporte soporte){

		super(nombre,categoria,TipoProducto.MUSICA,soporte);	
		this.agno=agno;
		this.interprete=interprete;
	}
	
	public void setAgno(int agno){
		this.agno=agno;
	}
	
	public void setInterprete(String interprete){
		this.interprete=interprete;
	}
	
	public int getAgno(){
		return this.agno;
	}
	
	public String getInterprete(){
		return this.interprete;
	}
}
