package com.blockflix.viewGerente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.blockflix.src.Main;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Productos extends JPanel{
	private JButton bBuscar;
	private JButton bAnadir;
	private JButton bVer;
	private JTextField tTitulo;
	private JComboBox<String> cbTipo;
	private JComboBox<String> cbCategoria;
	
	public Productos(){
		String[] categorias = new String[Main.ger.gp.categoriasCine.size()];
		String[] tipos = {"Peliculas","Series","Musica"};
		bBuscar = new JButton("Buscar");
		bAnadir = new JButton("Añadir nuevo producto");
		bVer = new JButton("Ver producto");
		tTitulo = new JTextField();
		cbTipo = new JComboBox<String>(tipos);
		cbCategoria = new JComboBox<String>(Main.ger.gp.categoriasCine.toArray(categorias));
		
		cbTipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<String> source = (JComboBox<String>) e.getSource();
				String selectedValue = source.getSelectedItem().toString();
				cbCategoria.removeAllItems();
				switch(selectedValue){
				case "Peliculas" :
					for (String value : Main.ger.gp.categoriasCine){
						cbCategoria.addItem(value);
					}
				case "Series" :
					for (String value : Main.ger.gp.categoriasSeries){
						cbCategoria.addItem(value);
					}
				case "Musica" :
					for (String value : Main.ger.gp.categoriasMusica){
						cbCategoria.addItem(value);
					}
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
	}
	
	public void actionPerformed(ActionEvent e){
		JComboBox<String> source = (JComboBox<String>) e.getSource();
		String selectedValue = source.getSelectedItem().toString();
		cbCategoria.removeAllItems();
		switch(selectedValue){
		case "Peliculas" :
			for (String value : Main.ger.gp.categoriasCine){
				cbCategoria.addItem(value);
			}
		case "Series" :
			for (String value : Main.ger.gp.categoriasSeries){
				cbCategoria.addItem(value);
			}
		case "Musica" :
			for (String value : Main.ger.gp.categoriasMusica){
				cbCategoria.addItem(value);
			}
		}
	}

}
