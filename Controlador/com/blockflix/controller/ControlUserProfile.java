package com.blockflix.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.view.empleado.ContratarTarifaDialog;
import com.blockflix.view.empleado.ModSocioDialog;
import com.blockflix.view.empleado.ProfileDialog;
import com.blockflix.view.empleado.UsuariosPanel;

public class ControlUserProfile implements ActionListener {

	ProfileDialog pd;
	UsuariosPanel up;
	public ControlUserProfile(ProfileDialog pd,UsuariosPanel up){
		this.pd = pd;
		this.up=up;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();
		
		if (cmd.equals(ProfileDialog.BMODSOCIO)){
			ModSocioDialog md = new ModSocioDialog();
			md.setControlador(new ControlModSocio(pd,md,pd.getSocio()));
			md.setVisible(true);
		}
		else if (cmd.equals(ProfileDialog.BDELSOCIO)){
			//SE BORRA EL SOCIO
			int confirm = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere eliminar al socio?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				Main.emp.gs.eliminarSocio(pd.getSocio().getnSocio());
				JOptionPane.showMessageDialog(null,

						"Socio eliminado correctamente",
						"Socio eliminado",
						JOptionPane.INFORMATION_MESSAGE);
				pd.dispose();
				
			}
		}
		else if (cmd.equals(ProfileDialog.BTARIFA)){
			ContratarTarifaDialog td = new ContratarTarifaDialog(pd.getSocio());
			ControlContratarTarifaDialog ctd = new ControlContratarTarifaDialog(td);
			td.setControlador(ctd);
			ctd.setPrecioTotal();
			
			td.setVisible(true);
			if (td.isTarifaContratada()){
				JOptionPane.showMessageDialog(null,

						"Tarifa contratada correctamente",
						"Tarifa contratada",
						JOptionPane.INFORMATION_MESSAGE);
				td.dispose();
				pd.dispose();
			}
			
			
			
		}
	}
	
	
}
