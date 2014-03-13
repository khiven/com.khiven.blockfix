package com.blockflix.src.constantes;

public class Constantes {

	public static enum EstadoProducto { ALQUILADO, DISPONIBLE, NO_DISPONIBLE};

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


}
