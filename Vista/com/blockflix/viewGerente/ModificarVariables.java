package com.blockflix.viewGerente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.blockflix.controller.ControlModificarVariables;
import com.blockflix.src.constantes.Constantes;

public class ModificarVariables extends JFrame {
	private JTextArea aNombre;
	private JTextArea aPrecioAlquilerPelicula;
	private JTextArea aPrecioAlquilerSerie;
	private JTextArea aPrecioAlquilerMusica;
	private JTextArea aPenalizacionPorSancion;
	private JTextArea aPlazoDePagoDeLaSancion;
	private JTextArea aPlazoDeDevolucionAlquiler;
	private JTextArea aPrecioTarifaPlanaPeliculas;
	private JTextArea aPrecioTarifaPlanaSeries;
	private JTextArea aPrecioTarifaPlanaMusica;
	private JTextArea aPrecioTarifaPlanaPeliculasSeries;
	private JTextArea aPrecioTarifaPlanaPeliculasMusica;
	private JTextArea aPrecioTarifaPlanaSeriesMusica;
	private JTextArea aPrecioTarifaPlanaPremium;
	private JTextArea aDuracionTarifasPlanas;
	private JTextArea aPrecioSuplementoExtensionDeTiempo;
	private JTextArea aDuracionExtensionDeTiempo;
	private ModificarVariables frame = this;
	private GerentePanel gpanel;
	private GestionVariables gvariables;
	
	public ModificarVariables(GerentePanel gpanel,GestionVariables gvariables){
		this.setGpanel(gpanel);
		this.setGvariables(gvariables);
		JTextArea aGestion = new JTextArea("Gestión de variables del sistema");
		JTextArea aNombre = new JTextArea("Nombre del Videoclub:");
		JTextArea aNombre2 = new JTextArea(Constantes.variables.NOMBRE_VIDEOCLUB);
		JTextArea aPrecioAlquilerPelicula = new JTextArea("Precio Alquiler Pelicula(euro):");
		JTextArea aPrecioAlquilerPelicula2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_ALQUILER_PELICULA));
		JTextArea aPrecioAlquilerSerie = new JTextArea("Precio Alquiler Serie(euro):");
		JTextArea aPrecioAlquilerSerie2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_ALQUILER_SERIE));
		JTextArea aPrecioAlquilerMusica = new JTextArea("Precio Alquiler Musica(euro):");
		JTextArea aPrecioAlquilerMusica2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_ALQUILER_MUSICA));
		JTextArea aPenalizacionPorSancion = new JTextArea("Penalización por sanción (euros día):");
		JTextArea aPenalizacionPorSancion2 = new JTextArea(String.valueOf(Constantes.variables.SANCION_POR_DIA));
		JTextArea aPlazoDePagoDeLaSancion = new JTextArea("Plazo de pago de la sanción (días):");
		JTextArea aPlazoDePagoDeLaSancion2 = new JTextArea(String.valueOf(Constantes.variables.PLAZO_PAGO_SANCION));
		JTextArea aPlazoDeDevolucionAlquiler = new JTextArea("Plazo de devolución del alquiler (días):");
		JTextArea aPlazoDeDevolucionAlquiler2 = new JTextArea(String.valueOf(Constantes.variables.DURACION_ALQUILER));
		JTextArea aPrecioTarifaPlanaPeliculas = new JTextArea("Precio tarifa plana de películas (euros):");
		JTextArea aPrecioTarifaPlanaPeliculas2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_PELICULAS));
		JTextArea aPrecioTarifaPlanaSeries = new JTextArea("Precio tarifa plana de series (euros):");
		JTextArea aPrecioTarifaPlanaSeries2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_SERIES));
		JTextArea aPrecioTarifaPlanaMusica = new JTextArea("Precio tarifa plana de música (euros):");
		JTextArea aPrecioTarifaPlanaMusica2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_MUSICA));
		JTextArea aPrecioTarifaPlanaPeliculasSeries = new JTextArea("Precio tarifa plana de películas y series (euros):");
		JTextArea aPrecioTarifaPlanaPeliculasSeries2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_PELICULASSERIES));
		JTextArea aPrecioTarifaPlanaPeliculasMusica = new JTextArea("Precio tarifa plana de películas y música (euros):");
		JTextArea aPrecioTarifaPlanaPeliculasMusica2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_PELICULASMUSICA));
		JTextArea aPrecioTarifaPlanaSeriesMusica = new JTextArea("Precio tarifa plana de series y música (euros):");
		JTextArea aPrecioTarifaPlanaSeriesMusica2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_MUSICASERIES));
		JTextArea aPrecioTarifaPlanaPremium = new JTextArea("Precio tarifa plana premium (euros):");
		JTextArea aPrecioTarifaPlanaPremium2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_TARIFA_PREMIUM));
		JTextArea aDuracionTarifasPlanas = new JTextArea("Duración tarifas planas (días):");
		JTextArea aDuracionTarifasPlanas2 = new JTextArea(String.valueOf(Constantes.variables.DURACION_TARIFA));
		JTextArea aPrecioSuplementoExtensionDeTiempo = new JTextArea("Precio suplemento extension de tiempo (euros):");
		JTextArea aPrecioSuplementoExtensionDeTiempo2 = new JTextArea(String.valueOf(Constantes.variables.PRECIO_SUPLEMENTO));
		JTextArea aDuracionExtensionDeTiempo = new JTextArea("Duración extension de tiempo (día por alquiler):");
		JTextArea aDuracionExtensionDeTiempo2 = new JTextArea(String.valueOf(Constantes.variables.DURACION_SUPLEMENTO));
		JButton bModificar = new JButton("Modificar valores");
		JButton bCerrar = new JButton("Cerrar");
		this.setaDuracionExtensionDeTiempo(aDuracionExtensionDeTiempo2);
		this.setaDuracionTarifasPlanas(aDuracionTarifasPlanas2);
		this.setaNombre(aNombre2);
		this.setaPenalizacionPorSancion(aPenalizacionPorSancion2);
		this.setaPlazoDeDevolucionAlquiler(aPlazoDeDevolucionAlquiler2);
		this.setaPlazoDePagoDeLaSancion(aPlazoDePagoDeLaSancion2);
		this.setaPrecioAlquilerMusica(aPrecioAlquilerMusica2);
		this.setaPrecioAlquilerPelicula(aPrecioAlquilerPelicula2);
		this.setaPrecioAlquilerSerie(aPrecioAlquilerSerie2);
		this.setaPrecioSuplementoExtensionDeTiempo(aPrecioSuplementoExtensionDeTiempo2);
		this.setaPrecioTarifaPlanaMusica(aPrecioTarifaPlanaMusica2);
		this.setaPrecioTarifaPlanaPeliculas(aPrecioTarifaPlanaPeliculas2);
		this.setaPrecioTarifaPlanaPeliculasMusica(aPrecioTarifaPlanaPeliculasMusica2);
		this.setaPrecioTarifaPlanaPeliculasSeries(aPrecioTarifaPlanaPeliculasSeries2);
		this.setaPrecioTarifaPlanaPremium(aPrecioTarifaPlanaPremium2);
		this.setaPrecioTarifaPlanaSeries(aPrecioTarifaPlanaSeries2);
		this.setaPrecioTarifaPlanaSeriesMusica(aPrecioTarifaPlanaSeriesMusica2);

		aGestion.setEditable(false);
		aNombre.setEditable(false);
		aPrecioAlquilerPelicula.setEditable(false);
		aPrecioAlquilerSerie.setEditable(false);
		aPrecioAlquilerMusica.setEditable(false);
		aPenalizacionPorSancion.setEditable(false);
		aPlazoDePagoDeLaSancion.setEditable(false);
		aPlazoDeDevolucionAlquiler.setEditable(false);
		aPrecioTarifaPlanaPeliculas.setEditable(false);
		aPrecioTarifaPlanaSeries.setEditable(false);
		aPrecioTarifaPlanaMusica.setEditable(false);
		aPrecioTarifaPlanaPeliculasSeries.setEditable(false);
		aPrecioTarifaPlanaPeliculasMusica.setEditable(false);
		aPrecioTarifaPlanaSeriesMusica.setEditable(false);
		aPrecioTarifaPlanaPremium.setEditable(false);
		aDuracionTarifasPlanas.setEditable(false);
		aPrecioSuplementoExtensionDeTiempo.setEditable(false);
		aDuracionExtensionDeTiempo.setEditable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		panel.add(aGestion, c);
		c.gridx=0;
		c.gridy=1;
		panel.add(aNombre, c);
		c.gridx=1;
		panel.add(aNombre2, c);
		c.gridx=0;
		c.gridy=2;
		panel.add(aPrecioAlquilerPelicula, c);
		c.gridx=1;
		panel.add(aPrecioAlquilerPelicula2, c);
		c.gridx=0;
		c.gridy=3;
		panel.add(aPrecioAlquilerSerie, c);
		c.gridx=1;
		panel.add(aPrecioAlquilerSerie2, c);
		c.gridx=0;
		c.gridy=4;
		panel.add(aPrecioAlquilerMusica, c);
		c.gridx=1;
		panel.add(aPrecioAlquilerMusica2, c);
		c.gridx=0;
		c.gridy=5;
		panel.add(aPenalizacionPorSancion, c);
		c.gridx=1;
		panel.add(aPenalizacionPorSancion2, c);
		c.gridx=0;
		c.gridy=6;
		panel.add(aPlazoDePagoDeLaSancion, c);
		c.gridx=1;
		panel.add(aPlazoDePagoDeLaSancion2, c);
		c.gridx=0;
		c.gridy=7;
		panel.add(aPlazoDeDevolucionAlquiler, c);
		c.gridx=1;
		panel.add(aPlazoDeDevolucionAlquiler2, c);
		c.gridx=0;
		c.gridy=8;
		panel.add(aPrecioTarifaPlanaPeliculas, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaPeliculas2, c);
		c.gridx=0;
		c.gridy=9;
		panel.add(aPrecioTarifaPlanaSeries, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaSeries2, c);
		c.gridx=0;
		c.gridy=10;
		panel.add(aPrecioTarifaPlanaPeliculasSeries, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaPeliculasSeries2, c);
		c.gridx=0;
		c.gridy=11;
		panel.add(aPrecioTarifaPlanaPeliculasMusica, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaPeliculasMusica2, c);
		c.gridx=0;
		c.gridy=12;
		panel.add(aPrecioTarifaPlanaSeriesMusica, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaSeriesMusica2, c);
		c.gridx=0;
		c.gridy=13;
		panel.add(aPrecioTarifaPlanaPremium, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaPremium2, c);
		c.gridx=0;
		c.gridy=14;
		panel.add(aPrecioTarifaPlanaMusica, c);
		c.gridx=1;
		panel.add(aPrecioTarifaPlanaMusica2, c);
		c.gridx=0;
		c.gridy=15;
		panel.add(aDuracionTarifasPlanas, c);
		c.gridx=1;
		panel.add(aDuracionTarifasPlanas2, c);
		c.gridx=0;
		c.gridy=16;
		panel.add(aPrecioSuplementoExtensionDeTiempo, c);
		c.gridx=1;
		panel.add(aPrecioSuplementoExtensionDeTiempo2, c);
		c.gridx=0;
		c.gridy=17;
		panel.add(aDuracionExtensionDeTiempo, c);
		c.gridx=1;
		panel.add(aDuracionExtensionDeTiempo2, c);
		c.gridx=0;
		c.gridy=18;
		panel.add(bModificar,c);
		c.gridx=1;
		panel.add(bCerrar,c);
		
		this.add(panel);
		this.setSize(new Dimension(400,600));
		this.setResizable(false);
		panel.setVisible(true);
		bModificar.addActionListener(new ControlModificarVariables(this));
		bCerrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getGpanel().setVisible(false);
				frame.getGpanel().setVisible(true);
				frame.dispose();
			}
			
		});
	}

	public JTextArea getaNombre() {
		return aNombre;
	}

	public void setaNombre(JTextArea aNombre) {
		this.aNombre = aNombre;
	}

	public JTextArea getaPrecioAlquilerPelicula() {
		return aPrecioAlquilerPelicula;
	}

	public void setaPrecioAlquilerPelicula(JTextArea aPrecioAlquilerPelicula) {
		this.aPrecioAlquilerPelicula = aPrecioAlquilerPelicula;
	}

	public JTextArea getaPrecioAlquilerSerie() {
		return aPrecioAlquilerSerie;
	}

	public void setaPrecioAlquilerSerie(JTextArea aPrecioAlquilerSerie) {
		this.aPrecioAlquilerSerie = aPrecioAlquilerSerie;
	}

	public JTextArea getaPrecioAlquilerMusica() {
		return aPrecioAlquilerMusica;
	}

	public void setaPrecioAlquilerMusica(JTextArea aPrecioAlquilerMusica) {
		this.aPrecioAlquilerMusica = aPrecioAlquilerMusica;
	}

	public JTextArea getaPenalizacionPorSancion() {
		return aPenalizacionPorSancion;
	}

	public void setaPenalizacionPorSancion(JTextArea aPenalizacionPorSancion) {
		this.aPenalizacionPorSancion = aPenalizacionPorSancion;
	}

	public JTextArea getaPlazoDePagoDeLaSancion() {
		return aPlazoDePagoDeLaSancion;
	}

	public void setaPlazoDePagoDeLaSancion(JTextArea aPlazoDePagoDeLaSancion) {
		this.aPlazoDePagoDeLaSancion = aPlazoDePagoDeLaSancion;
	}

	public JTextArea getaPlazoDeDevolucionAlquiler() {
		return aPlazoDeDevolucionAlquiler;
	}

	public void setaPlazoDeDevolucionAlquiler(JTextArea aPlazoDeDevolucionAlquiler) {
		this.aPlazoDeDevolucionAlquiler = aPlazoDeDevolucionAlquiler;
	}

	public JTextArea getaPrecioTarifaPlanaPeliculas() {
		return aPrecioTarifaPlanaPeliculas;
	}

	public void setaPrecioTarifaPlanaPeliculas(
			JTextArea aPrecioTarifaPlanaPeliculas) {
		this.aPrecioTarifaPlanaPeliculas = aPrecioTarifaPlanaPeliculas;
	}

	public JTextArea getaPrecioTarifaPlanaSeries() {
		return aPrecioTarifaPlanaSeries;
	}

	public void setaPrecioTarifaPlanaSeries(JTextArea aPrecioTarifaPlanaSeries) {
		this.aPrecioTarifaPlanaSeries = aPrecioTarifaPlanaSeries;
	}

	public JTextArea getaPrecioTarifaPlanaMusica() {
		return aPrecioTarifaPlanaMusica;
	}

	public void setaPrecioTarifaPlanaMusica(JTextArea aPrecioTarifaPlanaMusica) {
		this.aPrecioTarifaPlanaMusica = aPrecioTarifaPlanaMusica;
	}

	public JTextArea getaPrecioTarifaPlanaPeliculasSeries() {
		return aPrecioTarifaPlanaPeliculasSeries;
	}

	public void setaPrecioTarifaPlanaPeliculasSeries(
			JTextArea aPrecioTarifaPlanaPeliculasSeries) {
		this.aPrecioTarifaPlanaPeliculasSeries = aPrecioTarifaPlanaPeliculasSeries;
	}

	public JTextArea getaPrecioTarifaPlanaPeliculasMusica() {
		return aPrecioTarifaPlanaPeliculasMusica;
	}

	public void setaPrecioTarifaPlanaPeliculasMusica(
			JTextArea aPrecioTarifaPlanaPeliculasMusica) {
		this.aPrecioTarifaPlanaPeliculasMusica = aPrecioTarifaPlanaPeliculasMusica;
	}

	public JTextArea getaPrecioTarifaPlanaSeriesMusica() {
		return aPrecioTarifaPlanaSeriesMusica;
	}

	public void setaPrecioTarifaPlanaSeriesMusica(
			JTextArea aPrecioTarifaPlanaSeriesMusica) {
		this.aPrecioTarifaPlanaSeriesMusica = aPrecioTarifaPlanaSeriesMusica;
	}

	public JTextArea getaPrecioTarifaPlanaPremium() {
		return aPrecioTarifaPlanaPremium;
	}

	public void setaPrecioTarifaPlanaPremium(JTextArea aPrecioTarifaPlanaPremium) {
		this.aPrecioTarifaPlanaPremium = aPrecioTarifaPlanaPremium;
	}

	public JTextArea getaDuracionTarifasPlanas() {
		return aDuracionTarifasPlanas;
	}

	public void setaDuracionTarifasPlanas(JTextArea aDuracionTarifasPlanas) {
		this.aDuracionTarifasPlanas = aDuracionTarifasPlanas;
	}

	public JTextArea getaPrecioSuplementoExtensionDeTiempo() {
		return aPrecioSuplementoExtensionDeTiempo;
	}

	public void setaPrecioSuplementoExtensionDeTiempo(
			JTextArea aPrecioSuplementoExtensionDeTiempo) {
		this.aPrecioSuplementoExtensionDeTiempo = aPrecioSuplementoExtensionDeTiempo;
	}

	public JTextArea getaDuracionExtensionDeTiempo() {
		return aDuracionExtensionDeTiempo;
	}

	public void setaDuracionExtensionDeTiempo(JTextArea aDuracionExtensionDeTiempo) {
		this.aDuracionExtensionDeTiempo = aDuracionExtensionDeTiempo;
	}

	public GerentePanel getGpanel() {
		return gpanel;
	}

	public void setGpanel(GerentePanel gpanel) {
		this.gpanel = gpanel;
	}

	public GestionVariables getGvariables() {
		return gvariables;
	}

	public void setGvariables(GestionVariables gvariables) {
		this.gvariables = gvariables;
	}
}