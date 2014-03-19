package com.blockflix.src.contratos;

import java.io.Serializable;
import java.util.Calendar;

import com.blockflix.src.constantes.Constantes.TipoTarifa;

/**
 * Clase contrato
 * @author Antonio Amate
 *
 */
public class Contrato implements Serializable {

	private Calendar fechaInicio;
	private int nSocio;
	private TipoTarifa tarifa;
	private boolean extTiempo;


	/**
	 * Constructor de contraro
	 * @param socio Socio propietario del contrato
	 * @param tarifa Tarifa contratada
	 */
	public Contrato(int nSocio,TipoTarifa tarifa,boolean extTiempo){
		this.nSocio=nSocio;
		this.tarifa=tarifa;
		this.fechaInicio=Calendar.getInstance();
		this.extTiempo=extTiempo;
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
	 * @return NºSocio al que hace referencia el contrato
	 */
	public int getnSocio(){
		return this.nSocio;
	}
	
	/**
	 * Get de tarifa
	 * @return TipoTarifa del contrato
	 */
	public TipoTarifa getTarifa(){
		return this.tarifa;
	}
	
	/*** SETS ***/
	
	/**
	 * Set de socio del contrato
	 * @param nSocio Nuevo nºsocio del contrato
	 */
	public void setSocio(int nSocio){
		this.nSocio = nSocio;
	}
	
	/**
	 * Set de tarifa del contrato
	 * @param tarifa Nueva tarifa del contrato
	 */
	public void setTarifa(TipoTarifa tarifa){
		this.tarifa = tarifa;
	}
	
	/** 
	 * Set de fecha de inicio del contrato
	 * @param fechaInicio Nueva fecha de inicio del contrato
	 */
	public void setFechaInicio(Calendar fechaInicio){
		this.fechaInicio = fechaInicio;
	}
	
	public void setExtTiempo(boolean ext){
		this.extTiempo=ext;
	}
	
	public boolean getExtTiempo(){
		return this.extTiempo;
	}
	
	public String toString(){
		Calendar fechaInicio=this.getFechaInicio();
		String ext = "No";
		if (this.getExtTiempo()) ext="Si";
		
		
		return "\nContrato del socio nº"+this.getnSocio()
			  +"\nFecha de contratacion: "+" " + fechaInicio.get(Calendar.DATE) + "/"
			  								 +fechaInicio.get(Calendar.MONTH)+"/"		
			  								 +fechaInicio.get(Calendar.YEAR)
			 +"\n ¿Extension de tiempo contratada?: "+ext 								 
			 +"\n"+this.getTarifa().toString(); 								 
	
	
	}
}