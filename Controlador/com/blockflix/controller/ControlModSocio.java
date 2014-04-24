package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.src.socios.Socio;
import com.blockflix.view.empleado.AddUsuarioDialog;
import com.blockflix.view.empleado.ModSocioDialog;
import com.blockflix.view.empleado.ProfileDialog;

public class ControlModSocio implements ActionListener{
	private ModSocioDialog d;
	private Socio socio;
	private ProfileDialog p;

	public ControlModSocio(ProfileDialog p,ModSocioDialog d,Socio socio){
		this.d=d;
		this.socio=socio;
		this.p=p;
	}

	@Override
	public void actionPerformed(ActionEvent c) {
		// TODO Auto-generated method stub
		String cmd = c.getActionCommand();

		if (cmd.equals(ModSocioDialog.BA)){
			//Modificar usuario
			//Comprobamos los campos
			if (!d.checkFields()){
				//Error en los campos
				JOptionPane.showMessageDialog(new JFrame(),

						"Faltan campos por rellenar",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else{

				//Se modifica el socio
				Main.emp.gs.modificarDatosSocio(socio.getnSocio(),d.getNombre(), d.getApellidos(), d.getDireccion(), d.getTelefono(), d.getDni());
				JOptionPane.showMessageDialog(null,

						"Socio modificado correctamente",
						"Socio Modificado",
						JOptionPane.INFORMATION_MESSAGE);
				d.dispose();
				p.dispose();
			}


		}


//CANCELAR
		else if (cmd.equals(AddUsuarioDialog.BC)){
			d.dispose();
		}

	}


}
