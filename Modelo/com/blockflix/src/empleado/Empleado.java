package com.blockflix.src.empleado;

import java.util.ArrayList;
import java.util.Calendar;

import org.visa.tpv.PasarelaDePago;
import org.visa.tpv.excepciones.ExcepcionVISA;

import com.blockflix.src.alquiler.Alquiler;
import com.blockflix.src.alquiler.GestionAlquileres;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.constantes.Constantes.EstadoEjemplar;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.src.contratos.Contrato;
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
import com.blockflix.src.tarifas.Tarifa;

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

	public boolean pagar(String nTarjeta,String password,double cuantia){
		PasarelaDePago p = PasarelaDePago.getPasarela();
		try {
			p.pagar(nTarjeta, password, cuantia);
		} catch (ExcepcionVISA e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

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

	public ArrayList<Producto> getProductosAlquiler (ArrayList<Integer> listaEjemplares){
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		for (Integer i :listaEjemplares){
			listaProductos.add(getProductoEjemplar(i));
		}
		return listaProductos;
	}

	public void marcarEjemplar(int idEjemplar,EstadoEjemplar estado){
		ge.getEjemplar(idEjemplar).setEstado(estado);
	}



	/*************************** ALQUILERES ******************************/

	public void alquilar(int nSocio, ArrayList<Producto> listaProductos){
		Contrato c;
		boolean pagoCorrecto=true;
		//Comprobamos que existe el socio
		if (gs.buscarSocio(nSocio)==null){
			System.out.println("\nEl nº de socio indicado no pertenece al sistema...");
			return;
		}


		//Comprobamos que el socio no tenga sancion
		if (gs.isSocioSancionado(nSocio)){
			System.out.println("\nNo se puede realizar el alquiler, socio sancionado... ");
			return;
		}
		//Comprobamos que el socio no tiene alquileres
		if (ga.tieneAlquileres(nSocio)){
			System.out.println("\n El socio tiene alquileres pendientes de devolver...");
			return;
		}

		//Comprobamos que el numero de productos no sea mayor al estipulado
		if (listaProductos.size()>Constantes.variables.MAX_ALQUILERES){
			System.out.println("\n No pueden seleccionar mas de "+Constantes.variables.MAX_ALQUILERES+"productos...");
			return;
		}

		//Comprobamos disponibilidad de ejemplares de los productos seleccionados
		for (Producto p : listaProductos){
			if (ge.buscarEjemplaresDisponiblesProducto(p.getId()).isEmpty()){
				System.out.println("\n No hay ejemplares disponibles del producto con id "+p.getId());
				return;
			}			
		}

		//Socio no sancionado y ejemplares disponibles de todos los productos, se procede a pagar antes de finalizar el alquiler

		//Si el socio no tiene contrato o el contrato no cubre el alquiler necesita pagar
		if ( (c=gc.getContratoSocio(nSocio)) == null || necesitaPagarAlquiler(c,listaProductos)){

			//Se paga, se supone que el pago se va a realizar correctamente
			System.out.println("\nSu tarifa no cubre los productos seleccionados. Realizando pago con tarjeta, son "+calcularCuantiaAlquiler(listaProductos)+"euros...");
			pagoCorrecto=pagar("123456789012", "1234", calcularCuantiaAlquiler(listaProductos));			
		}
		else System.out.println("\n Su tarifa contratada cubre los productos, no necesita pagar...");
		if (pagoCorrecto){
			//Si se ha llegado aqui se cumplen todas las condiciones para el alquiler y se procede a realizarse
			ga.addAlquiler(nSocio, ge.retirarEjemplaresAlquiler(listaProductos));
			gp.incrementarAlquilerProductos(listaProductos);
			System.out.println("\nAlquiler realizado satisfactoriamente");
		}
		else System.out.println("\n Error con el pago, cancelando alquiler...");

	}


	public void devolverAlquiler(int nSocio){
		Alquiler a;
		Contrato c;

		int diasPermitidos=Constantes.variables.DURACION_ALQUILER;
		double cuantiaSancion = 0;

		//Comprobamos que existe el socio
		if (gs.buscarSocio(nSocio)==null){
			System.out.println("\nEl nº de socio indicado no pertenece al sistema...");
			return;
		}

		//Comprobamos que el socio tiene un alquiler
		if (!ga.tieneAlquileres(nSocio)){
			System.out.println("\n El socio indicado no tiene alquileres");
			return;
		}
		a=ga.getAlquiler(nSocio);
		// Comprobamos si uso la tarifa
		if ( (c=gc.getContratoSocio(nSocio))!= null && checkTarifa(c.getTarifa(), getProductosAlquiler(a.getEjemplares()))){
			//Uso la tarifa, ahora vemos si tiene dias extra
			if (c.getExtTiempo()){
				//Tiene extension de tiempo la sumamos a los dias permitidos
				diasPermitidos+=gt.getTarifaByTipo(c.getTarifa()).getTiempoExtension();
			}
		}
		// Ahora tenemos los dias permitidos para el alquiler en funcion de si uso tarifa o no y si tenia contratada la extension 
		// Comprobamos si se le sanciona y la cuantia
		if ((cuantiaSancion=calcularSancion(a.getFechaInicio(),diasPermitidos))!=0){
			//Se le sanciona
			gs.sancionarSocio(nSocio, cuantiaSancion);
			System.out.println("\n Retraso en la devolucion, socio sancionado");
		}

		//Ahora se devuelven los ejemplares
		ge.devolverEjemplares(a.getEjemplares());
		//Y se elimina el alquiler
		ga.removeAlquiler(nSocio);
		System.out.println("\n Alquiler devuelto satisfactoriamente");

	}

	public void pagarSancionSocio(int nSocio){
		if(pagar("123456789012","1234",gs.buscarSocio(nSocio).getSancion()))
			gs.eliminarSancion(nSocio);
	}

	public double calcularSancion(Calendar fechaInicio,int diasPermitidos){
		Calendar fechaHoy = Calendar.getInstance();
		int diasTranscurridos = daysBetween(fechaInicio, fechaHoy);
		if (diasTranscurridos > diasPermitidos)
			return Constantes.variables.SANCION_POR_DIA*(diasTranscurridos-diasPermitidos);
		else return 0;

	}


	/**
	 * Comprueba si los productos a alquilar coinciden con la tarifa del socio y que esta no esté caducada, en caso contrario
	 * necesitara pagar
	 * @param c Contrato del socio
	 * @param tarifa Tarifa del socio
	 * @param listaProductos Productos a alquilar
	 * @return Devuelve True si necesita pagar o false si su tarifa cubre los productos a alquilar
	 */
	public boolean necesitaPagarAlquiler(Contrato c,ArrayList<Producto> listaProductos){
		return (!checkTarifa(c.getTarifa(),listaProductos) || isTarifaCaducada(c));
	}


	public boolean checkTarifa(TipoTarifa tarifaSocio,ArrayList<Producto> listaProductos){
		//Si tiene tarifa premium esta OK

		boolean ok = true;
		if (tarifaSocio == TipoTarifa.PREMIUM){
			return ok;
		}
		//Si no comprobamos los productos a alquilar y la tarifa contratada
		else{

			for (Producto p : listaProductos){
				switch (tarifaSocio){
				case PELICULAS:

					if (p.getTipo()!=TipoProducto.PELICULA)
						ok= false;	
					break;
				case MUSICA :
					System.out.println("DEBUG: WTF");
					if (p.getTipo()!= TipoProducto.MUSICA)
						ok= false;
					break;
				case SERIES:

					if (p.getTipo()!= TipoProducto.SERIE)
						ok= false;
					break;
				case PELICULAS_SERIES :

					if (p.getTipo()!=TipoProducto.PELICULA && p.getTipo()!=TipoProducto.SERIE)
						ok= false;
					break;
				case PELICULAS_MUSICA :

					if (p.getTipo()!=TipoProducto.PELICULA && p.getTipo()!=TipoProducto.MUSICA)
						ok= false;
					break;
				case SERIES_MUSICA :

					if (p.getTipo()!=TipoProducto.SERIE && p.getTipo()!=TipoProducto.MUSICA)
						ok= false;
					break;
				case PREMIUM :

					break;
				}
			}
			//Si sale del for y no ha habido ninguna incompatibilidad, todo OK

			return ok;
		}

	}

	public boolean isTarifaCaducada(Contrato c){
		Tarifa t = gt.getTarifaByTipo(c.getTarifa());
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaFinContrato = (Calendar)c.getFechaInicio().clone();


		//A la fecha de inicio del contrato le sumamos la duracion de la tarifa = fecha fin contrato
		fechaFinContrato.add(Calendar.DAY_OF_MONTH, t.getTiempo());
		//Si la fecha actual es posterior a la fecha de fin de contrato, el contrato está caducado
		if (fechaActual.after(fechaFinContrato)){
			//Tarifa caducada
			return true;
		}

		//Tarifa no caducada.

		return false;
	}

	public double calcularCuantiaAlquiler(ArrayList<Producto> listaProductos){
		double cuantia = 0;
		for (Producto p : listaProductos){
			switch (p.getTipo()){
			case PELICULA:
				cuantia+=Constantes.variables.PRECIO_ALQUILER_PELICULA;
				break;
			case SERIE :
				cuantia+=Constantes.variables.PRECIO_ALQUILER_SERIE;
				break;
			case MUSICA:
				cuantia+=Constantes.variables.PRECIO_ALQUILER_MUSICA;
				break;
			}
		}
		return cuantia;
	}


	/**************** CONTRATOS *****************/

	public void contratarTarifaSocio(int nSocio,TipoTarifa tarifa,boolean extension){

		
		

		

		//Finalmente se añade el nuevo contrato

		gc.contratarTarifa(nSocio, tarifa, extension);


	}

	public void eliminarContratosObsoletos(){
		for (Contrato c : gc.listaContratos){
			if (isTarifaCaducada(c))
				gc.listaContratos.remove(c);
		}
	}


	/*************** FECHAS *******************/

	public static int daysBetween(Calendar startDate, Calendar endDate) {  
		Calendar date = (Calendar) startDate.clone();  
		int daysBetween = 0;  
		while (date.before(endDate)) {  
			date.add(Calendar.DAY_OF_MONTH, 1);  
			daysBetween++;  
		}  
		return daysBetween;  
	}  




	public void salir(){
		save();

	}

	/*** FICHEROS ***/
	public void load(){
		gs.reloadSocios();
		gt.reloadTarifas();
		gc.reloadContratos();
		gp.loadProductos();
		gp.loadCategorias();
		ge.reloadEjemplares();
		ga.reloadAlquileres();
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
