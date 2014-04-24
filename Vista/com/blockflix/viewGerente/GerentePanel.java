package com.blockflix.viewGerente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.blockflix.view.LoginPanel;

public class GerentePanel extends JTabbedPane{
	
	private LoginPanel mainWindow;
	
	public GerentePanel(LoginPanel frame){
		this.setMainWindow(frame);
		Productos productos = new Productos();
		JPanel listas = new Listas();
		JPanel gestion = new GestionVariables(this);
		JPanel salir = new SalirGerente(this);
		this.addTab("Productos",productos);
		this.addTab("Listas",listas);
		this.addTab("Gestion del sistema",gestion);
		this.addTab("Salir",salir);
		
	}

	public LoginPanel getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(LoginPanel mainWindow) {
		this.mainWindow = mainWindow;
	}
}