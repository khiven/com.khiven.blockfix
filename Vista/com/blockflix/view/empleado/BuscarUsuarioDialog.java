package com.blockflix.view.empleado;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuscarUsuarioDialog extends JDialog{

	private JPanel mainPanel;
	private JLabel lTitle;
	public BuscarUsuarioDialog(){
		mainPanel = new JPanel();
		lTitle = new JLabel("Buscar Usuario");
	}
}
