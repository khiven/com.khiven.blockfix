package com.blockflix.view.empleado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class UsuariosPanel extends JPanel{

	private JButton addSocio;
	private JButton searchSocios;
	private JLabel lSocios;
	
	
	public UsuariosPanel(){
		addSocio = new JButton("Añadir nuevo socio");
		searchSocios = new JButton("Buscar socios");
		lSocios=new JLabel("Gestión de Socios");
		lSocios.setFont(new Font("Serif",Font.BOLD,32));
		lSocios.setBackground(Color.LIGHT_GRAY);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		JPanel pLabel = new JPanel(new FlowLayout());
		pLabel.add(lSocios);
		this.add(pLabel);
		
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));

		JPanel paddSocio = new JPanel(new FlowLayout());
		paddSocio.add(addSocio);
		this.add(paddSocio);

		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));

		JPanel psearchSocios = new JPanel(new FlowLayout());
		psearchSocios.add(searchSocios);
		this.add(psearchSocios);
		this.add(Box.createVerticalStrut(10));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(Box.createVerticalStrut(10));

	
		this.setBorder(BorderFactory.createEmptyBorder(10,50,10,50)) ;
		
		
	}
}
