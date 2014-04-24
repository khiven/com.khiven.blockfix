package com.blockflix.controller;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.blockflix.src.Main;
import com.blockflix.src.constantes.Constantes;
import com.blockflix.src.gerente.Gerente;
import com.blockflix.view.LoginPanel;
import com.blockflix.viewGerente.GerentePanel;
import com.blockflix.viewGerente.Productos;
import com.blockflix.view.VentanaPrincipal;


public class ControlLoginPanel implements ActionListener {

	private LoginPanel lp;
	private JFrame frame;

	public ControlLoginPanel (LoginPanel lp, JFrame frame){
		this.lp=lp;
		this.frame = frame;
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
				GerentePanel vistaGerente = new GerentePanel();
				lp.setVisible(false);
				lp.getParent().add(vistaGerente);
				lp.getParent().getComponent(0).setVisible(false);
				frame.setSize(new Dimension(400,500));
				vistaGerente.setVisible(true);
			}

			else{
				JOptionPane.showMessageDialog(new JFrame(),
						
						"Password incorrecto. Int�ntelo de nuevo."+pw,
						"Password incorrecto",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		
	}
}

