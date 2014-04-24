package com.blockflix.viewGerente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.blockflix.src.constantes.Constantes.Soporte;
import com.blockflix.src.constantes.Constantes.TipoProducto;
import com.blockflix.src.productos.Producto;

public class VerProducto extends JPanel {
	private JButton bEliminar;
	private JButton bModificar;
	
	private JLabel id_text = new JLabel("ID:");
	private JLabel id;
	private JLabel nombre_text = new JLabel("nombre:");
	private JLabel nombre;
	private JLabel categoria_text = new JLabel("categoria:");
	private JLabel categoria;
	private JLabel tipo_text = new JLabel("tipo:");
	private JLabel tipo;
	private JLabel soporte_text = new JLabel("soporte:");
	private JLabel soporte;
	private JLabel vecesAlquilado_text = new JLabel("vecesAlquilado:");
	private JLabel vecesAlquilado;
	//PELICULA
	private JLabel pelicula_agno_text = new JLabel("agno:");
	private JLabel pelicula_agno;
	private JLabel pelicula_director_text = new JLabel("director:");
	private JLabel pelicula_director;
	//MUSICA
	private JLabel musica_agno_text = new JLabel("agno:");
	private JLabel musica_agno;
	private JLabel musica_Interprete_text = new JLabel("Interprete:");
	private JLabel musica_Interprete;
	//SERIE
	private JLabel serie_temporada_text = new JLabel("temporada:");
	private JLabel serie_temporada;
	private JLabel serie_volumen_text = new JLabel("volumen:");
	private JLabel serie_volumen;
	
	private GerentePanel gpanel;

	public VerProducto(Producto p,GerentePanel gpanel){
		bModificar = new JButton("Modificar");
		bEliminar = new JButton("Eliminar");
		
		id=new JLabel(Integer.toString(p.getId()));
		nombre=new JLabel(p.getNombre());
		categoria=new JLabel(p.getCategoria());
		soporte=new JLabel(p.getSoporte().toString());
		tipo=new JLabel(p.getTipo().toString());
		vecesAlquilado=new JLabel(Integer.toString(p.getVecesAlquilado()));
		
/*		switch (p.getTipo().toString()){
			"PELICULA":
				pelicula_agno=new JLabel(p.
			"MUSICA":
			"SERIE":
		}*/
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		this.add(id_text,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		this.add(id,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		this.add(nombre_text,c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		this.add(nombre,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(categoria_text,c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(categoria,c);

		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		this.add(tipo_text,c);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		this.add(tipo,c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		this.add(soporte_text,c);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		this.add(soporte,c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		this.add(vecesAlquilado_text,c);
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		this.add(vecesAlquilado,c);
		
		switch (p.getTipo().toString()){
		case "PELICULA":
			c.gridx = 0;
			c.gridy = 6;
			c.gridwidth = 2;
			this.add(pelicula_agno_text,c);
			c.gridx = 1;
			c.gridy = 6;
			c.gridwidth = 2;
			this.add(pelicula_agno,c);
			
			c.gridx = 0;
			c.gridy = 7;
			c.gridwidth = 2;
			this.add(pelicula_director_text,c);
			c.gridx = 1;
			c.gridy = 7;
			c.gridwidth = 2;
			this.add(pelicula_director,c);
			
			break;
			
		case "MUSICA":
			c.gridx = 0;
			c.gridy = 6;
			c.gridwidth = 2;
			this.add( musica_agno_text,c);
			c.gridx = 1;
			c.gridy = 6;
			c.gridwidth = 2;
			this.add( musica_agno,c);
			
			c.gridx = 0;
			c.gridy = 7;
			c.gridwidth = 2;
			this.add( musica_Interprete_text,c);
			c.gridx = 1;
			c.gridy = 7;
			c.gridwidth = 2;
			this.add( musica_Interprete,c);	
			
			break;
			
		case "SERIE":
			c.gridx = 0;
			c.gridy = 6;
			c.gridwidth = 2;
			this.add(serie_temporada_text,c);
			c.gridx = 1;
			c.gridy = 6;
			c.gridwidth = 2;
			this.add(serie_temporada,c);
			
			c.gridx = 0;
			c.gridy = 7;
			c.gridwidth = 2;
			this.add(serie_volumen_text,c);
			c.gridx = 1;
			c.gridy = 7;
			c.gridwidth = 2;
			this.add(serie_volumen,c);
			
			break;
		}
		
		
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 2;
		this.add(bModificar,c);
		c.gridx = 10;
		c.gridy = 10;
		c.gridwidth = 2;
		this.add(bEliminar,c);
		
		
	}

	public JButton getbEliminar() {
		return bEliminar;
	}

	public void setbEliminar(JButton bEliminar) {
		this.bEliminar = bEliminar;
	}

	public JButton getbModificar() {
		return bModificar;
	}

	public void setbModificar(JButton bModificar) {
		this.bModificar = bModificar;
	}

	public JLabel getId_text() {
		return id_text;
	}

	public void setId_text(JLabel id_text) {
		this.id_text = id_text;
	}

	public JLabel getId() {
		return id;
	}

	public void setId(JLabel id) {
		this.id = id;
	}

	public JLabel getNombre_text() {
		return nombre_text;
	}

	public void setNombre_text(JLabel nombre_text) {
		this.nombre_text = nombre_text;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getCategoria_text() {
		return categoria_text;
	}

	public void setCategoria_text(JLabel categoria_text) {
		this.categoria_text = categoria_text;
	}

	public JLabel getCategoria() {
		return categoria;
	}

	public void setCategoria(JLabel categoria) {
		this.categoria = categoria;
	}

	public JLabel getTipo_text() {
		return tipo_text;
	}

	public void setTipo_text(JLabel tipo_text) {
		this.tipo_text = tipo_text;
	}

	public JLabel getTipo() {
		return tipo;
	}

	public void setTipo(JLabel tipo) {
		this.tipo = tipo;
	}

	public JLabel getSoporte_text() {
		return soporte_text;
	}

	public void setSoporte_text(JLabel soporte_text) {
		this.soporte_text = soporte_text;
	}

	public JLabel getSoporte() {
		return soporte;
	}

	public void setSoporte(JLabel soporte) {
		this.soporte = soporte;
	}

	public JLabel getVecesAlquilado_text() {
		return vecesAlquilado_text;
	}

	public void setVecesAlquilado_text(JLabel vecesAlquilado_text) {
		this.vecesAlquilado_text = vecesAlquilado_text;
	}

	public JLabel getVecesAlquilado() {
		return vecesAlquilado;
	}

	public void setVecesAlquilado(JLabel vecesAlquilado) {
		this.vecesAlquilado = vecesAlquilado;
	}

	public JLabel getPelicula_agno_text() {
		return pelicula_agno_text;
	}

	public void setPelicula_agno_text(JLabel pelicula_agno_text) {
		this.pelicula_agno_text = pelicula_agno_text;
	}

	public JLabel getPelicula_agno() {
		return pelicula_agno;
	}

	public void setPelicula_agno(JLabel pelicula_agno) {
		this.pelicula_agno = pelicula_agno;
	}

	public JLabel getPelicula_director_text() {
		return pelicula_director_text;
	}

	public void setPelicula_director_text(JLabel pelicula_director_text) {
		this.pelicula_director_text = pelicula_director_text;
	}

	public JLabel getPelicula_director() {
		return pelicula_director;
	}

	public void setPelicula_director(JLabel pelicula_director) {
		this.pelicula_director = pelicula_director;
	}

	public JLabel getMusica_agno_text() {
		return musica_agno_text;
	}

	public void setMusica_agno_text(JLabel musica_agno_text) {
		this.musica_agno_text = musica_agno_text;
	}

	public JLabel getMusica_agno() {
		return musica_agno;
	}

	public void setMusica_agno(JLabel musica_agno) {
		this.musica_agno = musica_agno;
	}

	public JLabel getMusica_Interprete_text() {
		return musica_Interprete_text;
	}

	public void setMusica_Interprete_text(JLabel musica_Interprete_text) {
		this.musica_Interprete_text = musica_Interprete_text;
	}

	public JLabel getMusica_Interprete() {
		return musica_Interprete;
	}

	public void setMusica_Interprete(JLabel musica_Interprete) {
		this.musica_Interprete = musica_Interprete;
	}

	public JLabel getSerie_temporada_text() {
		return serie_temporada_text;
	}

	public void setSerie_temporada_text(JLabel serie_temporada_text) {
		this.serie_temporada_text = serie_temporada_text;
	}

	public JLabel getSerie_temporada() {
		return serie_temporada;
	}

	public void setSerie_temporada(JLabel serie_temporada) {
		this.serie_temporada = serie_temporada;
	}

	public JLabel getSerie_volumen_text() {
		return serie_volumen_text;
	}

	public void setSerie_volumen_text(JLabel serie_volumen_text) {
		this.serie_volumen_text = serie_volumen_text;
	}

	public JLabel getSerie_volumen() {
		return serie_volumen;
	}

	public void setSerie_volumen(JLabel serie_volumen) {
		this.serie_volumen = serie_volumen;
	}

	public GerentePanel getGpanel() {
		return gpanel;
	}

	public void setGpanel(GerentePanel gpanel) {
		this.gpanel = gpanel;
	}
}







/*package com.blockflix.viewGerente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VerProducto extends JFrame {

	public VerProducto(){

		JTextArea aFicha = new JTextArea("Ficha de:");
		JTextArea aFicha2 = new JTextArea("  ");
		JTextArea aInformacionDelProducto = new JTextArea("Información del producto\tID:");
		JTextArea aInformacionDelProducto2= new JTextArea("  ");
		JTextArea aNombre = new JTextArea("Nombre:");
		JTextArea aNombre2 = new JTextArea("  ");
		JTextArea aCategoria = new JTextArea("Categoría:");
		JTextArea aCategoria2= new JTextArea("  ");
		JTextArea aDirector = new JTextArea("Director:");
		JTextArea aDirector2= new JTextArea("  ");
		JTextArea aGenero = new JTextArea("Género:");
		JTextArea aGenero2 = new JTextArea("  ");
		JTextArea aAño = new JTextArea("Año:");
		JTextArea aAño2= new JTextArea("  ");
		JTextArea aSoporte = new JTextArea("Soporte:");
		JTextArea aSoporte2 = new JTextArea("  ");
		JTextArea aEstado = new JTextArea("Estado:");
		JTextArea aEstado2 = new JTextArea("  ");
		JTextArea aSocio = new JTextArea("Socio:");
		JTextArea aSocio2 = new JTextArea("  ");
		JTextArea aSocioID = new JTextArea("ID:");
		JTextArea aSocioID2 = new JTextArea("  ");
		JTextArea aFechaDeDevolucion = new JTextArea("Fecha de devolución:");
		JTextArea aFechaDeDevolucion2 = new JTextArea("  ");

		aFicha.setEditable(false);
		aFicha2.setEditable(false);
		aInformacionDelProducto.setEditable(false);
		aInformacionDelProducto2.setEditable(false);
		aNombre.setEditable(false);
		aCategoria.setEditable(false);
		aDirector.setEditable(false);
		aGenero.setEditable(false);
		aAño.setEditable(false);
		aSoporte.setEditable(false);
		aEstado.setEditable(false);
		aEstado2.setEditable(false);
		aSocio.setEditable(false);
		aSocio2.setEditable(false);
		aSocioID.setEditable(false);
		aSocioID2.setEditable(false);
		aFechaDeDevolucion.setEditable(false);
		aFechaDeDevolucion2.setEditable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		panel.add(aFicha, c);
		c.gridx=1;
		panel.add(aFicha2, c);
		c.gridy=1;
		c.gridx=0;
		panel.add(aInformacionDelProducto, c);
		c.gridx=1;
		panel.add(aInformacionDelProducto2, c);
		c.gridx=0;
		c.gridy=2;
		panel.add(aNombre, c);
		c.gridx=1;
		panel.add(aNombre2, c);
		c.gridx=0;
		c.gridy=3;
		panel.add(aCategoria, c);
		c.gridx=1;
		panel.add(aCategoria2, c);
		c.gridx=0;
		c.gridy=4;
		panel.add(aDirector, c);
		c.gridx=1;
		panel.add(aDirector2, c);
		c.gridx=0;
		c.gridy=5;
		panel.add(aGenero, c);
		c.gridx=1;
		panel.add(aGenero2, c);
		c.gridx=0;
		c.gridy=6;
		panel.add(aAño, c);
		c.gridx=1;
		panel.add(aAño2, c);
		c.gridx=0;
		c.gridy=7;
		panel.add(aSoporte, c);
		c.gridx=1;
		panel.add(aSoporte2, c);
		c.gridx=0;
		c.gridy=8;
		panel.add(aEstado, c);
		c.gridx=1;
		panel.add(aEstado2, c);
		c.gridx=0;
		c.gridy=9;
		panel.add(aSocio, c);
		c.gridx=1;
		panel.add(aSocio2, c);
		c.gridx=0;
		c.gridy=10;
		panel.add(aSocioID, c);
		c.gridx=1;
		panel.add(aSocioID2, c);
		c.gridx=0;
		c.gridy=11;
		panel.add(aFechaDeDevolucion, c);
		c.gridx=1;
		panel.add(aFechaDeDevolucion2, c);
		this.add(panel);
		this.setSize(new Dimension(400,500));
		this.setResizable(false);
			
	}

	
}*/