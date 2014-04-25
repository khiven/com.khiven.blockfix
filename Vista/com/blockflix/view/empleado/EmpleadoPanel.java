package com.blockflix.view.empleado;

import javax.swing.JTabbedPane;

import com.blockflix.controller.ControlGestionAlquileres;
import com.blockflix.controller.ControlUsuariosPanel;

public class EmpleadoPanel extends JTabbedPane {

	private UsuariosPanel up;
	private GestionAlquileresPanel ga;
	private ControlUsuariosPanel cup;
	private ControlGestionAlquileres cga;
	public EmpleadoPanel(){
	
		up = new UsuariosPanel();
		ga = new GestionAlquileresPanel();
		cup= new ControlUsuariosPanel(up);
		cga = new ControlGestionAlquileres(ga);
		up.setControlador(cup);
		ga.setControlador(cga);
		this.addTab("Gestión de Socios", up);
		this.addTab("Gestión de Alquileres", ga);
	//	this.setPreferredSize(new Dimension(600,380));
		
		
	}
	
}
