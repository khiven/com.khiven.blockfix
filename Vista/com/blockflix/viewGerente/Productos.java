package com.blockflix.viewGerente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.blockflix.src.Main;
import com.blockflix.controller.ControlGerente;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Productos extends JPanel{
	private JButton bBuscar;
	private JButton bAnadir;
	private JButton bVer;
	private JTextField tTitulo;
	private JComboBox<String> cbTipo;
	private JComboBox<String> cbCategoria;
	private JTable tResultados;
	private String categoriaSeleccionada;
	private String tipoSeleccionado;
	private DefaultTableModel modeloDatos;
	private String titulo;
	
	public Productos(){
		String[] categorias = new String[Main.ger.gp.categoriasCine.size()];
		String[] tipos = {"Peliculas","Series","Musica"};
		bBuscar = new JButton("Buscar");
		bAnadir = new JButton("A�adir nuevo producto");
		bVer = new JButton("Ver producto");
		tTitulo = new JTextField();
		cbTipo = new JComboBox<String>(tipos);
		cbCategoria = new JComboBox<String>(Main.ger.gp.categoriasCine.toArray(categorias));
		String[] titulos = {"T�tulo","Tipo","Categor�a","ID"};
		Object[][] filas = {};
		modeloDatos = new DefaultTableModel(filas, titulos); 
		tResultados = new JTable(modeloDatos);
		JScrollPane scroll = new JScrollPane(tResultados);
		this.setModeloDatos(modeloDatos);
		this.setTipoSeleccionado("Peliculas");
		this.setCategoriaSeleccionada("Acci�n");
		
		cbCategoria.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<String> source = (JComboBox<String>) e.getSource();
				if (source.getSelectedItem() != null){
					String selectedValue = source.getSelectedItem().toString();
					((Productos) source.getParent()).setCategoriaSeleccionada(selectedValue);
				}
			}
		});
		
		tTitulo.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e) {
				JTextField source = (JTextField) e.getSource();
				String selectedValue = source.getText();
				((Productos) source.getParent()).setTitulo(selectedValue);	
			}
		});
			
		cbTipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<String> source = (JComboBox<String>) e.getSource();
				String selectedValue = source.getSelectedItem().toString();
				cbCategoria.removeAllItems();
				((Productos) source.getParent()).setTipoSeleccionado(selectedValue);
				switch(selectedValue){
				case "Peliculas" :
					for (String value : Main.ger.gp.categoriasCine){
						cbCategoria.addItem(value);
					}
					break;
				case "Series" :
					for (String value : Main.ger.gp.categoriasSeries){
						cbCategoria.addItem(value);
					}
					break;
				case "Musica" :
					for (String value : Main.ger.gp.categoriasMusica){
						cbCategoria.addItem(value);
					}
					break;
				}
			}
			
		});
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		this.add(tTitulo,c);
		c.gridx=2;
		c.gridwidth=1;
		c.gridheight=2;
		this.add(bBuscar, c);
		c.gridx=0;
		c.gridy=1;
		c.gridheight=1;
		this.add(cbTipo, c);
		c.gridx=1;
		this.add(cbCategoria, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 6;
		scroll.setMinimumSize(new Dimension(300,200));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll, c);
		c.fill = GridBagConstraints.NONE;
		c.gridheight=1;
		c.gridx = 0;
		c.gridy = 3;
		this.add(bAnadir, c);
		c.gridy = 2;
		this.add(bVer, c);
		bBuscar.addActionListener(new ControlGerente(this.bBuscar,this.bAnadir,this.bVer,this));
		bAnadir.addActionListener(new ControlGerente(this.bBuscar,this.bAnadir,this.bVer,this));
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

	public DefaultTableModel getModeloDatos() {
		return modeloDatos;
	}

	public void setModeloDatos(DefaultTableModel modeloDatos) {
		this.modeloDatos = modeloDatos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
