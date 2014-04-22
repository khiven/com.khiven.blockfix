package com.blockflix.view.empleado;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

public class EmpleadoPanel extends JTabbedPane {

	private UsuariosPanel up;
	public EmpleadoPanel(){
		up = new UsuariosPanel();
	
		
		this.addTab("Gestión de Socios", up);
		
		this.setPreferredSize(new Dimension(500,320));
		
		
	}
	
}
