package com.blockflix.view.empleado;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import com.blockflix.controller.ControlAlquilar;
import com.blockflix.controller.ControlUsuariosPanel;

public class EmpleadoPanel extends JTabbedPane {

	private UsuariosPanel up;
	private AlquileresPanel ap;
	private ControlUsuariosPanel cup;
	private ControlAlquilar cal;
	public EmpleadoPanel(){
	
		up = new UsuariosPanel();
		ap = new AlquileresPanel();
		cup= new ControlUsuariosPanel(up);
		cal= new ControlAlquilar(ap);
		up.setControlador(cup);
		ap.setControlador(cal);
		this.addTab("Gestión de Socios", up);
		this.addTab("Alquilar", ap);
	//	this.setPreferredSize(new Dimension(600,380));
		
		
	}
	
}
