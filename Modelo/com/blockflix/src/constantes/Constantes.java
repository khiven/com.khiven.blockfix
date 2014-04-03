package com.blockflix.src.constantes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.blockflix.src.gerente.Gerente;
import com.blockflix.src.tarifas.Tarifa;

public class Constantes implements Serializable {

	// FICHEROS INTERNOS
	public static final String PATH_SOCIOS= "Ficheros_de_datos/Socios.dat";
	public static final String PATH_PELICULAS= "Ficheros_de_datos/Peliculas.dat";
	public static final String PATH_SERIES= "Ficheros_de_datos/Series.dat";
	public static final String PATH_MUSICA= "Ficheros_de_datos/Musica.dat";
	public static final String PATH_ALQUILERES= "Ficheros_de_datos/Alquileres.dat";
	public static final String PATH_EJEMPLARES ="Ficheros_de_datos/Ejemplares.dat";
	public static final String PATH_CONTRATOS ="Ficheros_de_datos/Contratos.dat";
	public static final String PATH_TARIFAS ="Ficheros_de_datos/Tarifas.dat";
	public static final String PATH_VARIABLES="Ficheros_de_datos/Variables.dat";
	//FICHEROS EXTERNOS
	public static final String PATH_CATEGORIAS_PELICULAS="Ficheros_de_datos/CategoriasCine.txt";
	public static final String PATH_CATEGORIAS_SERIES="Ficheros_de_datos/CategoriasSeries.txt";
	public static final String PATH_CATEGORIAS_MUSICA="Ficheros_de_datos/CategoriasMusica.txt";

	
	public static VariablesSistema variables = loadVariables();
	//ENUMS

	public static enum EstadoEjemplar { 
		ALQUILADO{
			public String toString(){
				return "Alquilado";
			}
		}, DISPONIBLE{
			public String toString(){
				return "Disponible";
			}
		}, NO_DISPONIBLE{
			public String toString(){
				return "No disponible";
			}
		}
	};

	public static enum EstadoSocio {SIN_SANCION, SANCIONADO};



	public static enum TipoProducto { PELICULA{
		public String toString(){
			return "Pelicula";
		}
	}, SERIE{
		public String toString(){
			return "Serie";
		}
	}, MUSICA{
		public String toString(){
			return "Musica";
		}
	}};

	public static enum Soporte { DVD{
		public String toString(){
			return "DVD";
		}

	}, BLURAY{
		public String toString(){
			return "BLURAY";
		}
	}, CD{
		public String toString(){
			return "CD";
		}
	}, VINILO{
		public String toString(){
			return "VINILO";
		}
	}};

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

	//AUTOCREACION DE TARIFAS
	public static Tarifa crearTarifaPeliculas(){
		return new Tarifa(TipoTarifa.PELICULAS,10,3,1,4);
	}

	private static VariablesSistema loadVariables() {
		// TODO Auto-generated method stub
		VariablesSistema var=new VariablesSistema();

		Object aux;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constantes.PATH_VARIABLES));
			//	System.out.print(ois.available());
			aux= ois.readObject();

			if (aux instanceof VariablesSistema){
				ois.close();
				return (VariablesSistema)aux;

			}
			ois.close();
		
		
	} catch (IOException | ClassNotFoundException e ) {
		// TODO Auto-generated catch block


		//e.printStackTrace();
	}

	return var;

}
	
	public static void saveVariables(){

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(Constantes.PATH_VARIABLES));

			
				oos.writeObject(Constantes.variables);
			
			oos.close();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



public static Tarifa crearTarifaSeries(){
	return new Tarifa(TipoTarifa.SERIES,8,3,1,4);
}

public static Tarifa crearTarifaMusica(){
	return new Tarifa(TipoTarifa.MUSICA,5,3,1,4);
}

public static Tarifa crearTarifaPeliculasSeries(){
	return new Tarifa(TipoTarifa.PELICULAS_SERIES,12,3,1,4);
}

public static Tarifa crearTarifaPeliculasMusica(){
	return new Tarifa(TipoTarifa.PELICULAS_MUSICA,11,3,1,4);
}
public static Tarifa crearTarifaSeriesMusica(){
	return new Tarifa(TipoTarifa.SERIES_MUSICA,9,3,1,4);
}
public static Tarifa crearTarifaPremium(){
	return new Tarifa(TipoTarifa.PREMIUM,15,3,1,4);
}

public static Gerente doLogin(String usr,String pw){
	if (Constantes.variables.USR_GERENTE.equals(usr) && Constantes.variables.PW_GERENTE.equals(pw))
		return new Gerente();
	return null;
}


}


