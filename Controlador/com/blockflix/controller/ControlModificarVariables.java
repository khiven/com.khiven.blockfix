package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.viewGerente.ModificarVariables;

public class ControlModificarVariables implements ActionListener{
	private ModificarVariables frame;
	
	public ControlModificarVariables(ModificarVariables frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Constantes.variables.setNombreVideoclub(frame.getaNombre().getText());
		Constantes.variables.setPrecioPelicula(Double.parseDouble(frame.getaPrecioAlquilerPelicula().getText()));
		Constantes.variables.setPrecioSerie(Double.parseDouble(frame.getaPrecioAlquilerSerie().getText()));
		Constantes.variables.setPrecioMusica(Double.parseDouble(frame.getaPrecioAlquilerMusica().getText()));
		Constantes.variables.setSancionDia(Double.parseDouble(frame.getaPenalizacionPorSancion().getText()));
		Constantes.variables.setPlazoPagoSancion(Integer.parseInt(frame.getaPlazoDePagoDeLaSancion().getText()));
		Constantes.variables.setDuracionAlquiler(Integer.parseInt(frame.getaPlazoDeDevolucionAlquiler().getText()));
		Constantes.variables.setPrecioTarifaPeliculas(Double.parseDouble(frame.getaPrecioTarifaPlanaPeliculas().getText()));
		Constantes.variables.setPrecioTarifaSeries(Double.parseDouble(frame.getaPrecioTarifaPlanaSeries().getText()));
		Constantes.variables.setPrecioTarifaMusica(Double.parseDouble(frame.getaPrecioTarifaPlanaMusica().getText()));
		Constantes.variables.setPrecioTarifaPeliculasSeries(Double.parseDouble(frame.getaPrecioTarifaPlanaPeliculasSeries().getText()));
		Constantes.variables.setPrecioTarifaPeliculasMusica(Double.parseDouble(frame.getaPrecioTarifaPlanaPeliculasMusica().getText()));
		Constantes.variables.setPrecioTarifaMusicaSeries(Double.parseDouble(frame.getaPrecioTarifaPlanaSeriesMusica().getText()));
		Constantes.variables.setPrecioTarifaPremium(Double.parseDouble(frame.getaPrecioTarifaPlanaPremium().getText()));
		Constantes.variables.setDuracionTarifa(Integer.parseInt(frame.getaDuracionTarifasPlanas().getText()));
		Constantes.variables.setPrecioSuplemento(Double.parseDouble(frame.getaPrecioSuplementoExtensionDeTiempo().getText()));
		Constantes.variables.setDuracionSuplemento(Integer.parseInt(frame.getaDuracionExtensionDeTiempo().getText()));
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.PELICULAS, (float)Constantes.variables.PRECIO_TARIFA_PELICULAS, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.SERIES, (float)Constantes.variables.PRECIO_TARIFA_SERIES, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.MUSICA, (float)Constantes.variables.PRECIO_TARIFA_MUSICA, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.PELICULAS_SERIES, (float)Constantes.variables.PRECIO_TARIFA_PELICULASSERIES, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.PELICULAS_MUSICA, (float)Constantes.variables.PRECIO_TARIFA_PELICULASMUSICA, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.SERIES_MUSICA, (float)Constantes.variables.PRECIO_TARIFA_MUSICASERIES, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);
		Main.ger.gt.modificarTarifa(Constantes.TipoTarifa.PREMIUM, (float)Constantes.variables.PRECIO_TARIFA_PREMIUM, (float)Constantes.variables.PRECIO_SUPLEMENTO, Constantes.variables.DURACION_TARIFA, Constantes.variables.DURACION_SUPLEMENTO);

		frame.getGvariables().getaDuracionExtensionDeTiempo().setText(String.valueOf(Constantes.variables.DURACION_SUPLEMENTO));;
		frame.getGvariables().getaDuracionTarifasPlanas().setText(String.valueOf(Constantes.variables.DURACION_TARIFA));
		frame.getGvariables().getaNombre().setText(Constantes.variables.NOMBRE_VIDEOCLUB);
		frame.getGvariables().getaPenalizacionPorSancion().setText(String.valueOf(Constantes.variables.SANCION_POR_DIA));
		frame.getGvariables().getaPlazoDeDevolucionAlquiler().setText(String.valueOf(Constantes.variables.DURACION_ALQUILER));
		frame.getGvariables().getaPlazoDePagoDeLaSancion().setText(String.valueOf(Constantes.variables.PLAZO_PAGO_SANCION));
		frame.getGvariables().getaPrecioAlquilerMusica().setText(String.valueOf(Constantes.variables.PRECIO_ALQUILER_MUSICA));
		frame.getGvariables().getaPrecioAlquilerPelicula().setText(String.valueOf(Constantes.variables.PRECIO_ALQUILER_PELICULA));
		frame.getGvariables().getaPrecioAlquilerSerie().setText(String.valueOf(Constantes.variables.PRECIO_ALQUILER_SERIE));
		frame.getGvariables().getaPrecioSuplementoExtensionDeTiempo().setText(String.valueOf(Constantes.variables.PRECIO_SUPLEMENTO));
		frame.getGvariables().getaPrecioTarifaPlanaMusica().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_MUSICA));
		frame.getGvariables().getaPrecioTarifaPlanaPeliculas().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_PELICULAS));
		frame.getGvariables().getaPrecioTarifaPlanaPeliculasMusica().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_PELICULASMUSICA));
		frame.getGvariables().getaPrecioTarifaPlanaPeliculasSeries().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_PELICULASSERIES));
		frame.getGvariables().getaPrecioTarifaPlanaPremium().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_PREMIUM));
		frame.getGvariables().getaPrecioTarifaPlanaSeries().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_SERIES));
		frame.getGvariables().getaPrecioTarifaPlanaSeriesMusica().setText(String.valueOf(Constantes.variables.PRECIO_TARIFA_MUSICASERIES));
		frame.getGvariables().getaDuracionExtensionDeTiempo().setText(String.valueOf(Constantes.variables.DURACION_SUPLEMENTO));
		frame.getGpanel().setVisible(false);
		frame.getGpanel().setVisible(true);
	}

}
