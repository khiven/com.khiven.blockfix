package com.blockflix.viewGerente;

import java.awt.GridBagConstraints;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.blockflix.src.constantes.Constantes;

public class GestionVariables extends JPanel {
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
	private GerentePanel gpanel;
	private GestionVariables gvariables = this;
	
	public GestionVariables(GerentePanel gpanel){
		this.setGpanel(gpanel);
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
		aNombre2.setEditable(false);
		aPrecioAlquilerPelicula.setEditable(false);
		aPrecioAlquilerPelicula2.setEditable(false);
		aPrecioAlquilerSerie.setEditable(false);
		aPrecioAlquilerSerie2.setEditable(false);
		aPrecioAlquilerMusica.setEditable(false);
		aPrecioAlquilerMusica2.setEditable(false);
		aPenalizacionPorSancion.setEditable(false);
		aPenalizacionPorSancion2.setEditable(false);
		aPlazoDePagoDeLaSancion.setEditable(false);
		aPlazoDePagoDeLaSancion2.setEditable(false);
		aPlazoDeDevolucionAlquiler.setEditable(false);
		aPlazoDeDevolucionAlquiler2.setEditable(false);
		aPrecioTarifaPlanaPeliculas.setEditable(false);
		aPrecioTarifaPlanaPeliculas2.setEditable(false);
		aPrecioTarifaPlanaSeries.setEditable(false);
		aPrecioTarifaPlanaSeries2.setEditable(false);
		aPrecioTarifaPlanaMusica.setEditable(false);
		aPrecioTarifaPlanaMusica2.setEditable(false);
		aPrecioTarifaPlanaPeliculasSeries.setEditable(false);
		aPrecioTarifaPlanaPeliculasSeries2.setEditable(false);
		aPrecioTarifaPlanaPeliculasMusica.setEditable(false);
		aPrecioTarifaPlanaPeliculasMusica2.setEditable(false);
		aPrecioTarifaPlanaSeriesMusica.setEditable(false);
		aPrecioTarifaPlanaSeriesMusica2.setEditable(false);
		aPrecioTarifaPlanaPremium.setEditable(false);
		aPrecioTarifaPlanaPremium2.setEditable(false);
		aDuracionTarifasPlanas.setEditable(false);
		aDuracionTarifasPlanas2.setEditable(false);
		aPrecioSuplementoExtensionDeTiempo.setEditable(false);
		aPrecioSuplementoExtensionDeTiempo2.setEditable(false);
		aDuracionExtensionDeTiempo.setEditable(false);
		aDuracionExtensionDeTiempo2.setEditable(false);

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		this.add(aGestion, c);
		c.gridx=0;
		c.gridy=1;
		this.add(aNombre, c);
		c.gridx=1;
		this.add(aNombre2, c);
		c.gridx=0;
		c.gridy=2;
		this.add(aPrecioAlquilerPelicula, c);
		c.gridx=1;
		this.add(aPrecioAlquilerPelicula2, c);
		c.gridx=0;
		c.gridy=3;
		this.add(aPrecioAlquilerSerie, c);
		c.gridx=1;
		this.add(aPrecioAlquilerSerie2, c);
		c.gridx=0;
		c.gridy=4;
		this.add(aPrecioAlquilerMusica, c);
		c.gridx=1;
		this.add(aPrecioAlquilerMusica2, c);
		c.gridx=0;
		c.gridy=5;
		this.add(aPenalizacionPorSancion, c);
		c.gridx=1;
		this.add(aPenalizacionPorSancion2, c);
		c.gridx=0;
		c.gridy=6;
		this.add(aPlazoDePagoDeLaSancion, c);
		c.gridx=1;
		this.add(aPlazoDePagoDeLaSancion2, c);
		c.gridx=0;
		c.gridy=7;
		this.add(aPlazoDeDevolucionAlquiler, c);
		c.gridx=1;
		this.add(aPlazoDeDevolucionAlquiler2, c);
		c.gridx=0;
		c.gridy=8;
		this.add(aPrecioTarifaPlanaPeliculas, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaPeliculas2, c);
		c.gridx=0;
		c.gridy=9;
		this.add(aPrecioTarifaPlanaSeries, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaSeries2, c);
		c.gridx=0;
		c.gridy=10;
		this.add(aPrecioTarifaPlanaPeliculasSeries, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaPeliculasSeries2, c);
		c.gridx=0;
		c.gridy=11;
		this.add(aPrecioTarifaPlanaPeliculasMusica, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaPeliculasMusica2, c);
		c.gridx=0;
		c.gridy=12;
		this.add(aPrecioTarifaPlanaSeriesMusica, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaSeriesMusica2, c);
		c.gridx=0;
		c.gridy=13;
		this.add(aPrecioTarifaPlanaPremium, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaPremium2, c);
		c.gridx=0;
		c.gridy=14;
		this.add(aPrecioTarifaPlanaMusica, c);
		c.gridx=1;
		this.add(aPrecioTarifaPlanaMusica2, c);
		c.gridx=0;
		c.gridy=15;
		this.add(aDuracionTarifasPlanas, c);
		c.gridx=1;
		this.add(aDuracionTarifasPlanas2, c);
		c.gridx=0;
		c.gridy=16;
		this.add(aPrecioSuplementoExtensionDeTiempo, c);
		c.gridx=1;
		this.add(aPrecioSuplementoExtensionDeTiempo2, c);
		c.gridx=0;
		c.gridy=17;
		this.add(aDuracionExtensionDeTiempo, c);
		c.gridx=1;
		this.add(aDuracionExtensionDeTiempo2, c);
		c.gridx=0;
		c.gridy=18;
		this.add(bModificar,c);
		bModificar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ModificarVariables modificar = new ModificarVariables(gvariables.getGpanel(),gvariables);
				modificar.setVisible(true);
			}
		});
	}

	public GerentePanel getGpanel() {
		return gpanel;
	}

	public void setGpanel(GerentePanel gpanel) {
		this.gpanel = gpanel;
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

}
