package com.blockflix.src.constantes;

import java.io.Serializable;

public class VariablesSistema implements Serializable {
	public  int MAX_ALQUILERES = 3;
	public  double PRECIO_ALQUILER_PELICULA = 3;
	public  double PRECIO_ALQUILER_SERIE = 2;
	public  double PRECIO_ALQUILER_MUSICA = 1;
	public  int DURACION_ALQUILER =3;
	public  double SANCION_POR_DIA = 1;

	//GERENTE
	public  String USR_GERENTE ="admin";
	public  String PW_GERENTE="password_gerente";
	public  String NOMBRE_VIDEOCLUB="BlockFlix";
	
	

	public void setMaxAlquileres(int max){
		this.MAX_ALQUILERES=max;
	}
	public void setPrecioPelicula(double precio){
		this.PRECIO_ALQUILER_PELICULA=precio;
	}
	public void setPrecioSerie(double precio){
		this.PRECIO_ALQUILER_SERIE=precio;
	}
	public void setPrecioMusica(double precio){
		this.PRECIO_ALQUILER_MUSICA=precio;
	}
	public void setDuracionAlquiler(int dias){
		this.DURACION_ALQUILER=dias;
	}
	public void setSancionDia(double preciodia){
		this.SANCION_POR_DIA=preciodia;
	}
	public void setNombreVideoclub(String nombre){
		this.NOMBRE_VIDEOCLUB=nombre;
	}
	public void setUsuarioGerente(String nombre){
		this.USR_GERENTE=nombre;
	}
	public void setPwGerente(String pw){
		this.PW_GERENTE=pw;
	}
	
	
}
