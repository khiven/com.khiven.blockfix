package com.blockflix.controller;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import com.blockflix.src.Main;
import com.blockflix.src.productos.Musica;
import com.blockflix.src.productos.Pelicula;
import com.blockflix.src.productos.Producto;
import com.blockflix.src.productos.Serie;
import com.blockflix.viewGerente.*;

public class ControlGerente implements ActionListener {
	private JButton bBuscar;
	private JButton bAnadir;
	private JButton bVer;
	private Productos ppanel;
	
	public ControlGerente(JButton bBuscar, JButton bAnadir, JButton bVer, Productos ppanel){
		this.bBuscar = bBuscar;
		this.bAnadir = bAnadir;
		this.bVer = bVer;
		this.ppanel = ppanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent c) {
		if (c.getSource() == bBuscar){
			ArrayList<Pelicula> peliculas;
			ArrayList<Musica> musica;
			ArrayList<Serie> series;
			Producto producto;
			while(ppanel.getModeloDatos().getRowCount()>0){
				ppanel.getModeloDatos().removeRow(0);
			}
			ppanel.setVisible(false);
			ppanel.setVisible(true);
			if (ppanel.getTitulo() == null){
				switch(ppanel.getTipoSeleccionado()){
					case "Peliculas" :
						peliculas = Main.ger.gp.buscarPeliculaByCategoria(ppanel.getCategoriaSeleccionada());
						for (Pelicula pelicula : peliculas){
							Object[] fila = {pelicula.getNombre(),pelicula.getTipo(),pelicula.getCategoria(),pelicula.getId()};
							ppanel.getModeloDatos().addRow(fila);
						}
						break;
					case "Series" :
						series = Main.ger.gp.buscarSeriesByCategoria(ppanel.getCategoriaSeleccionada());
						for (Serie serie : series){
							Object[] fila = {serie.getNombre(),serie.getTipo(),serie.getCategoria(),serie.getId()};
							ppanel.getModeloDatos().addRow(fila);
						}
						break;
					case "Musica" :
						musica = Main.ger.gp.buscarMusicaByCategoria(ppanel.getCategoriaSeleccionada());
						for (Musica mus : musica){
							Object[] fila = {mus.getNombre(),mus.getTipo(),mus.getCategoria(),mus.getId()};
							ppanel.getModeloDatos().addRow(fila);
						}
						break;
				}
			}
			else {
				producto = Main.ger.gp.buscarProductoByNombre(ppanel.getTitulo());
				Object[] fila = {producto.getNombre(),producto.getTipo(),producto.getCategoria(),producto.getId()};
				ppanel.getModeloDatos().addRow(fila);
				
			}
			ppanel.setVisible(false);
			ppanel.setVisible(true);
		}
		else if(c.getSource()==bVer){
			
		}
		else if(c.getSource()==bAnadir){
			AnadirProducto anadir = new AnadirProducto();
			anadir.setVisible(true);
		}
	}

}
