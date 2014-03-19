package com.blockflix.src.empleado;

import org.visa.tpv.PasarelaDePago;
import org.visa.tpv.excepciones.ExcepcionVISA;

import com.blockflix.src.contratos.GestionContratos;
import com.blockflix.src.socios.GestionSocios;
import com.blockflix.src.tarifas.GestionTarifas;

public class Empleado {
	
	public GestionSocios gs;
	public GestionTarifas gt;
	public GestionContratos gc;

	
	public Empleado(){
		gs=new GestionSocios();
		gt=new GestionTarifas();
		gc= new GestionContratos();
	}
	
	
	
	
	
	
	
	
	/*** PAGOS ***/
	
	public void pagar(String nTarjeta,String password,double cuantia){
		PasarelaDePago p = PasarelaDePago.getPasarela();
		try {
			p.pagar(nTarjeta, password, cuantia);
		} catch (ExcepcionVISA e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/*** FICHEROS ***/
	public void load(){
		gs.loadSocios();
		gt.loadTarifas();
		gc.loadContratos();
	}
	
	public void save(){
		gs.saveSocios();
		gt.saveTarifas();
		gc.saveContratos();
	}
	
	public void reset(){
		gs.resetSocios();
		gc.resetContratos();
	}
}
