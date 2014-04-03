package com.blockflix.src.productos;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;



/**
 * Clase de un producto musical
 * @author Antonio Amate
 *
 */

public class Musica extends Producto {

	private int agno;
	private String interprete;


	/**
	 * Constructor de un producto musical
	 * @param nombre Nombre del producto
	 * @param agno	 A�o del producto
	 * @param interprete Interprete del producto
	 * @param categoria Categoria del producto
	 * @param soporte Soporte del producto
	 * @param id Id producto
	 */
	public Musica (String nombre,int agno, String interprete, String categoria,Soporte soporte,int id){

		super(nombre,categoria,TipoProducto.MUSICA,soporte,id);	
		this.agno=agno;
		this.interprete=interprete;
	}
	
	/**
	 * Set de a�o 
	 * @param agno Nuevo a�o
	 */
	public void setAgno(int agno){
		this.agno=agno;
	}
	
	/**
	 * Set de interprete
	 * @param interprete Nuevo interprete
	 */
	public void setInterprete(String interprete){
		this.interprete=interprete;
	}
	
	/**
	 * Get de A�o
	 * @return A�o del producto musical
	 */
	public int getAgno(){
		return this.agno;
	}
	
	/**
	 * Get de Interprete
	 * @return Interprete del producto musical
	 */
	public String getInterprete(){
		return this.interprete;
	}
	
	public String toString(){
		return super.toString()
				+"\nInterprete: "+this.getInterprete()
				+"\nA�o: "+this.getAgno();
				
	}
}
