package com.blockflix.src.constantes;

import java.io.Serializable;

public class VariablesSistema implements Serializable {
	public  int MAX_ALQUILERES = 3;
	public  double PRECIO_ALQUILER_PELICULA = 3;
	public  double PRECIO_ALQUILER_SERIE = 2;
	public  double PRECIO_ALQUILER_MUSICA = 1;
	public  int DURACION_ALQUILER =3;
	public  double SANCION_POR_DIA = 1;
	public int PLAZO_PAGO_SANCION = 10;
	public double PRECIO_TARIFA_PELICULAS = 8;
	public double PRECIO_TARIFA_MUSICA = 6;
	public double PRECIO_TARIFA_SERIES = 7;
	public double PRECIO_TARIFA_PELICULASMUSICA = 11;
	public double PRECIO_TARIFA_PELICULASSERIES = 10;
	public double PRECIO_TARIFA_MUSICASERIES = 9;
	public double PRECIO_TARIFA_PREMIUM = 13;
	public int DURACION_TARIFA = 30;
	public double PRECIO_SUPLEMENTO = 3;
	public int DURACION_SUPLEMENTO = 1;

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
	public void setPlazoPagoSancion(int plazo){
		this.PLAZO_PAGO_SANCION=plazo;
	}
	public void setPrecioTarifaPeliculas(double precio){
		this.PRECIO_TARIFA_PELICULAS=precio;
	}
	public void setPrecioTarifaMusica(double precio){
		this.PRECIO_TARIFA_MUSICA=precio;
	}
	public void setPrecioTarifaSeries(double precio){
		this.PRECIO_TARIFA_SERIES=precio;
	}
	public void setPrecioTarifaPeliculasMusica(double precio){
		this.PRECIO_TARIFA_PELICULASMUSICA=precio;
	}
	public void setPrecioTarifaPeliculasSeries(double precio){
		this.PRECIO_TARIFA_PELICULASSERIES=precio;
	}
	public void setPrecioTarifaMusicaSeries(double precio){
		this.PRECIO_TARIFA_MUSICASERIES=precio;
	}
	public void setPrecioTarifaPremium(double precio){
		this.PRECIO_TARIFA_PREMIUM=precio;
	}
	public void setDuracionTarifa(int duracion){
		this.DURACION_TARIFA=duracion;
	}
	public void setPrecioSuplemento(double precio){
		this.PRECIO_SUPLEMENTO=precio;
	}
	public void setDuracionSuplemento(int duracion){
		this.DURACION_SUPLEMENTO=duracion;
	}
	public void setSancionPorDia(double precio){
		this.SANCION_POR_DIA=precio;
	}
	
}
