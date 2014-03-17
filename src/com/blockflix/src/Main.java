package com.blockflix.src;

import com.blockflix.src.socios.GestionSocios;
import com.blockflix.src.socios.Socio;

/** Clase principal de pruebas
 * @author Antonio Amate
 *
 */


public class Main {





	/** Metodo main que ejecuta las pruebas
	 * 
	 * @param args Vacío
	 */
	public static void main(String[] args) {
		
		
		GestionSocios gs = new GestionSocios();
		
		//gs.addSocio("asd2","asd2","asd2","asd2","asd2");
		
	//	gs.printListaSocios();
		Socio socio1 = gs.buscarSocio(1);
	//	gs.resetContratos();
	//	gs.contratarTarifa(socio1, gs.tarifaPeliculas);
		
		//gs.printListaContratos();
		//System.out.println(gs.getContratoSocio(socio1).toString());
		gs.saveSocios();
		gs.saveContratos();


		
		
		

	}

}
