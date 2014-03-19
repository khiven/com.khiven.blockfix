package com.blockflix.src;

import com.blockflix.src.empleado.Empleado;

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
		
		Empleado emp = new Empleado();
		
	
		//emp.gs.addSocio("Socio2", "Apellido2", "Direccion2", "Telefono2", "DNI2");
		
	//	emp.gc.contratarTarifa(1, TipoTarifa.MUSICA);
	
		
//		emp.gc.printListaContratos();
//		emp.gs.eliminarSocio(1);
	//	emp.gs.modificarDatosSocio(1,"Socio1", "Apellido2", "Direccion2", "Telefono2", "DNI2");
		emp.gs.printListaSocios();
		emp.gp.printeCategorias();
	//	emp.pagar("123456789012", "1234", 20);
		
		//emp.gt.printListaTarifas();
		emp.save();


		
		
		

	}

}
