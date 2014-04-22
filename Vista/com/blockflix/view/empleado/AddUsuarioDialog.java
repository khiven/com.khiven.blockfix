package com.blockflix.view.empleado;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class AddUsuarioDialog extends JDialog {

	private JLabel lTitulo;
	private JPanel mainPanel;
	public AddUsuarioDialog(){
		
		
		//super((JFrame)SwingUtilities.getWindowAncestor(parent),"Añadir Usuario");
		lTitulo = new JLabel("Añadir nuevo socio");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.add(lTitulo);
		this.add(mainPanel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	//	JPanel pLabel = new JPanel(new FlowLayout());
		//pLabel.add(lTitulo);
		//this.add(lTitulo);
//		
//		this.add(Box.createVerticalStrut(10));
//		this.add(new JSeparator(SwingConstants.HORIZONTAL));
//		this.add(Box.createVerticalStrut(10));
		
	}
}
