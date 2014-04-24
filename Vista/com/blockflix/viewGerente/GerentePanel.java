package com.blockflix.viewGerente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GerentePanel extends JTabbedPane{
	
	private JFrame mainWindow;
	
	public GerentePanel(JFrame frame){
		this.setMainWindow(frame);
		Productos productos = new Productos();
		JPanel listas = new JPanel();
		JPanel gestion = new JPanel();
		JPanel salir = new SalirGerente(this);
		this.addTab("Productos",productos);
		this.addTab("Listas",listas);
		this.addTab("Gestion del sistema",gestion);
		this.addTab("Salir",salir);
		
	}

	public JFrame getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(JFrame mainWindow) {
		this.mainWindow = mainWindow;
	}
}