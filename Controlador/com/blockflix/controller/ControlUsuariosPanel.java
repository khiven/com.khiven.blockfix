package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.blockflix.view.empleado.AddUsuarioDialog;
import com.blockflix.view.empleado.UsuariosPanel;

public class ControlUsuariosPanel implements ActionListener{
	private UsuariosPanel up;

	public ControlUsuariosPanel (UsuariosPanel up){
		this.up=up;
	}

	@Override
	public void actionPerformed(ActionEvent c) {
		// TODO Auto-generated method stub
		String cmd = c.getActionCommand();

		if (cmd.equals(UsuariosPanel.BA)){
			//AÑADIR USUARIO
			AddUsuarioDialog addDialog =new AddUsuarioDialog();//(JFrame)SwingUtilities.getWindowAncestor(up));
			addDialog.setVisible(true);
		}
		
	}


}


