package com.blockflix.view;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.blockflix.controller.ControlLoginPanel;
import com.blockflix.controller.ControlVentanaPrincipal;
import com.blockflix.src.Main;

public class VentanaPrincipal extends JFrame {

	private JPanel logoPanel;
	private JPanel mainPanel;
	private LoginPanel loginPanel;
	private ControlLoginPanel clp;


	public VentanaPrincipal(String name){
		super(name);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));


		loginPanel = new LoginPanel();

		clp = new ControlLoginPanel(loginPanel,this);
	    loginPanel.setControlador(clp);
	    
	    

		logoPanel = new JPanel(new FlowLayout());
		logoPanel.add(new JLabel(new ImageIcon("res/logo.png")));
		mainPanel.add(logoPanel);
		mainPanel.add(loginPanel);
		this.add(mainPanel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new ControlVentanaPrincipal(this));

	}

	public void ocultarLogin(){
		this.mainPanel.setVisible(false);
	}

	public void saveAndExit(){
		int confirm = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			System.exit(0);

			if (Main.emp!=null)
				Main.emp.save();
			if (Main.ger!=null)
				Main.ger.save();
			this.dispose();
			System.exit(0);
		}
	}

}
