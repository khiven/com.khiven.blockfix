package com.blockflix.src.ejemplar;

import java.io.Serializable;

import com.blockflix.src.constantes.Constantes.EstadoEjemplar;


/** Clase Ejemplar que apunta al producto  y posee una id única
 * @author Antonio Amate
 *
 */
public class Ejemplar implements Serializable{

	
	private int idProducto;
	private final int id;
	private EstadoEjemplar estado;
	
	/** Constructor de Ejemplar, se le pasa como argumento un id de producto existente y la id del ejemplar
	 * @param id
	 * @param idProducto
	 */
	public Ejemplar(int id,int idProducto){
		this.id=id;
		this.idProducto=idProducto;
		this.estado=EstadoEjemplar.DISPONIBLE;
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
	
	public void setEstado(EstadoEjemplar estado){
		this.estado=estado;
	}
	
	public EstadoEjemplar getEstado(){
		return this.estado;
	}
	
	public String toString (){
	
		return "\n Ejemplar de id: "
				+this.getId()
				+"\n Del producto con id: "
				+this.getProducto()
				+"\n Estado: "+this.getEstado().toString();
	}
	
	
	
	
}
