package com.blockflix.view.empleado;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class AddUsuarioDialog extends JDialog {

	private JLabel lTitulo;
	private JPanel mainPanel;
	private AddUsuarioForm formulario;
	private JPanel buttonContainer;
	private JPanel titleContainer;
	private JButton bOk,bCancel;
	
	public AddUsuarioDialog(){
		
		
		//super((JFrame)SwingUtilities.getWindowAncestor(parent),"Añadir Usuario");
		lTitulo = new JLabel("Añadir nuevo socio");
		lTitulo.setFont(new Font(null,Font.BOLD,32));
		titleContainer=new JPanel();
		formulario = new AddUsuarioForm();
		bOk=new JButton("Añadir Usuario");
		bCancel=new JButton("Cancelar");
		buttonContainer = new JPanel();
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		titleContainer.add(lTitulo);
		mainPanel.add(titleContainer);
		
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mainPanel.add(Box.createVerticalStrut(10));
		
		mainPanel.add(formulario);

		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mainPanel.add(Box.createVerticalStrut(10));

		buttonContainer.add(bOk);
		buttonContainer.add(bCancel);
		mainPanel.add(buttonContainer);
		
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		mainPanel.add(Box.createVerticalStrut(10));

		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50)) ;
	

		this.add(mainPanel);
		this.pack();
//		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		

		
	}
}
