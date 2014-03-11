package com.blockflix.src;


/** Clase Ejemplar que apunta al producto  y posee una id única
 * @author Khiven
 *
 */
public class Ejemplar {

	
	private Producto producto;
	private final int id;
	
	/** Constructor de Ejemplar, se le pasa como argumento un producto existente y la id del ejemplar
	 * @param id
	 * @param producto
	 */
	public Ejemplar(int id,Producto producto){
		this.id=id;
		this.producto=producto;
	}
	
	/** Set de producto 
	 * @param producto nuevo producto del ejemplar
	 */
	public void setProducto(Producto producto){
		this.producto=producto;
	}
	
	/** Get de producto
	 * @return Producto del ejemplar
	 */
	public Producto getProducto(){
		return this.producto;
	}
	
	/** Get de ID
	 * @return La id del ejemplar
	 */
	public int getId(){
		return this.id;
	}
	
	
	
	
}
