package com.blockflix.src;


import com.blockflix.src.Main.*;
public class Producto {

	private String nombre;
	private String categoria;
	private EstadoProducto estado;
	private TipoProducto tipo;
	private Soporte soporte;

	public Producto(String nombre, String categoria, TipoProducto tipo,Soporte soporte){
		this.nombre = nombre;
		this.categoria = categoria;
		this.estado =EstadoProducto.DISPONIBLE;
		this.tipo = tipo;
		this.soporte= soporte;
	}


	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	public void setCategoria(String categoria){
		this.categoria= categoria;

	}
	public void setEstado(EstadoProducto estado){
		this.estado= estado;

	}
	public void setTipo(TipoProducto tipo){
		this.tipo= tipo;

	}
	public void setSoporte(Soporte soporte){
		this.soporte= soporte;		
	}

	public String getNombre(){
		return this.nombre;
	}
	public String getCategoria(){
		return this.categoria;
	}

	public EstadoProducto getEstado(){
		return this.estado;
	}
	public TipoProducto getTipo(){
		return this.tipo;
	}
	public Soporte getSoporte(){
		return this.soporte;
	}


}
