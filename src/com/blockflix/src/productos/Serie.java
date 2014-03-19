package com.blockflix.src.productos;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;

/** Clase producto serie
 * @author Antonio Amate
 *
 */
public class Serie extends Producto {

	private int temporada;
	private int volumen;


	/**Constructor de Serie
	 * @param nombre - nombre del producto
	 * @param temporada - temporada de la serie
	 * @param volumen - volumen de la serie
	 * @param categoria - categoria del producto
	 * @param soporte - soporte del producto
	 * @param id - id producto
	 */
	public Serie (String nombre,int temporada, int volumen, String categoria,Soporte soporte,int id){

		super(nombre,categoria,TipoProducto.SERIE,soporte,id);	
		this.temporada=temporada;
		this.volumen= volumen;
	}
	
	/** Set de temporada
	 * @param temporada Nuevo valor de temporada
	 */
	public void setTemporada(int temporada){
		this.temporada=temporada;
	}
	
	/** Set de Volumen
	 * @param volumen Nuevo valor de volumen
	 */
	public void setVolumen(int volumen){
		this.volumen=volumen;
	}
	
	/** Get de temporada
	 * @return Temporada de la serie
	 */
	public int getTemporada(){
		return this.temporada;
	}
	
	/** Get de Volumen
	 * @return Volumen de la serie
	 */
	public int getVolumen(){
		return this.volumen;
	}
	
	public String toString(){
		return super.toString()
				+"\nTemporada: "+this.getTemporada()
				+"\nVolumen: "+this.getVolumen();
				
	}
}
