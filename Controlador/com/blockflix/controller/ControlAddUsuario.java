package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.view.empleado.AddUsuarioDialog;

public class ControlAddUsuario implements ActionListener{
	private AddUsuarioDialog d;

	public ControlAddUsuario(AddUsuarioDialog d){
		this.d=d;
	}

	@Override
	public void actionPerformed(ActionEvent c) {
		// TODO Auto-generated method stub
		String cmd = c.getActionCommand();

		if (cmd.equals(AddUsuarioDialog.BA)){
			//AÑADIR USUARIO
			//Comprobamos los campos
			if (!d.checkFields()){
				//Error en los campos
				JOptionPane.showMessageDialog(new JFrame(),

						"Faltan campos por rellenar",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				Main.emp.gs.printListaSocios();
				
				//Se comprueba que no existe un usuario con ese DNI/NIE
				if (Main.emp.gs.buscarSocio(d.getDni())!=null){
					//EXISTE EL SOCIO, ERROR
					JOptionPane.showMessageDialog(new JFrame(),

							"Ya existe un socio con ese DNI/NIE",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					
				}
				else{
					//NO EXISTE EL SOCIO, SE AÑADE
					Main.emp.gs.addSocio(d.getNombre(), d.getApellidos(), d.getDireccion(), d.getTelefono(), d.getDni());
					JOptionPane.showMessageDialog(null,

							"Socio añadido correctamente, nº de socio: "+Main.emp.gs.buscarSocio(d.getDni()).getnSocio(),
							"Socio Añadido",
							JOptionPane.INFORMATION_MESSAGE);
					d.dispose();
				}
				
				
			}
			

		}
		else if (cmd.equals(AddUsuarioDialog.BC)){
			d.dispose();
		}

	}


}
