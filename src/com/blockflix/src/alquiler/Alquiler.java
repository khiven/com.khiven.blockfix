package com.blockflix.src.alquiler;

import java.util.ArrayList;
import java.util.Calendar;

import com.blockflix.src.productos.Ejemplar;
import com.blockflix.src.socios.Socio;

/**
 * Clase que almacena un alquiler de un socio de uno a tres productos
 * @author Antonio Amate
 *
 */
public class Alquiler {

	private Socio socio;
	private Calendar fechaInicio;
	private ArrayList<Ejemplar> ejemplares;

	/**
	 * Constructor de un alquiler
	 * @param socio Socio que realiza el alquiler
	 * @param ejemplares Lista de ejemplares que alquila
	 */
	public Alquiler(Socio socio,ArrayList<Ejemplar> ejemplares){
		this.socio=socio;
		this.fechaInicio= Calendar.getInstance();
		this.ejemplares=ejemplares;
	}
	
	
	
	
	/*** GETS ***/
	
	/**
	 * Get de fecha de inicio del alquler
	 * @return Fecha de inicio del alquler
	 */
	public Calendar getFechaInicio(){
		return this.fechaInicio;
	}
	
	/**
	 * Get de ejemplares del alquiler
	 * @return Ejemplares alquilados
	 */
	public ArrayList<Ejemplar> getEjemplares(){
		return this.ejemplares;
	}
	
	/**
	 * Get de socio del alquiler
	 * @return Socio al que hace referencia el alquiler
	 */
	public Socio getSocio(){
		return this.socio;
	}
	

	
	/*** SETS ***/
	
	/**
	 * Set de socio del alquiler
	 * @param socio Nuevo socio del alquiler
	 */
	public void setSocio(Socio socio){
		this.socio = socio;
	}
	
	/**
	 * Set de ejemplares alquilados
	 * @param ejemplares Nuevos ejemplares del alquiler
	 */
	public void setEjemplares(ArrayList<Ejemplar> ejemplares){
		this.ejemplares=ejemplares;
	}
	
	/** 
	 * Set de fecha de inicio del alquiler
	 * @param fechaInicio Nueva fecha de inicio del alquiler
	 */
	public void setFechaInicio(Calendar fechaInicio){
		this.fechaInicio = fechaInicio;
	}
	

}
