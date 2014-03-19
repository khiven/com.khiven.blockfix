package com.blockflix.src.alquiler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase que almacena un alquiler de un socio de uno a tres productos
 * @author Antonio Amate
 *
 */
public class Alquiler implements Serializable {

	private int nSocio;
	private Calendar fechaInicio;
	private ArrayList<Integer> listaEjemplares;
	

	/**
	 * Constructor de un alquiler
	 * @param socio Socio que realiza el alquiler
	 * @param ejemplares Lista de ejemplares que alquila
	 */
	public Alquiler(int nSocio,ArrayList<Integer> listaEjemplares){
		this.nSocio=nSocio;
		this.fechaInicio= Calendar.getInstance();
		this.listaEjemplares=listaEjemplares;
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
	public ArrayList<Integer> getEjemplares(){
		return this.listaEjemplares;
	}
	
	/**
	 * Get de socio del alquiler
	 * @return Socio al que hace referencia el alquiler
	 */
	public int getnSocio(){
		return this.nSocio;
	}
	

	
	/*** SETS ***/
	
	/**
	 * Set de socio del alquiler
	 * @param socio Nuevo numero de socio del alquiler
	 */
	public void setnSocio(int nSocio){
		this.nSocio = nSocio;
	}
	
	/**
	 * Set de ejemplares alquilados
	 * @param ejemplares Nuevos ejemplares del alquiler
	 */
	public void setEjemplares(ArrayList<Integer> ejemplares){
		this.listaEjemplares=ejemplares;
	}
	
	/** 
	 * Set de fecha de inicio del alquiler
	 * @param fechaInicio Nueva fecha de inicio del alquiler
	 */
	public void setFechaInicio(Calendar fechaInicio){
		this.fechaInicio = fechaInicio;
	}
	
	public String toString(){
		String ids=" ";
		for (Integer i : listaEjemplares){
			ids+=i+", ";
		}
		
		return "\nAlquiler del socio nº"+this.getnSocio()
				+"\nDe los productos con id:"
				+ids
				+"\nFecha de alquiler: "
				+ fechaInicio.get(Calendar.DATE) + "/"
				+fechaInicio.get(Calendar.MONTH)+"/"		
				+fechaInicio.get(Calendar.YEAR);
				
	}
}
