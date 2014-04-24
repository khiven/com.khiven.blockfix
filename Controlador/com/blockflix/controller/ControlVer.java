package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.blockflix.src.Main;
import com.blockflix.src.productos.Producto;
import com.blockflix.viewGerente.AnadirProducto;
import com.blockflix.viewGerente.GerentePanel;
import com.blockflix.viewGerente.ModificarProducto;

public class ControlVer implements ActionListener {
	
	private JButton bModificar;
	private JButton bEliminar;
	private Producto producto;
	private GerentePanel gpanel;

	public ControlVer(JButton bModificar, JButton bEliminar, Producto p, GerentePanel gpanel){
		this.bModificar=bModificar;
		this.bEliminar=bEliminar;
		this.producto = p;
		this.gpanel = gpanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = ((JButton)e.getSource());
		if (source==bEliminar){
			switch(producto.getTipo().toString()){
			case "Pelicula":
				Main.ger.gp.eliminarPelicula(producto.getId());
				break;
			case "Serie":
				Main.ger.gp.eliminarSerie(producto.getId());
				break;
			case "Musica":
				Main.ger.gp.eliminarMusica(producto.getId());
				break;
			}
		source.getParent().setVisible(false);
		source.getParent().removeAll();
		gpanel.setVisible(true);
		}
		else if (source==bModificar){
			ModificarProducto anadir = new ModificarProducto(producto);
			anadir.setVisible(true);
		}
		else{
			source.getParent().setVisible(false);
			source.getParent().removeAll();
			gpanel.setVisible(true);
		}
	}

}
