package com.blockflix.viewGerente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.blockflix.controller.ControlModificar;
import com.blockflix.src.Main;
import com.blockflix.src.productos.*;

public class ModificarProducto extends JFrame{
	private String categoriaSeleccionada;
	private String tipoSeleccionado;
	private JComboBox<String> cbTipo;
	private JComboBox<String> cbCategoria;
	private String titulo;
	private ModificarProducto frame = this;
	private JTextArea aPrimero;
	private JTextArea aSegundo;
	private String primero;
	private String segundo;
	private String soporteSeleccionado;
	private int id;
	
	public ModificarProducto(Producto p){
		this.setId(p.getId());
		JTextArea aDatosGenericos = new JTextArea("Datos genéricos del producto:\tID");
		JTextArea aDatosEspecificos = new JTextArea("Datos específicos del producto:");
		JTextArea aTitulo = new JTextArea("Título:");
		JTextArea aTipo = new JTextArea("Tipo:");
		JTextArea aCategoria = new JTextArea("Categoría:");
		JLabel lId = new JLabel(String.valueOf(p.getId()));
		aPrimero = new JTextArea("Director:");
		aSegundo = new JTextArea("Año:");
		JTextArea aSoporte = new JTextArea("Soporte:");
		aDatosGenericos.setEditable(false);
		aDatosEspecificos.setEditable(false);
		aTitulo.setEditable(false);
		aTipo.setEditable(false);
		aCategoria.setEditable(false);
		aPrimero.setEditable(false);
		aSegundo.setEditable(false);
		aSoporte.setEditable(false);
		JTextField tTitulo = new JTextField(p.getNombre());
		String[] categorias;
		String[] tipos = {"Peliculas","Series","Musica"};
		cbTipo = new JComboBox<String>(tipos); 
		JTextField tPrimero = new JTextField();
		JTextField tSegundo = new JTextField();
		switch(p.getTipo().toString()){
		case "Pelicula":
			tPrimero.setText(((Pelicula)p).getDirector());
			tSegundo.setText(String.valueOf((((Pelicula)p).getAgno())));
			cbTipo.setSelectedIndex(0);
			categorias = new String[Main.ger.gp.categoriasCine.size()];
			cbCategoria = new JComboBox<String>(Main.ger.gp.categoriasCine.toArray(categorias));
			for (int i=0;i<cbCategoria.getItemCount();i++){
				if (p.getCategoria().equals(cbCategoria.getItemAt(i))){
					cbCategoria.setSelectedIndex(i);
					break;
				}
			}
			break;
		case "Serie":
			tPrimero.setText(String.valueOf((((Serie)p).getTemporada())));
			tSegundo.setText(String.valueOf((((Serie)p).getVolumen())));
			cbTipo.setSelectedIndex(1);
			categorias = new String[Main.ger.gp.categoriasSeries.size()];
			cbCategoria = new JComboBox<String>(Main.ger.gp.categoriasSeries.toArray(categorias));
			for (int i=0;i<cbCategoria.getItemCount();i++){
				if (p.getCategoria().equals(cbCategoria.getItemAt(i))){
					cbCategoria.setSelectedIndex(i);
					break;
				}
			}
			break;
		case "Musica":
			tPrimero.setText(((Musica)p).getInterprete());
			tSegundo.setText(String.valueOf((((Musica)p).getAgno())));
			cbTipo.setSelectedIndex(2);
			categorias = new String[Main.ger.gp.categoriasMusica.size()];
			cbCategoria = new JComboBox<String>(Main.ger.gp.categoriasMusica.toArray(categorias));
			for (int i=0;i<cbCategoria.getItemCount();i++){
				if (p.getCategoria().equals(cbCategoria.getItemAt(i))){
					cbCategoria.setSelectedIndex(i);
					break;
				}
			}
			break;
		}
		String[] soportes = {"DVD","BLURAY","CD","VINILO"};
		JComboBox<String> cbSoporte = new JComboBox<String>(soportes);
		for (int i=0;i<cbSoporte.getItemCount();i++){
			if (p.getSoporte().toString().equals(cbSoporte.getItemAt(i))){
				cbSoporte.setSelectedIndex(i);
				break;
			}
		}
		JButton bModificar = new JButton("Modificar");
		JButton bCerrar = new JButton("Cerrar");
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		panel.add(aDatosGenericos,c);
		c.gridx=1;
		panel.add(lId);
		c.gridx=0;
		c.gridy=1;
		panel.add(aTitulo,c);
		c.gridx=1;
		panel.add(tTitulo,c);
		c.gridx=0;
		c.gridy=2;
		panel.add(aTipo,c);
		c.gridx=1;
		panel.add(cbTipo,c);
		c.gridx=0;
		c.gridy=3;
		panel.add(aCategoria,c);
		c.gridx=1;
		panel.add(cbCategoria,c);
		c.gridx=0;
		c.gridy=4;
		panel.add(aDatosEspecificos,c);
		c.gridy=5;
		panel.add(aPrimero,c);
		c.gridx=1;
		panel.add(tPrimero,c);
		c.gridx=0;
		c.gridy=6;
		panel.add(aSegundo,c);
		c.gridx=1;
		panel.add(tSegundo,c);
		c.gridx=0;
		c.gridy=7;
		panel.add(aSoporte,c);
		c.gridx=1;
		panel.add(cbSoporte,c);
		c.gridx=0;
		c.gridy=8;
		panel.add(bModificar,c);
		c.gridx=1;
		panel.add(bCerrar,c);
		this.add(panel);
		this.setSize(new Dimension(400,500));
		this.setResizable(false);
		this.setTipoSeleccionado("Peliculas");
		this.setSoporteSeleccionado("DVD");
		this.setCategoriaSeleccionada("Acción");
		
		cbCategoria.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<String> source = (JComboBox<String>) e.getSource();
				if (source.getSelectedItem() != null){
					String selectedValue = source.getSelectedItem().toString();
					frame.setCategoriaSeleccionada(selectedValue);
				}
			}
		});
		
		cbTipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<String> source = (JComboBox<String>) e.getSource();
				String selectedValue = source.getSelectedItem().toString();
				cbCategoria.removeAllItems();
				frame.setTipoSeleccionado(selectedValue);
				switch(selectedValue){
				case "Peliculas" :
					for (String value : Main.ger.gp.categoriasCine){
						cbCategoria.addItem(value);
					}
					aPrimero.setText("Director:");
					aSegundo.setText("Año:");
					break;
				case "Series" :
					for (String value : Main.ger.gp.categoriasSeries){
						cbCategoria.addItem(value);
					}
					aPrimero.setText("Temporada:");
					aSegundo.setText("Volumen:");
					break;
				case "Musica" :
					for (String value : Main.ger.gp.categoriasMusica){
						cbCategoria.addItem(value);
					}
					aPrimero.setText("Interprete:");
					aSegundo.setText("Año:");
					break;
				}
			}
			
		});
		
		cbSoporte.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<String> source = (JComboBox<String>) e.getSource();
				if (source.getSelectedItem() != null){
					String selectedValue = source.getSelectedItem().toString();
					frame.setSoporteSeleccionado(selectedValue);
				}
			}
		});
		
		tTitulo.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e) {
				JTextField source = (JTextField) e.getSource();
				String selectedValue = source.getText();
					frame.setTitulo(selectedValue);
				}
		});
		
		tPrimero.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e) {
				JTextField source = (JTextField) e.getSource();
				String selectedValue = source.getText();
					frame.setPrimero(selectedValue);
				}
		});
		
		tSegundo.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e) {
				JTextField source = (JTextField) e.getSource();
				String selectedValue = source.getText();
					frame.setSegundo(selectedValue);
				}
		});
		
		bModificar.addActionListener(new ControlModificar(bModificar,bCerrar,this));
		bCerrar.addActionListener(new ControlModificar(bModificar,bCerrar,this));
	}

	public String getCategoriaSeleccionada() {
		return categoriaSeleccionada;
	}

	public void setCategoriaSeleccionada(String categoriaSeleccionada) {
		this.categoriaSeleccionada = categoriaSeleccionada;
	}

	public String getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(String tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrimero() {
		return primero;
	}

	public void setPrimero(String primero) {
		this.primero = primero;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public String getSoporteSeleccionado() {
		return soporteSeleccionado;
	}

	public void setSoporteSeleccionado(String soporteSeleccionado) {
		this.soporteSeleccionado = soporteSeleccionado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}