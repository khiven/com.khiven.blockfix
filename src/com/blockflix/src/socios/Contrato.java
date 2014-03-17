package com.blockflix.src.socios;

import java.io.Serializable;
import java.util.Calendar;

import com.blockflix.src.tarifas.Tarifa;

/**
 * Clase contrato
 * @author Antonio Amate
 *
 */
public class Contrato implements Serializable {

	private Calendar fechaInicio;
	private Socio socio;
	private Tarifa tarifa;


	/**
	 * Constructor de contraro
	 * @param socio Socio propietario del contrato
	 * @param tarifa Tarifa contratada
	 */
	public Contrato(Socio socio,Tarifa tarifa){
		this.socio=socio;
		this.tarifa=tarifa;
		this.fechaInicio=Calendar.getInstance();
	}


	/*** GETS ***/

	/**
	 * Get de fecha de inicio del contrato
	 * @return Fecha de inicio del contrato
	 */
	public Calendar getFechaInicio(){
		return this.fechaInicio;
	}
	
	/**
	 * Get de socio del contrato
	 * @return Socio al que hace referencia el contrato
	 */
	public Socio getSocio(){
		return this.socio;
	}
	
	/**
	 * Get de tarifa
	 * @return Tarifa del contrato
	 */
	public Tarifa getTarifa(){
		return this.tarifa;
	}
	
	/*** SETS ***/
	
	/**
	 * Set de socio del contrato
	 * @param socio Nuevo socio del contrato
	 */
	public void setSocio(Socio socio){
		this.socio = socio;
	}
	
	/**
	 * Set de tarifa del contrato
	 * @param tarifa Nueva tarifa del contrato
	 */
	public void setTarifa(Tarifa tarifa){
		this.tarifa = tarifa;
	}
	
	/** 
	 * Set de fecha de inicio del contrato
	 * @param fechaInicio Nueva fecha de inicio del contrato
	 */
	public void setFechaInicio(Calendar fechaInicio){
		this.fechaInicio = fechaInicio;
	}
	
	public String toString(){
		Calendar fechaInicio=this.getFechaInicio();
		return "Contrato del socio nº"+this.getSocio().getnSocio()
			  +"\nFecha de contratacion: "+" " + fechaInicio.get(Calendar.DATE) + "/"
			  								 +fechaInicio.get(Calendar.MONTH)+"/"		
			  								 +fechaInicio.get(Calendar.YEAR)
			 +"\n"+this.getTarifa().toString(); 								 
	
	
	}
}