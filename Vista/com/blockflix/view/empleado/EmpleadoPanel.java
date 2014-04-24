package com.blockflix.view.empleado;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import com.blockflix.controller.ControlUsuariosPanel;

public class EmpleadoPanel extends JTabbedPane {

	private UsuariosPanel up;
	private AlquileresPanel ap;
	private ControlUsuariosPanel cup;
	public EmpleadoPanel(){
	
		up = new UsuariosPanel();
		ap = new AlquileresPanel();
		cup= new ControlUsuariosPanel(up);
		up.setControlador(cup);
		this.addTab("Gesti�n de Socios", up);
		this.addTab("Gesti�n de Alquileres", ap);
	//	this.setPreferredSize(new Dimension(600,380));
		
		
	}
	
}
