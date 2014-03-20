package com.blockflix.src.socios;

import java.io.Serializable;

import com.blockflix.src.constantes.Constantes.EstadoSocio;

/**
 * Clase Producto
 * 
 * @author Antonio Amate, Alvaro de No
 * 
 */

public class Socio implements Serializable {

	private int nSocio;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String dni;
	private EstadoSocio estado;
	private double cuantiaSancion;

	/**
	 * Constructor de un Socio
	 * 
	 * @param nombre
	 *            Nombre del socio
	 * @param apellidos
	 *            Apellidos del socio
	 * @param direccion
	 *            Direccion del socio
	 * @param telefono
	 *            Numero de telefono del socio
	 * @param dni
	 *            DNI del socio
	 * @param nSocio
	 *            numero de socio
	 */
	public Socio(String nombre, String apellidos, String direccion,
			String telefono, String dni, int nSocio) {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setDni(dni);
		this.setnSocio(nSocio);
		this.setEstado(EstadoSocio.SIN_SANCION);
		this.cuantiaSancion=0;
	}

	/**
	 * Get de nSocio
	 * 
	 * @return Numero de socio
	 */
	public int getnSocio() {
		return nSocio;
	}

	/**
	 * Set de nSocio
	 * 
	 * @param nSocio
	 *            Nuevo numero de socio
	 */
	public void setnSocio(int nSocio) {
		this.nSocio = nSocio;
	}

	/**
	 * Get de nombre
	 * 
	 * @return Nombre del socio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set de nombre
	 * 
	 * @param nombre
	 *            Nuevo nombre del socio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Get de apellidos
	 * 
	 * @return Apellidos del socio
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Set de apellidos
	 * 
	 * @param apellidos
	 *            Nuevos apellidos del socio
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Get de direccion
	 * 
	 * @return Direccion del socio
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Set de direccion
	 * 
	 * @param direccion
	 *            Nueva direccion del socio
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Get de telefono
	 * 
	 * @return Telefono del socio
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Set de telefono
	 * 
	 * @param telefono
	 *            Nuevo numero de telefono del socio
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Get de dni
	 * 
	 * @return DNI del socio
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Set de dni
	 * 
	 * @param dni
	 *            nuevo DNI del socio
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	
	

	/**
	 * Get de estado
	 * 
	 * @return Estado del socio
	 */
	public EstadoSocio getEstado() {
		return estado;
	}

	/**
	 * Set de estado
	 * 
	 * @param estado
	 *            Nuevo estado del socio
	 */
	public void setEstado(EstadoSocio estado) {
		this.estado = estado;
	}
	
	public double getSancion(){
		return this.cuantiaSancion;
	}
	
	public void setSancion(double sancion){
		this.cuantiaSancion=sancion;
	}
	
	public void incrSancion(double sancion){
		this.cuantiaSancion+=sancion;
	}
	
	public String toString(){
		return "** SOCIO n�"+this.getnSocio() +" **"
		+"\nNombre: "+this.getNombre()
		+"\nApellidos: "+this.getApellidos()
		+"\nDireccion: "+this.getDireccion()
		+"\nTelefono: "+this.getTelefono()
		+"\nDNI: "+this.getDni()
		+"\nSancionado: "+this.getSancion()+"euros";
	}
	@Override
	public boolean equals(Object socio){
		 if (socio == null) return false;
		 if (socio== this) return true;
		 if (!(socio instanceof Socio))return false;
		 Socio socioAux = (Socio)socio;
		 
		return this.nombre.equals(socioAux.getNombre())
				&& this.apellidos.equals(socioAux.getApellidos())
				&& this.dni.equals(socioAux.getDni());
				
				
	}
	
}