package com.blockflix.view.empleado;

import javax.swing.JDialog;

import com.blockflix.controller.ControlAlquilar;

public class AlquilarDialog extends JDialog{

	private AlquileresPanel ap;
	
	public AlquilarDialog(){
		ap=new AlquileresPanel();
		ap.setControlador(new ControlAlquilar(ap));
		this.add(ap);
		
		this.setTitle("Añadir nuevo socio");
	
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	//	this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}
}
