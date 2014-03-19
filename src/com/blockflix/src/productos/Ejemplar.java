package com.blockflix.src.productos;


/** Clase Ejemplar que apunta al producto  y posee una id única
 * @author Antonio Amate
 *
 */
public class Ejemplar {

	
	private int idProducto;
	private final int id;
	
	/** Constructor de Ejemplar, se le pasa como argumento un id de producto existente y la id del ejemplar
	 * @param id
	 * @param idProducto
	 */
	public Ejemplar(int id,int idProducto){
		this.id=id;
		this.idProducto=idProducto;
	}
	
	/** Set de producto 
	 * @param idProducto nuevo producto del ejemplar
	 */
	public void setProducto(int idProducto){
		this.idProducto=idProducto;
	}
	
	/** Get de producto
	 * @return idProducto del ejemplar..
	 */
	public int getProducto(){
		return this.idProducto;
	}
	
	/** Get de ID
	 * @return La id del ejemplar
	 */
	public int getId(){
		return this.id;
	}
	
	
	
	
}
