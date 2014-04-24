package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.viewGerente.AnadirProducto;

public class ControlAnadir implements ActionListener {
	private JButton bModificar;
	private JButton bCerrar;
	private AnadirProducto frame;
	private Constantes.Soporte soporte;
	
	public ControlAnadir(JButton bModificar, JButton bCerrar, AnadirProducto frame){
		this.bModificar = bModificar;
		this.bCerrar = bCerrar;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bModificar && frame.getTitulo()!=null && frame.getPrimero()!=null && frame.getSegundo()!=null){
			switch(frame.getSoporteSeleccionado()){
			case "DVD":
				soporte=Constantes.Soporte.DVD;
				break;
			case "BLURAY":
				soporte=Constantes.Soporte.BLURAY;
				break;
			case "CD":
				soporte=Constantes.Soporte.CD;
				break;
			case "VINILO":
				soporte=Constantes.Soporte.VINILO;
				break;
			}
			switch(frame.getTipoSeleccionado()){
			case "Peliculas":
				Main.ger.gp.addPelicula(frame.getTitulo(), Integer.parseInt(frame.getSegundo()), frame.getPrimero(), frame.getCategoriaSeleccionada(), soporte);
				break;
			case "Series":
				Main.ger.gp.addSerie(frame.getTitulo(), Integer.parseInt(frame.getPrimero()), Integer.parseInt(frame.getSegundo()), frame.getCategoriaSeleccionada(), soporte);
				break;
			case "Musica":
				Main.ger.gp.addMusica(frame.getTitulo(), Integer.parseInt(frame.getSegundo()), frame.getPrimero(), frame.getCategoriaSeleccionada(), soporte);
				break;
			}
		}
		else if(e.getSource()==bCerrar){
			frame.dispose();
		}
		
	}

}
