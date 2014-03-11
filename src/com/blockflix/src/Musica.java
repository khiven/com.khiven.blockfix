package com.blockflix.src;

import com.blockflix.src.Main.Soporte;
import com.blockflix.src.Main.TipoProducto;

/**
 * Clase de un producto musical
 * @author Khiven
 *
 */

public class Musica extends Producto {

	private int agno;
	private String interprete;


	/**
	 * Constructor de un producto musical
	 * @param nombre Nombre del producto
	 * @param agno	 Año del producto
	 * @param interprete Interprete del producto
	 * @param categoria Categoria del producto
	 * @param soporte Soporte del producto
	 */
	public Musica (String nombre,int agno, String interprete, String categoria,Soporte soporte){

		super(nombre,categoria,TipoProducto.MUSICA,soporte);	
		this.agno=agno;
		this.interprete=interprete;
	}
	
	/**
	 * Set de año 
	 * @param agno Nuevo año
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
	 * Get de Año
	 * @return Año del producto musical
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
}
