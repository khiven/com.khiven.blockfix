package com.blockflix.src.empleado;

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
