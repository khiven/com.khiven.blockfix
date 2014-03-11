package com.blockflix.src;

public class Main {

	public static enum EstadoProducto { ALQUILADO, DISPONIBLE, NO_DISPONIBLE};

	public static enum TipoProducto { PELICULA, SERIE, MUSICA};

	public static enum Soporte { DVD, BLURAY, CD, VINILO};
	
	
	

	 //MAIN
    public static void main(String[] args) {
        //Se crean instancias
    	 Pelicula pelicula = new Pelicula("Pen",1947,"Pakito","Aburrida",Soporte.BLURAY);
        //Accedemos al metodo estatico para ver el numero
        //de instancias de tipo Persona creadas
        System.out.println(pelicula.getNombre());
    }

}
