package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes.TipoTarifa;
import com.blockflix.view.empleado.ContratarTarifaDialog;
import com.blockflix.view.empleado.PagoDialog;

public class ControlContratarTarifaDialog implements ActionListener {
	private ContratarTarifaDialog td;
	private double precioTotal;
	public ControlContratarTarifaDialog(ContratarTarifaDialog td){
		this.td = td;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();
		precioTotal=setPrecioTotal();
		if (cmd.equals(ContratarTarifaDialog.BPAGO)){
			//Se quiere pagar la tarifa seleccionada, se accede a la pasarela
			PagoDialog pd = new PagoDialog(precioTotal);
			pd.setVisible(true);
		}
	}

	public double setPrecioTotal(){
		double precio = 0.0;
		
		if (td.isSuplemento())
			// DE MOMENTO EL PRECIO DE LA EXTENSION NO ES MODIFICABLE 
			precio+=4;
		String tarifa=td.getSelectedTarifa();
		TipoTarifa tipoTarifa=TipoTarifa.PELICULAS;
		//Vemos la tarifa elegida
		if (tarifa.equals(TipoTarifa.PELICULAS.toString())){
			tipoTarifa=TipoTarifa.PELICULAS;
		}
		else if (tarifa.equals(TipoTarifa.SERIES.toString())){
			tipoTarifa=TipoTarifa.SERIES;
		}
		else if (tarifa.equals(TipoTarifa.MUSICA.toString())){
			tipoTarifa=TipoTarifa.MUSICA;
		}
		else if (tarifa.equals(TipoTarifa.PELICULAS_SERIES.toString())){
			tipoTarifa=TipoTarifa.PELICULAS_SERIES;
		}
		else if (tarifa.equals(TipoTarifa.PELICULAS_MUSICA.toString())){
			tipoTarifa=TipoTarifa.PELICULAS_MUSICA;
		}
		else if (tarifa.equals(TipoTarifa.SERIES_MUSICA.toString())){
			tipoTarifa=TipoTarifa.SERIES_MUSICA;
		}
		else if (tarifa.equals(TipoTarifa.PREMIUM.toString())){
			tipoTarifa=TipoTarifa.PREMIUM;
		}
		
		precio+=Main.emp.gt.getTarifaByTipo(tipoTarifa).getPrecio();
		td.setPrecioTotal(Double.toString(precio));
		return precio;
	}
}
