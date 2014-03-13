package com.blockflix.src.productos;


import com.blockflix.src.Main;
import com.blockflix.src.Main.*;



/** Clase Producto
 * @author Khiven
 *
 */

public class Producto {

	private String nombre;
	private String categoria;
	private EstadoProducto estado;
	private TipoProducto tipo;
	private Soporte soporte;

	/**
	 * Constructor de un producto 
	 * @param nombre Nombre del producto
	 * @param categoria Categoria del producto
	 * @param soporte Soporte del producto
	 */
	public Producto(String nombre, String categoria, TipoProducto tipo,Soporte soporte){
		this.nombre = nombre;
		this.categoria = categoria;
		this.estado =EstadoProducto.DISPONIBLE;
		this.tipo = tipo;
		this.soporte= soporte;
	}

	/**************** SETS *************/
	
	/** Set de nombre
	 * @param nombre Nuevo nombre del producto
	 */
	public void setNombre(String nombre){
		this.nombre= nombre;
	}


	/** Set de categoria
	 * @param categoria Nueva categoria
	 */
	public void setCategoria(String categoria){
		this.categoria= categoria;

	}

	
	/** Set de estado
	 * @param estado Nuevo estado del producto
	 */
	public void setEstado(EstadoProducto estado){
		this.estado= estado;

	}
	
	/** Set de tipo
	 * @param tipo Nuevo tipo de producto
	 */
	public void setTipo(TipoProducto tipo){
		this.tipo= tipo;

	}
	
	/** Set de soporte
	 * @param soporte Nuevo soporte del producto
	 */
	public void setSoporte(Soporte soporte){
		this.soporte= soporte;		
	}

	/******** GETS *******/
	
	
	/** Get de nombre
	 * @return Nombre del producto
	 */
	public String getNombre(){
		return this.nombre;
	}
	
	/** Get de categoria
	 * @return Categoria del producto
	 */
	public String getCategoria(){
		return this.categoria;
	}

	
	/** Get de estado
	 * @return Estado del producto
	 */
	public EstadoProducto getEstado(){
		return this.estado;
	}
	
	
	/** Get de Tipo
	 * @return Tipo de producto
	 */
	public TipoProducto getTipo(){
		return this.tipo;
	}
	
	
	
	/** Get de soporte
	 * @return Soporte del producto
	 */
	public Soporte getSoporte(){
		return this.soporte;
	}


}
