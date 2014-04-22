package com.blockflix.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.view.LoginPanel;
import com.blockflix.view.VentanaPrincipal;
import com.blockflix.view.empleado.EmpleadoPanel;


public class ControlLoginPanel implements ActionListener {

	private LoginPanel lp;

	public ControlLoginPanel (LoginPanel lp){
		this.lp=lp;
	}

	@Override
	public void actionPerformed(ActionEvent c) {
		// TODO Auto-generated method stub
		String cmd = c.getActionCommand();
		String pw = String.valueOf(lp.getPassword());
		if (LoginPanel.BG.equals(cmd)){
			//Check Password
			if ((Main.ger=Constantes.doLogin(Constantes.variables.USR_GERENTE,pw))
					!=null){
				JOptionPane.showMessageDialog(new JFrame(),

						"Password correcto.",
						"Password correcto",
						JOptionPane.OK_OPTION);
				
			}

			else{
				JOptionPane.showMessageDialog(new JFrame(),
						
						"Password incorrecto. Int�ntelo de nuevo."+pw,
						"Password incorrecto",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			lp.setVisible(false);
			lp.getParent().setVisible(false);
			VentanaPrincipal topFrame = (VentanaPrincipal)SwingUtilities.getWindowAncestor(lp);
			topFrame.ocultarLogin();
			topFrame.add(new EmpleadoPanel());
			topFrame.pack();
		}

		
	}
}

