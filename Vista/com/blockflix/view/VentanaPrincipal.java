package com.blockflix.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.blockflix.controller.ControlLoginPanel;

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
		clp = new ControlLoginPanel(loginPanel);
	    loginPanel.setControlador(clp);
	    
	    
		logoPanel = new JPanel(new FlowLayout());
		logoPanel.add(new JLabel(new ImageIcon("res/logo.png")));
		mainPanel.add(logoPanel);
		mainPanel.add(loginPanel);
		this.add(mainPanel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void ocultarLogin(){
		this.mainPanel.setVisible(false);
	}

}
