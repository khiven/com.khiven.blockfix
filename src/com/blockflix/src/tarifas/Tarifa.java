package com.blockflix.src.tarifas;

import java.util.Calendar;

import com.blockflix.src.constantes.Constantes.TipoTarifa;


/** Clase Tarifa para crear distintas tarifas y asociarlas a socios posteriormente
 * @author Antonio Amate
 *
 */

public class Tarifa {

	
	private TipoTarifa tipo;
	private float precio;
	private Calendar tiempo;
	private Calendar tiempoExtension;
	private float precioExtension;
	
	/** Constructor de Tarifa
	 * @param tipo Tipo de tarifa 
	 * @param precio Precio de la tarifa
	 * @param tiempo Tiempo de duracion de la tarifa
	 * @param tiempoExtension Tiempo de extension de alquileres
	 * @param precioExtension Precio extra de la extension de tiempo
	 */
	public Tarifa(TipoTarifa tipo,float precio,Calendar tiempo,
				  Calendar tiempoExtension,float precioExtension){
		this.tipo = tipo;
		this.precio=precio;
		this.tiempo=tiempo;
		this.tiempoExtension=tiempoExtension;
		this.precioExtension=precioExtension;
	}

	//*** SETS ***//
	
	/**Set de tipo de tarifa
	 * @param tipo Nuevo tipo de tarifa
	 */
	public void setTipo(TipoTarifa tipo){
		this.tipo=tipo;
	}
	
	/**Set de precio de tarifa
	 * @param precio Nuevo precio de tarifa
	 */
	public void setPrecio(float precio){
		this.precio=precio;
	}
	
	/**Set de tiempo de tarifa
	 * @param tiempo Nuevo tiempo de duracion de la tarifa
	 */
	public void setTiempo(Calendar tiempo){
		this.tiempo=tiempo;
	}
	
	/**Set de tiempo de extension
	 * @param tiempoExtension Nuevo tiempo de extension de alquileres
	 */
	public void setTiempoExtension(Calendar tiempoExtension){
		this.tiempoExtension=tiempoExtension;
	}
	
	/**Set de precio de extension
	 * @param precioExtension Nuevo precio de extension de alquileres
	 */
	public void setPrecioExtension(float precioExtension){
		this.precioExtension=precioExtension;
	}
	
	//*** GETS ***//
	
	/**Get de tipo de tarifa
	 * @return Tipo de tarifa actual
	 */
	public TipoTarifa getTipo(){
		return this.tipo;
	}
	
	/**Get de nombre de tarifa
	 * @return El nombre de la tarifa
	 */
	public String getNombre(){
		return this.tipo.toString();
	}
	
	/**Get de precio de tarifa
	 * @return El precio de la tarifa
	 */
	public float getPrecio(){
		return this.precio;
	}
	
	/**Get de tiempo de tarifa
	 * @return El tiempo de duracion de la tarifa
	 */
	public Calendar getTiempo(){
		return this.tiempo;
	}
	
	/**Get de tiempo de extension
	 * @return El tiempo de extension del alquiler
	 */
	public Calendar getTiempoExtension(){
		return this.tiempoExtension;
	}
	
	/**Get de precio de extension
	 * @return El precio de extension del alquiler
	 */
	public float getPrecioExtension(){
		return this.precioExtension;
	}
	
	
}
