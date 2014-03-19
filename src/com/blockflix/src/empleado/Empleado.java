package com.blockflix.src.empleado;

import org.visa.tpv.PasarelaDePago;
import org.visa.tpv.excepciones.ExcepcionVISA;

import com.blockflix.src.alquiler.GestionAlquileres;
import com.blockflix.src.constantes.Constantes.EstadoEjemplar;
import com.blockflix.src.contratos.GestionContratos;
import com.blockflix.src.ejemplar.Ejemplar;
import com.blockflix.src.ejemplar.GestionEjemplares;
import com.blockflix.src.productos.GestionProductos;
import com.blockflix.src.productos.Musica;
import com.blockflix.src.productos.Pelicula;
import com.blockflix.src.productos.Producto;
import com.blockflix.src.productos.Serie;
import com.blockflix.src.socios.GestionSocios;
import com.blockflix.src.tarifas.GestionTarifas;

public class Empleado {
	
	public GestionSocios gs;
	public GestionTarifas gt;
	public GestionContratos gc;
	public GestionProductos gp;
	public GestionEjemplares ge;
	public GestionAlquileres ga;

	
	public Empleado(){
		gs=new GestionSocios();
		gt=new GestionTarifas();
		gc= new GestionContratos();
		gp=new GestionProductos();
		ge= new GestionEjemplares();
		ga= new GestionAlquileres();
		
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
	
	
	public void printInfoProducto(Producto p){
		switch (p.getTipo()){
		case PELICULA : 
			Pelicula pel = (Pelicula)p;
			System.out.println(pel.toString());
			break;
		case MUSICA : 
			Musica mus = (Musica)p;
			System.out.println(mus.toString());
			break;
		case SERIE :
			Serie ser = (Serie)p;
			System.out.println(ser.toString());
			break;
		}
	}
		
	public Producto getProductoEjemplar(int idEjemplar){
		Producto p;
		Ejemplar e = ge.getEjemplar(idEjemplar);
		if (e!=null){
			p= gp.buscarProductoById(e.getProducto());
			if (p!=null) return p;
		}
		return null;
	}
		
	public void marcarEjemplar(int idEjemplar,EstadoEjemplar estado){
		ge.getEjemplar(idEjemplar).setEstado(estado);
	}
	
	
	/*** FICHEROS ***/
	public void load(){
		gs.loadSocios();
		gt.loadTarifas();
		gc.loadContratos();
		gp.loadProductos();
		ge.loadEjemplares();
		ga.loadAlquileres();
	}
	
	public void save(){
		gs.saveSocios();
		gt.saveTarifas();
		gc.saveContratos();
		gp.saveProductos();
		ge.saveEjemplares();
		ga.saveAlquileres();
		
	}
	public void reset(){
		gs.resetSocios();
		gc.resetContratos();
		gp.resetProductos();
		gp.resetCategorias();
		ge.resetEjemplares();
		ga.resetAlquileres();
	}
}
