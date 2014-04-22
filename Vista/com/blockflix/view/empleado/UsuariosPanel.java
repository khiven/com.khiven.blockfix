package com.blockflix.view.empleado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class UsuariosPanel extends JPanel{
	public static final String BA = "BA";
	public static final String BS = "BS";
	
	private JButton addSocio;
	private JButton searchSocios;
	private JLabel lSocios;
	
	
	public UsuariosPanel(){
		addSocio = new JButton("Añadir nuevo socio");
		addSocio.setActionCommand(BA);
		searchSocios = new JButton("Buscar socios");
		searchSocios.setActionCommand(BS);
		lSocios=new JLabel("Gestión de Socios");
		lSocios.setFont(new Font(null,Font.BOLD,32));
		lSocios.setBackground(Color.BLUE);
		
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
	
	public void setControlador(ActionListener c){
		addSocio.addActionListener(c);
		searchSocios.addActionListener(c);
		
	}
}
