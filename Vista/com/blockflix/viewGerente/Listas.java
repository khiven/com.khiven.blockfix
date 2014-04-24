package com.blockflix.viewGerente;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.blockflix.src.Main;
import com.blockflix.src.productos.Musica;
import com.blockflix.src.productos.Pelicula;
import com.blockflix.src.productos.Serie;
import com.blockflix.src.socios.Socio;

public class Listas extends JPanel{
	
	public void JPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		String[] titulos = {"Nombre","Numero","Cantidad"};
		Object[][] filas = {};
		DefaultTableModel modeloDatos = new DefaultTableModel(filas, titulos); 
		JTable tMorosos = new JTable(modeloDatos);
		ArrayList<Socio> morosos = Main.ger.gs.getListaMorosos();
		for(Socio socio : morosos){
			Object[] fila = {socio.getNombre(),socio.getnSocio(),socio.getSancion()};
			modeloDatos.addRow(fila);
		}
		this.add(tMorosos);
		String[] titulos2 = {"Posición","Nombre","ID","Alquileres"};
		DefaultTableModel modeloDatos2 = new DefaultTableModel(filas, titulos);
		JTable tPeliculas = new JTable(modeloDatos2);
		ArrayList<Pelicula> peliculas = Main.ger.gp.getTop10Peliculas();
		int i=1;
		for(Pelicula pelicula : peliculas){
			Object[] fila = {i,pelicula.getNombre(),pelicula.getId(),pelicula.getVecesAlquilado()};
			modeloDatos.addRow(fila);
			i++;
		}
		String[] titulos3 = {"Posición","Nombre","ID","Alquileres"};
		DefaultTableModel modeloDatos3 = new DefaultTableModel(filas, titulos);
		JTable tSeries = new JTable(modeloDatos2);
		ArrayList<Serie> series = Main.ger.gp.getTop10Series();
		i=1;
		for(Serie serie : series){
			Object[] fila = {i,serie.getNombre(),serie.getId(),serie.getVecesAlquilado()};
			modeloDatos.addRow(fila);
			i++;
		}
		String[] titulos4 = {"Posición","Nombre","ID","Alquileres"};
		DefaultTableModel modeloDatos4 = new DefaultTableModel(filas, titulos);
		JTable tMusica = new JTable(modeloDatos2);
		ArrayList<Musica> musicas = Main.ger.gp.getTop10Musica();
		i=1;
		for(Musica musica : musicas){
			Object[] fila = {i,musica.getNombre(),musica.getId(),musica.getVecesAlquilado()};
			modeloDatos.addRow(fila);
			i++;
		}
		
	}

}
