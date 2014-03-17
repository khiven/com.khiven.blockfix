package com.blockflix.src.constantes;

import java.util.ArrayList;

import com.blockflix.src.tarifas.Tarifa;

public class Constantes {
	
	public static final String PATH_SOCIOS= "Ficheros_de_datos/Socios.dat";
	public static final String PATH_PELICULAS= "Ficheros_de_datos/Peliculas.dat";
	public static final String PATH_SERIES= "Ficheros_de_datos/Series.dat";
	public static final String PATH_MUSICA= "Ficheros_de_datos/Musica.dat";
	public static final String PATH_ALQUILERES= "Ficheros_de_datos/Alquileres.dat";
	public static final String PATH_EJEMPLARES ="Ficheros_de_datos/Ejemplares.dat";
	public static final String PATH_CONTRATOS ="Ficheros_de_datos/Contratos.dat";
	
	
	

	public static enum EstadoProducto { ALQUILADO, DISPONIBLE, NO_DISPONIBLE};
	
	public static enum EstadoSocio {SIN_SANCION, SANCIONADO};

	public static enum TipoProducto { PELICULA, SERIE, MUSICA};

	public static enum Soporte { DVD, BLURAY, CD, VINILO};

	public static enum TipoTarifa{
		PELICULAS{
			public String toString(){
				return "Tarifa de Peliculas";
			}
		},SERIES{
			public String toString(){
				return "Tarifa de Series";
			}
		},MUSICA{
			public String toString(){
				return "Tarifa de Música";
			}
		},PELICULAS_SERIES{
			public String toString(){
				return "Tarifa de Peliculas y Series";
			}
		},PELICULAS_MUSICA{
			public String toString(){
				return "Tarifa de Peliculas y Música";
			}
		},SERIES_MUSICA{
			public String toString(){
				return "Tarifa de Series y Música";
			}
		},PREMIUM{
			public String toString(){
				return "Tarifa Premium";
			}
		}
	};

	public static Tarifa crearTarifasPeliculas(){
		return new Tarifa(TipoTarifa.PELICULAS,10,3,1,4);
		
	}
}
