package com.blockflix.viewGerente;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GerentePanel extends JTabbedPane{
	
	
	public GerentePanel(){
		Productos productos = new Productos();
		JPanel listas = new JPanel();
		JPanel gestion = new JPanel();
		JPanel salir = new JPanel();
		this.addTab("Productos",productos);
		this.addTab("Listas",listas);
		this.addTab("Gestion del sistema",gestion);
		this.addTab("Salir",salir);
		
	}
}